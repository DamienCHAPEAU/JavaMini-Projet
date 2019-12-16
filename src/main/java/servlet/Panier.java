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
 * @author Clément
 */
@WebServlet(name = "Panier", urlPatterns = {"/Panier"})
public class Panier extends HttpServlet {

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

           List<Produit> p = new ArrayList<Produit>();
           
           Map<String, String> m = new LinkedHashMap<>();
           m = (Map<String, String>) request.getSession().getAttribute("map");
           
           
           for(Map.Entry<String, String> entry : m.entrySet()){
               
                Produit p2 = dao.produitCode(entry.getKey());
                Produit p3 = new Produit(p2.getReference(),p2.getNom(),p2.getCategorie(),p2.getPrix_unitaire(),Integer.valueOf(entry.getValue()));
                
                if(entry.getValue().equals("0")){
                
                    m.remove(entry.getKey());
                    
                }else{
                    p.add(p3);
                }
           }
           request.setAttribute("code", p);
           
          this.getServletContext().getRequestDispatcher("/panier.jsp").forward(request, response);

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
            Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
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
        
        
        String qteu = request.getParameter("qteu");
        String refu = request.getParameter("refu");
        
        Map<String, String> m = new LinkedHashMap<>();
        m = (Map<String, String>) request.getSession().getAttribute("map");
        
        m.put(refu, qteu);
        
        
        request.getSession().setAttribute("map", m);
        
        
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Panier.class.getName()).log(Level.SEVERE, null, ex);
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
