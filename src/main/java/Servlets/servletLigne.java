/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.DAO;
import DAO.DataSourceFactory;
import DAO.modele.Ligne;
import DAO.modele.Produit;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Clément
 */
@WebServlet(name = "ligneCommandes", urlPatterns = "/ligneCommandes")

public class servletLigne extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {


            try {	
                 HttpSession ses = request.getSession();
                String val2 = (String) ses.getAttribute("MDP");
                
                
                String val = request.getParameter("commande");
            
            
            DAO dao = new DAO(DataSourceFactory.getDataSource());
            //List<Commande> code = dao.commandes();
            List<Ligne> code = dao.ligneOfCommandes(Integer.valueOf(val));
            
            
            
             List<Produit> prod = new LinkedList<>();
            
             for(int i = 0; i< code.size(); i++){
                 Produit p = dao.produitCode(String.valueOf(code.get(i).getNumProduit()));
                 
                prod.add(new Produit(p.getReference(), p.getNom(), p.getCategorie(), p.getPrix_unitaire(), code.get(i).getQuantity())            );
            }
             
             if((code.get(0).getNumCommande())!=((dao.commandesOfClient(val2).get(0).getNumero()))){
                  
                 throw new IOException("client non verifié");
                  
             } 

            // On renseigne un attribut utilisé par la vue
            //request.setAttribute("code", code);
            request.setAttribute("prod", prod);
            request.setAttribute("commande", val);
            // On redirige vers la vue
            request.getRequestDispatcher("ligneCommandes.jsp").forward(request, response);

        } catch (IOException | ServletException e ) {
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
            Logger.getLogger(servletLigne.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(servletLigne.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(servletLigne.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(servletLigne.class.getName()).log(Level.SEVERE, null, ex);
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


