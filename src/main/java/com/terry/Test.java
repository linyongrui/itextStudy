package com.terry;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import jdk.jfr.ContentType;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test {

    public Test() throws IOException, DocumentException {
    }

    public void testItext() throws Exception {
        String folderStr = "C:\\temp\\report\\test\\";
        File folder = new File(folderStr);
        if (!folder.exists() && !folder.isDirectory()) {
            folder.mkdirs();
        }
        OutputStream os = new FileOutputStream(folderStr + (1 + Math.random() * 999) + ".pdf");
        Document document = new Document(PageSize.A5);


        PdfWriter pdfWriter = PdfWriter.getInstance(document, os);
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        PdfPCell cell = createPdfPCellNew("健康堂中醫診所",null,12f,Font.BOLD,Element.ALIGN_CENTER,false,false);
        PdfPCell cell2 = createPdfPCellNew("地址：九龍橫頭磡樂富廣場A區123舖",null,10f,Font.NORMAL,Element.ALIGN_CENTER,false,false);
        PdfPCell cell3 = createPdfPCellNew("電話：91119991",null,8f,Font.NORMAL,Element.ALIGN_CENTER,false,false);

        PdfPCell cell4 =new PdfPCell();
        cell4.setMinimumHeight(10f);
        cell4.setBorder(2);
        PdfPCell cell5 =new PdfPCell();
        cell5.setMinimumHeight(10f);
        cell5.setBorder(0);

        PdfPCell cell6 = createPdfPCellNew("到診證明書",null,8f,Font.BOLD,Element.ALIGN_CENTER,false,false);
        PdfPCell cell7 = createPdfPCellNew("Attendance Certificate",null,8f,Font.BOLD,Element.ALIGN_CENTER,false,false);

        PdfPCell cell8 =new PdfPCell();
        cell8.setMinimumHeight(25f);
        cell8.setBorder(0);

        PdfPCell cell9 = createPdfPCellNew("兹證明以下求診人：",null,6f,Font.NORMAL,Element.ALIGN_LEFT,false,false);
        PdfPCell cell10 = createPdfPCellNew("This is to certify the below-named patient",null,6f,Font.NORMAL,Element.ALIGN_LEFT,false,false);

        table.addCell(cell);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);
        table.addCell(cell5);
        table.addCell(cell6);
        table.addCell(cell7);
        table.addCell(cell8);
        table.addCell(cell9);
        table.addCell(cell10);
        document.open();
        document.add(table);
        document.close();

    }

    private static PdfPCell createPdfPCellNew(String content, ContentType contentType, Float fontSize, Integer fontStyle, Integer horizontalAlignment, boolean withBorder, boolean isColumnTitle) throws Exception{

        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font font = new Font(bfChinese,fontSize,fontStyle);
        Paragraph paragraph = new Paragraph(content, font);
        PdfPCell pdfPCell = new PdfPCell(paragraph);
        if (withBorder) {
            pdfPCell.setBorder(Rectangle.BOX);
        } else {
            pdfPCell.setBorder(Rectangle.NO_BORDER);
        }

        int defaultHorizontalAlignment = Element.ALIGN_LEFT;
        if (horizontalAlignment != null) {
            defaultHorizontalAlignment = horizontalAlignment;
        }
        pdfPCell.setHorizontalAlignment(defaultHorizontalAlignment);
        return pdfPCell;
    }
    public static void main(String[] args) throws Exception {
        new Test().testItext();
    }
}
