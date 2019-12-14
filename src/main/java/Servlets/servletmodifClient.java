/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.DAO;
import DAO.DAOException;
import DAO.DataSourceFactory;
import DAO.modele.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
@WebServlet(name = "updateInfo", urlPatterns = {"/updateInfo"})

public class servletmodifClient extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
          DAO dao = new DAO(DataSourceFactory.getDataSource());

            String CODE = (String) request.getSession().getAttribute("MDP");
            
          
        try {
            Client c = dao.getClient(CODE);
            
            if(c != null){
                
                
           
           request.setAttribute("societe", c.getSociete());
           request.setAttribute("fonction", c.getFonction());
           request.setAttribute("adresse", c.getAdresse());
           request.setAttribute("ville", c.getVille());
           
           request.setAttribute("region", c.getRegion());
           request.setAttribute("codepostal", c.getCodePostal());
           request.setAttribute("pays", c.getPays());
           request.setAttribute("telephone", c.getTelephone());
           request.setAttribute("fax", c.getFax());
            }
            
            } catch (DAOException | SQLException ex) {
            Logger.getLogger(servletmodifClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.getServletContext().getRequestDispatcher("/vue/viewClientupdate.jsp").forward(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
                            

        
        String CODE = (String) request.getSession().getAttribute("MDP");
        String Contact = request.getParameter("contact");
        String societe = request.getParameter("societe");
        String fonction = request.getParameter("fonction");
        String adresse = request.getParameter("adresse");
        String ville = request.getParameter("ville");
        String region = request.getParameter("region");
        String codepostal = request.getParameter("codepostal");
        String pays = request.getParameter("pays");
        String telephone = request.getParameter("telephone");
        String fax = request.getParameter("fax");
        
        DAO dao = new DAO(DataSourceFactory.getDataSource());
        
        
        try {
            
            
           
           
           
           
           dao.upClient(CODE, societe, Contact, fonction, adresse, ville, region, codepostal, pays, telephone, fax);
           
           this.getServletContext().getRequestDispatcher("/Client").forward(request, response);
           

        } catch (SQLException | IOException | ServletException ex) {
            Logger.getLogger(servletmodifClient.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (Exception ex) {
            Logger.getLogger(servletmodifClient.class.getName()).log(Level.SEVERE, null, ex);
        }

       
    }

}
