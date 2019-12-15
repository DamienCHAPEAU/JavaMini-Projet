package test;

import DAO.DAO;
import DAO.modele.Produit;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.hsqldb.cmdline.SqlFile;
import org.hsqldb.cmdline.SqlToolError;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DAOTest {
	private DAO myDAO; // L'objet à tester
	private DataSource myDataSource; // La source de données à utiliser
	private static Connection myConnection ; // La connection à la BD de test
	

	@Before
	public void setUp() throws SQLException, IOException, SqlToolError {
		// On utilise la base de données de test
		myDataSource = getTestDataSource();
		myConnection = myDataSource.getConnection();
		// On crée le schema de la base de test
		executeSQLScript(myConnection, "comptoirs_schema_derby.sql");
		// On y met des données
		executeSQLScript(myConnection, "comptoirs_data.sql");		
		
		myDAO = new DAO(myDataSource);
	}

	@After
	public void tearDown() throws IOException, SqlToolError, SQLException {
		myConnection.close(); // La base de données de test est détruite ici
             	
	}
	
	private void executeSQLScript(Connection connexion, String filename)  throws IOException, SqlToolError, SQLException {
		// On initialise la base avec le contenu d'un fichier de test
		String sqlFilePath = DAOTest.class.getResource(filename).getFile();
		SqlFile sqlFile = new SqlFile(new File(sqlFilePath));

		sqlFile.setConnection(connexion);
		sqlFile.execute();
		sqlFile.closeReader();		
	}
	
	/**
	 * Test of numberOfCustomers method, of class DAO.
     * @throws java.sql.SQLException
	 */
	/*@Test
	    public void testProduitCode() throws SQLException {
        System.out.println("testProduitCode");
        List<Produit> result = this.myDAO.produitCode();
        Produit expResult = new Produit(1, "Chai", 1, 1, "10 boîtes x 20 sacs", 90.00, 39, 0, 10, 0);
        // Premier test, on regarde que tout les produits sont présent
        assertEquals(result.size(), 69);
        // Deuxieme test on vérifie les données du premier produit
        assertEquals(expResult.getReference(), result.get(0).getReference());
        assertEquals(expResult.getNom(), result.get(0).getNom());        
        assertEquals(expResult.getCategorie(), result.get(0).getCategorie());
        assertEquals(expResult.getPrix_unitaire(), result.get(0).getPrix_unitaire());                
    }*/

	public static DataSource getTestDataSource() {
		org.hsqldb.jdbc.JDBCDataSource ds = new org.hsqldb.jdbc.JDBCDataSource();
		ds.setDatabase("jdbc:hsqldb:mem:testcase;shutdown=true");
		ds.setUser("sa");
		ds.setPassword("sa");
		return ds;
	}	
	
}
