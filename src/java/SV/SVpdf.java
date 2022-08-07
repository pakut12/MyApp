/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SV;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;
import java.net.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author pakutsing
 */
public class SVpdf extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DocumentException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            try {
                Document document = new Document();

                //Create OutputStream instance.
                OutputStream outputStream =
                        new FileOutputStream(new File(DB.ConnDB.getpathExport() + "TestTableFile.pdf"));

                //Create PDFWriter instance.
                PdfWriter.getInstance(document, outputStream);

                //Open the document.
                document.open();

                Font font = new Font(BaseFont.createFont(DB.ConnDB.getpathfont() + "THSarabunNew.ttf",
                        BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
                font.setSize(16);
                Font font1 = new Font(BaseFont.createFont(DB.ConnDB.getpathfont() + "THSarabunNew Bold.ttf",
                        BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
                font1.setSize(26);


                Paragraph h = new Paragraph("รายงาน", font1);
                h.setAlignment(Element.ALIGN_CENTER);

                document.add(h);
                document.add(new Paragraph("\n"));

                Paragraph d = new Paragraph("วันที่ : ", font);
                d.setAlignment(Element.ALIGN_RIGHT);

                document.add(d);
                document.add(new Paragraph("\n"));

                //Create Table object, Here 4 specify the no. of columns
                PdfPTable pdfPTable = new PdfPTable(4);

                PdfPCell H1 = new PdfPCell(new Paragraph("No"));
                PdfPCell H2 = new PdfPCell(new Paragraph("Name"));
                PdfPCell H3 = new PdfPCell(new Paragraph("SurName"));
                PdfPCell H4 = new PdfPCell(new Paragraph("Sc"));

                //Add cells to table
                pdfPTable.addCell(H1);
                pdfPTable.addCell(H2);
                pdfPTable.addCell(H3);
                pdfPTable.addCell(H4);

                int n = 0;//Create cells

                while (n < 100) {
                    PdfPCell pdfPCell1 = new PdfPCell(new Paragraph(Integer.toString(n + 1)));
                    PdfPCell pdfPCell2 = new PdfPCell(new Paragraph("Cell 2"));
                    PdfPCell pdfPCell3 = new PdfPCell(new Paragraph("Cell 3"));
                    PdfPCell pdfPCell4 = new PdfPCell(new Paragraph("Cell 4"));

                    //Add cells to table
                    pdfPTable.addCell(pdfPCell1);
                    pdfPTable.addCell(pdfPCell2);
                    pdfPTable.addCell(pdfPCell3);
                    pdfPTable.addCell(pdfPCell4);
                    n++;
                }


                //Add content to the document using Table objects.
                document.add(pdfPTable);

                //Close document and outputStream.
                document.close();
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
                out.print(e);
            }

        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DocumentException ex) {
            Logger.getLogger(SVpdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DocumentException ex) {
            Logger.getLogger(SVpdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
