/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SV;

import DB.ConnDB;
import java.io.*;
import java.net.*;
import DB.ConnDB.*;
import java.sql.*;

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
            PreparedStatement pr = null;
            ResultSet rec = null;
            try {
                String id = request.getParameter("txt1");
                String user = request.getParameter("txt2");
                String pass = request.getParameter("txt3");
                String page = null;
                String sql = "UPDATE tb_user SET " +
                        "tb_user.user = ?," +
                        "tb_user.pass = ? " +
                        "WHERE id = ?;";

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:4306/test" +
                        "?user=root&password=");

                pr = con.prepareStatement(sql);
                pr.setString(1, user);
                pr.setString(2, pass);
                pr.setString(3, id);

                if (pr.executeUpdate() > 0) {
                    page = "/table.jsp";
                } else {
                    page = "/edit.jsp";
                }

                RequestDispatcher rd = getServletContext().getRequestDispatcher(page);
                rd.forward(request, response);


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
