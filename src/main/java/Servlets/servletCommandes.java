/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import select.selectCommandes;



@WebServlet(name = "commandes", urlPatterns = "/viewCommandes")

/**
 *
 * @author pedago
 */
public class servletCommandes {
 
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {


            try {	
			String val = request.getParameter("client");
            
            
            selectCommandes dao = new selectCommandes(DataSourceFactory.getDataSource());
            List<Commande> E = dao.commandeOfClient(val);

            // On renseigne un attribut utilisé par la vue
            request.setAttribute("CODE", E);

            // On redirige vers la vue
            request.getRequestDispatcher("vue/mainjsp.jsp").forward(request, response);

        } catch (DAOException | IOException | SQLException | ServletException e) {
            Logger.getLogger("servlet").log(Level.SEVERE, "Erreur de traitement", e);
            // On renseigne un attribut utilisé par la vue

            // On redirige vers la page d'erreur
            request.getRequestDispatcher("vue/errorView.jsp").forward(request, response);
        }

    }
    
    
}
