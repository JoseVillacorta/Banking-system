package com.banking.ms_report.generator;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

@Component
public class PdfGenerator {

    public byte[] generateCollectionSheet(List<Map<String, Object>> data, String zoneId){
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try{
            PdfWriter.getInstance(document, out);
            document.open();

            // 1. Encabezado
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            Paragraph title = new Paragraph("BANCO EASYBANK - HOJA DE COBRO", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph("Zona: " + zoneId));
            document.add(Chunk.NEWLINE);

            // 2. Tabla de Datos
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setWidths(new float[]{3, 4, 2, 2});

            // Cabeceras de la tabla
            addTableHeader(table, "Cliente");
            addTableHeader(table, "Dirección");
            addTableHeader(table, "Monto");
            addTableHeader(table, "Firma");

            // Llenar datos
            for (Map<String, Object> row : data){
                table.addCell(row.get("customerName") != null ? row.get("customerName").toString() : "Sin Nombre");
                table.addCell(row.get("address") != null ? row.get("address").toString() : "Sin Dirección");
                table.addCell(row.get("pendingAmount") != null ? "$" + row.get("pendingAmount").toString() : "$0.00");
                table.addCell("");
            }

            document.add(table);
            document.close();
        } catch (DocumentException e){
            e.printStackTrace();
        }
        return out.toByteArray();
    }

    private void addTableHeader(PdfPTable table, String title){
        PdfPCell header = new PdfPCell();
        header.setBackgroundColor(Color.LIGHT_GRAY);
        header.setBorderWidth(2);
        header.setPhrase(new Phrase(title));
        table.addCell(header);
    }
}
