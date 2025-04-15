package lk.ijse.backend.util;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import lk.ijse.backend.DTO.ItemDTO;
import lk.ijse.backend.DTO.PlacePaymentDTO;

import java.io.ByteArrayOutputStream;


public class InvoiceGenerator {
    public static byte[] generateInvoicePDF(PlacePaymentDTO dto, long orderId) throws Exception {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(baos);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Add Logo
            String logoPath = "/Users/charithharsha/Documents/projects /partsLK/frontEnd/uren/assets/images/menu/logo/Parts LK Logo 2 Parts-2.png";
            ImageData imageData = ImageDataFactory.create(logoPath);
            Image logo = new Image(imageData);
            logo.setWidth(200);
            logo.setHeight(75);
            logo.setHorizontalAlignment(HorizontalAlignment.CENTER);
            document.add(logo);

// Add spacing
            document.add(new Paragraph("\n"));

// Header
            Paragraph header = new Paragraph("INVOICE")
                    .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
                    .setFontSize(20)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontColor(ColorConstants.BLUE);
            document.add(header);

            document.add(new Paragraph("\n"));


            // Order Info
            document.add(new Paragraph("Order ID: " + orderId));
            document.add(new Paragraph("Customer Name: " + dto.getCustomerName()));
            document.add(new Paragraph("Email: " + dto.getCustomerEmail()));
            document.add(new Paragraph("Address: " + dto.getCustomerAddress() + ", " + dto.getCity() + ", " + dto.getCountry()));
            document.add(new Paragraph("Payment Method: " + dto.getPaymentMethod()));
            document.add(new Paragraph("\n"));

            // Table Header
            Table table = new Table(UnitValue.createPercentArray(new float[]{4, 2, 2, 2}))
                    .useAllAvailableWidth();
            table.addHeaderCell("Item");
            table.addHeaderCell("Price");
            table.addHeaderCell("Quantity");
            table.addHeaderCell("Total");

            double grandTotal = 0;

            for (ItemDTO item : dto.getItemDTOS()) {
                table.addCell(item.getItemName());
                table.addCell(String.format("%.2f", item.getItemPrice()));
                table.addCell(String.valueOf(item.getItemQty()));
                double total = item.getItemPrice() * item.getItemQty();
                table.addCell(String.format("%.2f", total));
                grandTotal += total;
            }

            document.add(table);
            document.add(new Paragraph("\n"));

            // Total
            document.add(new Paragraph("Total Amount: Rs. " + String.format("%.2f", grandTotal))
                    .setBold()
                    .setFontSize(14));

            document.add(new Paragraph("\n"));

            // Footer message
            String footerMessage;
            if (dto.getPaymentMethod().equalsIgnoreCase("Direct Bank Transfer")) {
                footerMessage = "Make your payment directly into our bank account.\n" +
                        "Please use your Order ID as the payment reference.\n" +
                        "Your order won’t be shipped until the funds have cleared in our account.";
            } else {
                footerMessage = "Thank you for your purchase!";
            }

            document.add(new Paragraph(footerMessage)
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontColor(ColorConstants.DARK_GRAY)
                    .setFontSize(11)
                    .setItalic());

            document.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
