package com.tka.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.tka.model.CartItem;
import com.tka.model.OrderStatus;
import com.tka.model.Orders;
import com.tka.model.Product;
import com.tka.service.*;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {
    @Autowired private ProductService productService;
    @Autowired private CartService cartService;
    @Autowired private OrderService orderService;
    @Autowired private PdfService pdfService;
    @Autowired private EmailService emailService;

    @GetMapping("/products") public String getAllProducts(Model model){model.addAttribute("products",productService.getAllProducts());return "allProductsDetails";}
    @GetMapping("/shop") public String shopProducts(Model model,HttpSession session){
        if(isUserLoggedIn(session)){model.addAttribute("products",productService.getAllProducts());return "shop";}
        model.addAttribute("msg","Login first**");return "login";
    }
    @GetMapping("/cart") public String getCart(Model model,HttpSession session){
        if(!isUserLoggedIn(session)){model.addAttribute("msg","Login first**");return "login";}
        int cid=getCustomerId(session); List<CartItem> items=cartService.getCartItems(cid);
        model.addAttribute("cartItems",items);model.addAttribute("totalBill",cartService.getTotalBill(cid));return "cart";
    }
    @GetMapping("/add-to-cart/{pid}") public String addToCart(@PathVariable int pid,Model model,HttpSession session){
        if(!isUserLoggedIn(session)){model.addAttribute("msg","Login first**");return "login";}
        Product p=productService.getProductById(pid);cartService.addToCart(getCustomerId(session),pid);
        model.addAttribute("msg",p.getPname()+" >> added to cart successfully!!!");model.addAttribute("products",productService.getAllProducts());return "shop";
    }
    @GetMapping("/buy-now") public String buyProducts(Model model,HttpSession session){
        if(!isUserLoggedIn(session)){model.addAttribute("msg","Login first**");return "login";}
        int cid=getCustomerId(session);List<CartItem> items=cartService.getCartItems(cid);
        if(items.isEmpty()){model.addAttribute("msg","Your cart is empty!");model.addAttribute("cartItems",items);model.addAttribute("totalBill",0.0);return "cart";}
        model.addAttribute("cartItems",items);model.addAttribute("totalBill",cartService.getTotalBill(cid));return "bill";
    }
    @GetMapping("/remove-from-cart/{pid}") public String removeFromCart(@PathVariable int pid,HttpSession session,RedirectAttributes ra){
        if(!isUserLoggedIn(session))return "redirect:/login";cartService.removeFromCart(getCustomerId(session),pid);ra.addFlashAttribute("msg","Item removed from cart!");return "redirect:/cart";
    }
    @ModelAttribute public void addCartCount(Model model,HttpSession session){model.addAttribute("cartCount",isUserLoggedIn(session)?cartService.getCartCount(getCustomerId(session)):0);}
    @PostMapping("/confirm-order") public String confirmOrder(HttpSession session,RedirectAttributes ra){
        if(!isUserLoggedIn(session))return "redirect:/login";try{Orders o=orderService.createOrderFromCart(getCustomerId(session));session.setAttribute("pendingOrder",o);return "redirect:/payment";}
        catch(IllegalStateException e){ra.addFlashAttribute("msg",e.getMessage());return "redirect:/cart";}
    }
    @GetMapping("/payment") public String paymentPage(Model model,HttpSession session){
        if(!isUserLoggedIn(session))return "redirect:/login";Orders o=(Orders)session.getAttribute("pendingOrder");if(o==null)return "redirect:/cart";model.addAttribute("totalAmount",o.getTotalAmount());return "payment";
    }
    @PostMapping("/process-payment") public String processPayment(HttpSession session){
        if(!isUserLoggedIn(session))return "redirect:/login";Orders o=(Orders)session.getAttribute("pendingOrder");if(o==null)return "redirect:/cart";
        o.setStatus(OrderStatus.PAID);o=orderService.save(o);String email=(String)session.getAttribute("email");
        byte[] pdf=pdfService.generateBillPdf(o.getItems(),o.getTotalAmount(),email);emailService.sendBillWithAttachment(email,pdf);
        session.setAttribute("invoicePdf",pdf);cartService.clearCart(getCustomerId(session));session.removeAttribute("pendingOrder");return "redirect:/payment-success";
    }
    @GetMapping("/download-invoice") public ResponseEntity<byte[]> downloadInvoice(HttpSession session){
        byte[] pdf=(byte[])session.getAttribute("invoicePdf");if(pdf==null)return ResponseEntity.notFound().build();
        return ResponseEntity.ok().header("Content-Disposition","inline; filename=invoice.pdf").header("Content-Type","application/pdf").body(pdf);
    }
    private boolean isUserLoggedIn(HttpSession s){return "user".equals(s.getAttribute("log"))&&s.getAttribute("id")!=null;}
    private int getCustomerId(HttpSession s){return (Integer)s.getAttribute("id");}
}
