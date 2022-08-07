/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SV;

import java.io.*;

import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
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

            XSSFWorkbook workbook = new XSSFWorkbook(Pathfolder);
            XSSFSheet sheet = workbook.getSheetAt(0);

            int rows = sheet.getLastRowNum();
            int cols = sheet.getRow(1).getFirstCellNum();
            ArrayList<String> arr = new ArrayList<String>();

            for (int a = 0; a <= rows; a++) {
                String vOutput = Function.Excel.Read(a, 2, Pathfolder);
                arr.add(vOutput);
            }

            for (String row : arr) {
                out.print(row);
            }





//
//            File file = new File(Pathfolder);   //creating a new file instance  
//
//            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
////creating Workbook instance that refers to .xlsx file  
//
//            XSSFWorkbook wb = new XSSFWorkbook(fis);
//            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
//
//            Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
//
//            while (itr.hasNext()) {
//                Row row = itr.next();
//                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
//
//                while (cellIterator.hasNext()) {
//                    Cell cell = cellIterator.next();
//                    switch (cell.getCellType()) {
//                        case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
//
//                            System.out.print(cell.getStringCellValue() + "\t\t\t");
//                            break;
//                        case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
//
//                            System.out.print(cell.getNumericCellValue() + "\t\t\t");
//                            break;
//                        default:
//                    }
//                }
//                System.out.println("");
//            }
/////////////////////////////////////////////////////////////////////////










////////////////////////////////////////////////////////////////////////////////////////
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
