<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html><html><head><meta charset="UTF-8"><title>Shopmate|Cart</title><link rel="stylesheet" type="text/css" href="/css/style.css"></head>
<body><%@ include file="header.jsp" %>
<c:if test="${not empty msg}"><div id="toast" class="toast success">${msg}</div></c:if>
<div class="cart-container"><h2 class="cart-title">🛒 Your Cart</h2>
<c:choose><c:when test="${empty cartItems}"><div style="text-align:center;padding:30px"><p>Your cart is empty.</p><a href="/shop" class="buy-now-btn">Continue Shopping</a></div></c:when><c:otherwise>
<div class="cart-table-wrapper"><table class="cart-table"><thead><tr><th>Product</th><th>Category</th><th>Price</th><th>Quantity</th><th>Subtotal</th><th>Remove</th></tr></thead><tbody>
<c:forEach var="item" items="${cartItems}"><tr><td>${item.product.pname}</td><td><c:choose><c:when test="${item.product.category != null}">${item.product.category.name}</c:when><c:otherwise>${item.product.legacyCategory}</c:otherwise></c:choose></td><td>₹ ${item.product.price}</td><td>${item.quantity}</td><td>₹ ${item.product.price * item.quantity}</td><td><a href="/remove-from-cart/${item.product.pid}" class="remove-btn">Remove</a></td></tr></c:forEach>
</tbody></table></div><div class="cart-summary"><h3>Total Bill: ₹ ${totalBill}</h3><a href="/buy-now" class="buy-now-btn">Proceed to Checkout →</a></div>
</c:otherwise></c:choose></div><%@ include file="footer.jsp" %>
<script>setTimeout(function(){var t=document.getElementById('toast');if(t)t.style.display='none';},2500);</script></body></html>
