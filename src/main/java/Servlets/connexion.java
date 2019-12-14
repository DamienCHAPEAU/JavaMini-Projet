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
        String Contact = request.getParameter("LOG");
        String MDP = request.getParameter("MDP");

        DAO dao = new DAO(DataSourceFactory.getDataSource());
        
        try {
            Client c2 = dao.LOGIN(Contact, MDP);
            
            
            if(c2 == null){
                this.getServletContext().getRequestDispatcher("/vue/errorView.jsp").forward(request, response);
            }
            
           
            else {
                    HttpSession session = request.getSession();
                    session.setAttribute("client", Contact);
                    session.setAttribute("MDP", MDP);
                    Logger.getLogger("IDENTIFIANT OK");
                    
                    this.getServletContext().getRequestDispatcher("/member.jsp").forward(request, response);
                    
            }

        } catch (SQLException | IOException | ServletException ex) {
            Logger.getLogger(connexion.class.getName()).log(Level.SEVERE, null, ex);
        
        }

       
    }

}
