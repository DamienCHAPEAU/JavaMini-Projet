/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.DAO;
import DAO.DataSourceFactory;
import DAO.modele.Produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author licence
 */
@WebServlet(name = "servletAdminProd", urlPatterns = {"/servletAdminProd"})
public class servletAdminProd extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
            
        DAO dao = new DAO(DataSourceFactory.getDataSource());
        
        List<Produit> code = dao.produitCode();
        request.setAttribute("code", code);
        
        this.getServletContext().getRequestDispatcher("/adminProd.jsp").forward(request, response);
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(servletAdminProd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        DAO dao = new DAO(DataSourceFactory.getDataSource());
        
        String update =  (String) request.getParameter("refUPDATE");
        String nomUpdate = (String) request.getParameter("nomU");
        
        String catUpdate = request.getParameter("catU");
        
        String prixUpdate = (String) request.getParameter("prixU");
        
        request.setAttribute("messageUpdate", "produit : "+nomUpdate+" mis à jour");
        try {
            dao.updateProduit(update, nomUpdate, Integer.valueOf(catUpdate), Double.parseDouble(prixUpdate));
        } catch (SQLException ex) {
            Logger.getLogger(servletAdminProd.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        //    this.getServletContext().getRequestDispatcher("/servletAddUpdateProd.jsp").forward(request, response);
        
        
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(servletAdminProd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
