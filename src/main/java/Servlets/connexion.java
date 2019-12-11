/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DAO.DAO;
import DAO.DataSourceFactory;
import DAO.modele.Client;
import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class Test
 */
@WebServlet(name = "connexion", urlPatterns = {"/connexion"})

public class connexion extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/connexion.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String LOG = request.getParameter("LOG");
        String MDP = request.getParameter("MDP");

        DAO dao = new DAO(DataSourceFactory.getDataSource());
        
        try {
            Client c2 = dao.LOGIN(LOG, MDP);

            Client c = new Client(LOG,MDP);
            
           
            if (c2.equals(c)) {
                 HttpSession session = request.getSession();

                    session.setAttribute("LOG", LOG);
                    session.setAttribute("MDP", MDP);
                    Logger.getLogger("IDENTIFIANT OK");
                    this.getServletContext().getRequestDispatcher("/viewCommandes.jsp").forward(request, response);
                    
            }else{
                throw new Exception("client inconnu ou mauvais MDP : "+LOG+" "+MDP);
            }

        } catch (SQLException ex) {
            Logger.getLogger(connexion.class.getName()).log(Level.SEVERE, null, ex);
        
        } catch (Exception ex) {
            Logger.getLogger(connexion.class.getName()).log(Level.SEVERE, null, ex);
        }

       
    }

}
