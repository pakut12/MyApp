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
import jxl.Workbook;
import jxl.write.*;

/**
 *
 * @author pakutsing
 */
public class SVexportexcel extends HttpServlet {

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

            try {
                String sql = "SELECT * FROM `tb_user`;";

                ArrayList<String> id = DB.ConnDB.getsqldata(sql, "id");
                ArrayList<String> user = DB.ConnDB.getsqldata(sql, "user");
                ArrayList<String> pass = DB.ConnDB.getsqldata(sql, "pass");

                String fileName = DB.ConnDB.getpathExport() + "ExportExcelToLocal.xls";

                WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName));

                WritableSheet ws1 = workbook.createSheet("mySheet1", 0);

                //หัวเรื่อง
                ws1.addCell(new Label(0, 0, "id"));
                ws1.addCell(new Label(1, 0, "Name"));
                ws1.addCell(new Label(2, 0, "Sum"));
                //จบหัวเรื่อง

                for (int n = 0; n < user.size(); n++) {

                    //เนื้อหา
                    ws1.addCell(new Label(0, n + 1, id.get(n)));
                    ws1.addCell(new Label(1, n + 1, user.get(n)));
                    ws1.addCell(new Label(2, n + 1, pass.get(n)));
                //จบเนื้อหา
                }

                workbook.write();
                workbook.close();

                out.println("Excel file created.");
                out.println(fileName);
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
