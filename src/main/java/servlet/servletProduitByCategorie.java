/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.modele.Categorie;
import DAO.DAO;
import DAO.DataSourceFactory;
import DAO.modele.Produit;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pedago
 */
@WebServlet(name = "ProduitsByCategorie", urlPatterns = {"/ProduitsByCategorie"})
public class servletProduitByCategorie extends HttpServlet {

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

        try {
            String val = request.getParameter("categorie");
            int valInt = Integer.parseInt(val);
            DAO dao = new DAO(DataSourceFactory.getDataSource());
            List<Produit> code = dao.produitByCategorieCode(valInt);
            request.setAttribute("code", code);

        } catch (Exception ex) {
            Logger.getLogger("servlet").log(Level.SEVERE, "Erreur de traitement", ex);
            request.setAttribute("message", ex.getMessage());
        }
        request.getRequestDispatcher("viewProduitByCategorie.jsp").forward(request, response);
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
            Logger.getLogger(servletListCategorie.class.getName()).log(Level.SEVERE, null, ex);
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
        String qte = request.getParameter("qte");
        String ref = request.getParameter("ref");

        Map<String, String> map;

        if (request.getSession().getAttribute("map") == null) {
            map = new LinkedHashMap<>();

            map.put(ref, qte);
        } else {
            map = (Map<String, String>) request.getSession().getAttribute("map");
            map.put(ref, qte);

        }

        request.setAttribute("MessageprodCat", "id : " + ref + "  ajouté " + qte + " fois au panier");
        request.getSession().setAttribute("map", map);

        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(servletListCategorie.class.getName()).log(Level.SEVERE, null, ex);
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
