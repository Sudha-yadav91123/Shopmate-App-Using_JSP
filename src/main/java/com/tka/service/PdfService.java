package com.tka.service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.tka.model.OrderItem;

@Service
public class PdfService {
    public byte[] generateBillPdf(List<OrderItem> items, double totalBill, String email) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            PdfDocument pdf = new PdfDocument(new PdfWriter(baos));
            pdf.setDefaultPageSize(PageSize.A4);
            Document doc = new Document(pdf); doc.setMargins(20,20,20,20);
            doc.add(new Paragraph("SHOPMATE INVOICE").setBold().setFontSize(22).setTextAlignment(TextAlignment.CENTER));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("Invoice No: " + UUID.randomUUID().toString().substring(0,8)));
            doc.add(new Paragraph("Date: " + LocalDate.now()));
            doc.add(new Paragraph("Customer Email: " + email)); doc.add(new Paragraph("\n"));
            Table table = new Table(UnitValue.createPercentArray(new float[]{4,2,1.5f,2})).useAllAvailableWidth();
            for (String h : new String[]{"Product","Price","Qty","Subtotal"}) table.addHeaderCell(new Cell().add(new Paragraph(h).setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY));
            for (OrderItem item : items) {
                table.addCell(new Cell().add(new Paragraph(item.getProduct().getPname())).setBorder(new SolidBorder(1)));
                table.addCell(new Cell().add(new Paragraph("₹ " + item.getPrice())).setBorder(new SolidBorder(1)));
                table.addCell(new Cell().add(new Paragraph(String.valueOf(item.getQuantity()))).setBorder(new SolidBorder(1)));
                table.addCell(new Cell().add(new Paragraph("₹ " + item.getSubtotal())).setBorder(new SolidBorder(1)));
            }
            doc.add(table); doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("Total Amount: ₹ " + totalBill).setBold().setFontSize(16).setTextAlignment(TextAlignment.RIGHT));
            doc.add(new Paragraph("\nThank you for shopping with ShopMate!").setTextAlignment(TextAlignment.CENTER).setFontColor(ColorConstants.DARK_GRAY));
            doc.close();
        } catch (Exception e) { e.printStackTrace(); }
        return baos.toByteArray();
    }
}
