/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SV;

import java.io.*;
import java.net.*;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;

import org.json.simple.*;
import org.json.simple.parser.*;

/**
 *
 * @author pakutsing
 */
public class SVjson extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            try {

                String sql = "SELECT * FROM `tb_user`;";

                ArrayList<String> id = DB.ConnDB.getsqldata(sql, "id");
                ArrayList<String> user = DB.ConnDB.getsqldata(sql, "user");
                ArrayList<String> pass = DB.ConnDB.getsqldata(sql, "pass");
                ArrayList<String> status = DB.ConnDB.getsqldata(sql, "status");

                JSONObject obj = new JSONObject();
                ArrayList arrlist = new ArrayList();

                for (int n = 0; n < id.size(); n++) {
                    JSONArray arrjson = new JSONArray();
                    arrjson.add(id.get(n));
                    arrjson.add(user.get(n));
                    arrjson.add(pass.get(n));
                    arrjson.add(status.get(n));

                    arrlist.add(arrjson);
                }

                obj.put("draw", 0);
                obj.put("recordsTotal", id.size());
                obj.put("recordsFiltered", id.size());
                obj.put("data", arrlist);

                out.print(obj);

            // obj.put("data", out);


//                JSONObject obj = new JSONObject();
//                obj.put("name", "mkyong.com");
//                obj.put("age", 100);
//
//                JSONArray list = new JSONArray();
//                list.add("msg 1");
//                list.add("msg 2");
//                list.add("msg 3");
//
//                obj.put("messages", list);
//
//                out.print(obj);
//
//
//                JSONParser parser = new JSONParser();
//                JSONObject jsonObject = (JSONObject) parser.parse(obj.toJSONString());
//                out.print("<br>");
//                String name = (String) jsonObject.get("name");
//                out.print(name);
//
//
//              
//                request.setAttribute("json", name);
//                RequestDispatcher rd = getServletContext().getRequestDispatcher("/json.jsp");
//                rd.forward(request, response);

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
        } catch (ParseException ex) {
            Logger.getLogger(SVjson.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException ex) {
            Logger.getLogger(SVjson.class.getName()).log(Level.SEVERE, null, ex);
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
