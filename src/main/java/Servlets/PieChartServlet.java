import DAO.DAO;
import DAO.DataSourceFactory;
import DAO.modele.ChiffreAffaire;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class PieChartServlet
 */
    @WebServlet("/PieChartServlet")
public class PieChartServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        
        try {
                        
                        String datesaisie = request.getParameter("Saisie_le");
                        String dateenvoyee = request.getParameter("Envoyee_le");
                        			
			DAO dao = new DAO(DataSourceFactory.getDataSource());
                        List<ChiffreAffaire> code = dao.caByClient(datesaisie, dateenvoyee);
                        request.setAttribute("code", code);		
			
		
                } catch (Exception ex) {
			Logger.getLogger("servlet").log(Level.SEVERE, "Erreur de traitement", ex);
                        request.setAttribute("message", ex.getMessage());
		}
                request.getRequestDispatcher("piecharttest.jsp").forward(request, response);
        
 
        
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    }
}