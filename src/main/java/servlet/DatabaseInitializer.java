package servlet;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import DAO.DAO;
import DAO.DataSourceFactory;
import DAO.modele.Client;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import org.apache.derby.tools.ij;
import org.apache.ibatis.jdbc.ScriptRunner;

/**
 * Web application lifecycle listener, initialise la base de données au
 * démarrage de l'application si nécessaire
 */
@WebListener()
public class DatabaseInitializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        if (!databaseExists()) {
            initializeDatabase2();
            fillDatabase();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    private boolean databaseExists() {
        boolean result = false;

        DAO dao = new DAO(DataSourceFactory.getDataSource());
        try {
            List<Client> allCodes = dao.allCodes();
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Database already exists");
            result = true;
        } catch (SQLException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Database does not exist");
        }
        return result;
    }

    private void initializeDatabase() {
        OutputStream nowhere = new OutputStream() {
            @Override
            public void write(int b) {
            }
        };

        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Creating databse from SQL script");
        try {
            Connection connection = DataSourceFactory.getDataSource().getConnection();
            int result = ij.runScript(connection, this.getClass().getResourceAsStream("comptoirs_schema_derby.sql"), "UTF-8", System.out /* nowhere */, "UTF-8");
            if (result == 0) {
                Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Database succesfully created");
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Errors creating database");
            }

        } catch (UnsupportedEncodingException | SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        }

    }

    private void initializeDatabase2() {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Creating databse from SQL script");
        try (Connection connection = DataSourceFactory.getDataSource().getConnection();) {
            ScriptRunner runner = new ScriptRunner(connection);
            runner.setLogWriter(null);
            Reader schema = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("comptoirs_schema_derby.sql")));
            runner.runScript(schema);
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        }
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Database succesfully created");

    }

    private void fillDatabase() {
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Filling database");
        try (Connection connection = DataSourceFactory.getDataSource().getConnection();) {
            ScriptRunner runner = new ScriptRunner(connection);
            runner.setLogWriter(null); // Prevent spamming the console
            Reader data = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("comptoirs_data.sql")));
            runner.runScript(data);
        } catch (SQLException e) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, e);
        }
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, "Database succesfully fill");
    }
}
