/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SV;

import DB.ConnDB;
import java.io.*;
import java.net.*;
import DB.ConnDB.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.el.ELException;

/**
 *
 * @author Gus
 */
public class SVedit extends HttpServlet {

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

            Statement s = null;
            Connection con = null;
            try {
                String id = request.getParameter("txt1");
                String user = request.getParameter("txt2");
                String pass = request.getParameter("txt3");

                String sql = "UPDATE tb_user SET tb_user.user = '" + user + "' ,tb_user.pass = '" + pass + "' WHERE id ='" + id + "';";

                boolean status = DB.ConnDB.getsql(sql);
                String page = null;
                if (status) {
                    page = "/home.jsp";
                } else {
                    page = "page/edit.jsp?id=" + id;
                }

                RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
                rd.forward(request, response);


            } catch (Exception e) {
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
            Logger.getLogger(SVedit.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(SVedit.class.getName()).log(Level.SEVERE, null, ex);
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
