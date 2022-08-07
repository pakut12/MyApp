/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SV;

import java.io.*;
import java.net.*;

import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
import jxl.*;

import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author pakutsing
 */
public class SVexcel extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String w = request.getParameter("path");
            String Pathfolder = DB.ConnDB.getpathupload() + w;
            String x = null;
            out.print(Pathfolder);

                InputStream ExcelFileToRead = new FileInputStream("C:/Test.xlsx");
                XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);

                XSSFWorkbook test = new XSSFWorkbook();

                XSSFSheet sheet = wb.getSheetAt(0);
                XSSFRow row;
                XSSFCell cell;

                Iterator rows = sheet.rowIterator();

                while (rows.hasNext()) {
                    row = (XSSFRow) rows.next();
                    Iterator cells = row.cellIterator();
                    while (cells.hasNext()) {
                        cell = (XSSFCell) cells.next();

                        if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                            System.out.print(cell.getStringCellValue() + " ");
                        } else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
                            System.out.print(cell.getNumericCellValue() + " ");
                        } else {
                            //U Can Handel Boolean, Formula, Errors
                        }
                    }
                    System.out.println();
                }



//            String w = request.getParameter("path");
//            String Pathfolder = DB.ConnDB.getpathupload() + w;
//            String x = null;
//
//            try {
//
//                String FilePath = Pathfolder;
//
//                Workbook workbook = Workbook.getWorkbook(new File(FilePath));
//                
//                ArrayList<Integer> id = new ArrayList<Integer>();
////            ArrayList<String> id = new ArrayList<String>();
//                ArrayList<String> VNAME = new ArrayList<String>();
//                ArrayList<String> VADD1 = new ArrayList<String>();
//                ArrayList<String> VADD2 = new ArrayList<String>();
//                ArrayList<String> VTEFX = new ArrayList<String>();
//                ArrayList<String> LIFNR = new ArrayList<String>();
//                ArrayList<String> XBLNR = new ArrayList<String>();
//                ArrayList<String> BUDAT = new ArrayList<String>();
//                ArrayList<String> EBELN = new ArrayList<String>();
//                ArrayList<String> WRBTR = new ArrayList<String>();
//
//                Sheet ws = workbook.getSheet(0);
//                Cell Cid, CVNAME, CVADD1, CVADD2, CVTEFX, CLIFNR, CXBLNR, CBUDAT, CEBELN, CWRBTR;
//
//                for (int i = 1; i < ws.getRows(); i++) {
//
//                    Cid = ws.getCell(0, i);
//                    id.add(Integer.valueOf(Cid.getContents()));
//
//                    CVNAME = ws.getCell(5, i);
//                    VNAME.add(CVNAME.getContents());
//
//                    out.print(CVNAME.getContents() + "<br>");
//
//                }
//
//                workbook.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }



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
    protected

     void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
