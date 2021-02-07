package com.app.export;

import java.awt.Color;
import java.io.IOException;


import javax.servlet.http.HttpServletResponse;

import com.app.entities.ConfiguredPc;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class ConfiguredPCPdfExporter {

	private ConfiguredPc configuredPc;

	
	  public ConfiguredPCPdfExporter(ConfiguredPc configuredPc) {
	  this.configuredPc = configuredPc; 
	  }
	 
	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.DARK_GRAY);
		cell.setPadding(5);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);


		cell.setPhrase(new Phrase("PC Type", font));// 2

		table.addCell(cell);

		cell.setPhrase(new Phrase("RAM Memory", font));// 3

		table.addCell(cell);

		cell.setPhrase(new Phrase("Graphics Card", font));// 4

		table.addCell(cell);

		cell.setPhrase(new Phrase("CPU", font));// 5

		table.addCell(cell);

		cell.setPhrase(new Phrase("CPU Case", font));// 6

		table.addCell(cell);

		cell.setPhrase(new Phrase("CPU Cooler", font));// 7

		table.addCell(cell);

		cell.setPhrase(new Phrase("Monitor", font));// 8

		table.addCell(cell);

		cell.setPhrase(new Phrase("MotherBoard", font));// 9

		table.addCell(cell);

		cell.setPhrase(new Phrase("Operating System", font));// 10

		table.addCell(cell);

		cell.setPhrase(new Phrase("Optical Drive", font));// 11

		table.addCell(cell);

		cell.setPhrase(new Phrase("Power Supply", font));// 12

		table.addCell(cell);

		cell.setPhrase(new Phrase("Storage", font));// 13

		table.addCell(cell);

		cell.setPhrase(new Phrase("Price", font));// 14

		table.addCell(cell);

	}

	private void writeTableData(PdfPTable table) {
		//for (ConfiguredPc configuredPc : configuredPc) {
			table.addCell(configuredPc.getType());// 2
			configuredPc.getRamMemory().forEach(memory -> table.addCell("Brand :     "+memory.getBrand() + "\n\nName : " + memory.getName()));// 3
			
			configuredPc.getGraphicsCard().forEach(card -> table.addCell("Brand :"+card.getBrand() + "\n\nName : " + card.getName()));// 4
			
			table.addCell("Brand :     "+configuredPc.getCpu().getBrand() + "\n\nName :  " + configuredPc.getCpu().getName());// 5

			table.addCell("Brand :     "+configuredPc.getCpuCase().getBrand() + "\n\nName : " + configuredPc.getCpuCase().getName());// 6

			table.addCell("Brand :     "+configuredPc.getCpuCooler().getBrand() + "\n\nName : " + configuredPc.getCpuCooler().getName());// 7

			table.addCell("Brand :       "+configuredPc.getMonitor().getBrand() + "\n\nName : " + configuredPc.getMonitor().getName());// 8
 
			table.addCell("Brand :       "+configuredPc.getMotherBoard().getBrand() + "\n\nName: " + configuredPc.getMotherBoard().getName());// 9

			table.addCell("Brand :        "+
					configuredPc.getOperatingSystem().getBrand() + "\n\nName :" + configuredPc.getOperatingSystem().getName());// 10

			table.addCell("Brand :     "+configuredPc.getOpticalDrive().getBrand() + " \n\nName : " + configuredPc.getOpticalDrive().getName());// 11

			table.addCell("Brand :        "+configuredPc.getPowerSupply().getBrand() + "\n\nName :  " + configuredPc.getPowerSupply().getName());// 12

			configuredPc.getStorage().forEach(storage -> table.addCell("Brand :     "+storage.getBrand() + "\n\nName :" + storage.getName()));// 13

			table.addCell(String.valueOf(configuredPc.getPrice()));// 14

		
	}
	
	 public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4.rotate());
	        
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.BLACK);
	         
	        Paragraph p = new Paragraph("CONFIGURED COMPONENTS LIST", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	        
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(13);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {4.2f, 4.0f, 4.2f, 3.0f, 3.0f,3.5f,4.0f,5.5f,5.0f,4.2f,4.3f,4.0f,3.5f});
	        table.setSpacingBefore(10);
	         
	        writeTableHeader(table);
	        writeTableData(table);
	         
	        document.add(table);
	         
	        document.close();
	         
	    }
}