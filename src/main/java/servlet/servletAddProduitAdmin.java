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
 * @author damsc
 */
@WebServlet(name = "AddProduitAdmin", urlPatterns = {"/AddProduitAdmin"})
public class servletAddProduitAdmin extends HttpServlet {

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

        this.getServletContext().getRequestDispatcher("/adminAddProd.jsp").forward(request, response);

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
            Logger.getLogger(servletModProduitAdmin.class.getName()).log(Level.SEVERE, null, ex);
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

        String addNom = (String) request.getParameter("name");
        String addFournisseur = (String) request.getParameter("fourn");
        String addCat = request.getParameter("cat");
        String addQtUnit = request.getParameter("qt");
        String addPrix = (String) request.getParameter("prix");
        String addUnitStock = (String) request.getParameter("stock");
        String addUnitComm = (String) request.getParameter("commande");
        String addNiveauAppro = (String) request.getParameter("appro");
        String addIndispo = (String) request.getParameter("indis");

        Produit p = new Produit(addNom, Integer.valueOf(addFournisseur), Integer.valueOf(addCat), addQtUnit, Double.parseDouble(addPrix), Integer.valueOf(addUnitStock), Integer.valueOf(addUnitComm), Integer.valueOf(addNiveauAppro), Integer.valueOf(addIndispo));

        request.setAttribute("messageAdd", "produit : " + addNom);
        try {
            dao.addProduit(p);
        } catch (SQLException ex) {
            Logger.getLogger(servletModProduitAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(servletModProduitAdmin.class.getName()).log(Level.SEVERE, null, ex);
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
