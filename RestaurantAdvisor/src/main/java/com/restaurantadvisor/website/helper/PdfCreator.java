package com.restaurantadvisor.website.helper;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.restaurantadvisor.website.model.LoginDetails;
import com.restaurantadvisor.website.model.OrderDetails;

public class PdfCreator {

	public static void createPdf (List<OrderDetails> orderDetails, LoginDetails loginDetails,
			HttpServletResponse response) {
		
		response.setContentType("application/pdf");
		Document document = new Document();
		
		PdfWriter pdfWriter = null;
		
		try {
			pdfWriter = PdfWriter.getInstance(document, response.getOutputStream());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.open();
		
		try {
			document.add(new Paragraph("Order Details of :" + loginDetails.getUserDetails().getFirstName() + ", " + loginDetails.getUserDetails().getLastName()));
			document.add(new Paragraph());
			document.add(new Paragraph());
			document.add(new Paragraph());
			document.add(new Paragraph());
			document.add(new Paragraph("---------------------------------------------------------------"));
			float grandTotal = 0.0f;
			for (OrderDetails orderDetailsPassed : orderDetails) {
				
				int qty = orderDetailsPassed.getQuantity();
				float up = orderDetailsPassed.getMenuDetails().getPrice();
				float total = qty * up;
				grandTotal = grandTotal + total;
				document.add(new Paragraph("Item :" + orderDetailsPassed.getMenuDetails().getItem() + " | " 
						+ "Qty :" + qty + " | " 
						+ "Unit Price : $" + up + " | "
						+ "Total : $" + total));
						
			}
			
			document.add(new Paragraph());
			document.add(new Paragraph());
			document.add(new Paragraph("---------------------------------------------------------------"));
			document.add(new Paragraph("Grand Total: $ " + grandTotal));
			document.add(new Paragraph("---------------------------------------------------------------"));
			
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		document.close();
	}
}
