/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.Categorie;
import DAO.Commande;
import DAO.DAO;
import DAO.DAOException;
import DAO.DataSourceFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet(name = "Commandes", urlPatterns = "/Commandes")

/**
 *
 * @author pedago
 */
public class servletCommandes extends HttpServlet{
 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {


            try {	
            //String val = request.getParameter("client");
            
            
            DAO dao = new DAO(DataSourceFactory.getDataSource());
            //List<Commande> E = dao.commandes();
            List<Categorie> code = dao.listCategorieCode();                        


            // On renseigne un attribut utilisé par la vue
            request.setAttribute("code", code);

            // On redirige vers la vue
            request.getRequestDispatcher("viewCommandes.jsp").forward(request, response);

        } catch (IOException | SQLException | ServletException e) {
            Logger.getLogger("servlet").log(Level.SEVERE, "Erreur de traitement", e);
            // On renseigne un attribut utilisé par la vue

            // On redirige vers la page d'erreur
            request.getRequestDispatcher("vue/errorView.jsp").forward(request, response);
        }

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
        } catch (Exception ex) {
            Logger.getLogger(servletCommandes.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(servletListCategorie.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(servletCommandes.class.getName()).log(Level.SEVERE, null, ex);
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
