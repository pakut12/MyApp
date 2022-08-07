/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SV;

import java.io.*;
import java.net.*;
import DB.ConnDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;


/**
 *
 * @author Gus
 */
public class SVlogin extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String user = request.getParameter("txt1");
            String pass = request.getParameter("txt2");
            String page = null;
            String sql = "SELECT * FROM `tb_user` WHERE tb_user.user ='" + user + "' and tb_user.pass = '" + pass + "';";
            ArrayList<String> arr = DB.ConnDB.getsqldata(sql, "user");
            String status = null;
            int n = 0;
            try {
                if (arr.size() == 0) {
                    page = "/index.jsp";
                    status = "N";
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", arr.get(0));
                    
                    
                    status = "Y";
                    page = "/home.jsp";
                }


                request.setAttribute("status", status);

                RequestDispatcher rdp = getServletContext().getRequestDispatcher(page);
                rdp.forward(request, response);

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
        } catch (SQLException ex) {
            Logger.getLogger(SVlogin.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(SVlogin.class.getName()).log(Level.SEVERE, null, ex);
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
