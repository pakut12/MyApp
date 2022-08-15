/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SV;

import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.*;
import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author pakutsing
 */
public class SVsap extends HttpServlet {

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
//            try {
//                JCO.Client client = null;
//                client = ConnectSap.createClient();
//                out.print(client);
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            } catch (ExceptionInInitializerError e) {
//                e.printStackTrace();
//            } catch (Throwable e) {
//                e.printStackTrace();
//            } 


            try {


                // Get a client from the pool
                


////////                PreparedStatement pstmtCp = con.prepareStatement("SELECT PRODUCT_GROUP_ID, PLANT, DELIVER_PLANT,SALES_ORG, " +
////////                        "   DISTR_CHANNEL, STORAGE_LOC, CREATE_BY,    CREATE_DATE, UPD_BY, UPD_DATE " +
////////                        "   FROM PGCA.BM_PRODUCT_COPYTOPLANT  " +
////////                        "   WHERE PRODUCT_GROUP_ID = ?  ");
////////                pstmtCp.setString(1, rs.getString("PRODUCT_GROUP_ID"));
////////                ResultSet rsCp = pstmtCp.executeQuery();
////////
////////                JCO.ParameterList inputPlantList = function1.getTableParameterList();
////////                JCO.Table inputPlant = inputPlantList.getTable("COPYTOPLANT");
////////
////////                while (rsCp.next()) {
////////
////////                    inputPlant.appendRow();
////////                    inputPlant.setValue(rsCp.getString("PLANT"), "PLANT");
////////                    inputPlant.setValue(rsCp.getString("STORAGE_LOC"), "STGE_LOC");
////////                    inputPlant.setValue(rsCp.getString("SALES_ORG"), "SALES_ORG");
////////                    inputPlant.setValue(rsCp.getString("DISTR_CHANNEL"), "DISTR_CHAN");
////////                    inputPlant.setValue(rsCp.getString("DELIVER_PLANT"), "DELYG_PLNT");//Deliver.Plant     DELYG_PLNT
////////
////////                }
            } catch (Exception e) {
                e.printStackTrace();
            } catch (Error e) {
                e.printStackTrace();
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
