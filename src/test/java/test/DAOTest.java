/*package test;

import DAO.DAO;
import DAO.DAOException;
import DAO.modele.Categorie;
import DAO.modele.ChiffreAffaire;
import DAO.modele.Client;
import DAO.modele.Commande;
import DAO.modele.Ligne;
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
    private static Connection myConnection; // La connection à la BD de test


    @Before
    public void setUp() throws SQLException, IOException, SqlToolError {
        // On utilise la base de données de test
        myDataSource = getTestDataSource();
        myConnection = myDataSource.getConnection();
        // On crée le schema de la base de test
        executeSQLScript(myConnection, "comptoirs_schema_derby.sql");
        // On y met des données
        executeSQLScript(myConnection, "comptoirs_data.sql");

        this.myDAO = new DAO(myDataSource);
    }

    @After
    public void tearDown() throws IOException, SqlToolError, SQLException {
        myConnection.close(); // La base de données de test est détruite ici

    }

    private void executeSQLScript(Connection connexion, String filename) throws IOException, SqlToolError, SQLException {
        // On initialise la base avec le contenu d'un fichier de test
        String sqlFilePath = DAOTest.class.getResource(filename).getFile();
        SqlFile sqlFile = new SqlFile(new File(sqlFilePath));

        sqlFile.setConnection(connexion);
        sqlFile.execute();
        sqlFile.closeReader();
    }
    
     /**
     * Test of testAllCodes method, of class DAO.
     *
     * @throws java.sql.SQLException
     *\/
    @Test
    public void testAllCodes() throws SQLException {
        System.out.println("testAllCodes");
        List<Client> result = this.myDAO.allCodes();
        Client expResult = new Client("ALFKI", "Alfreds Futterkiste", "Maria Anders", "Représentant(e)", "Obere Str. 57", "Berlin", null, "12209", "Allemagne", "030-0074321", "030-0076545");

        // on vérifie les données du premier Client
        assertEquals(expResult.getCODE(), result.get(0).getCODE());
        assertEquals(expResult.getSociete(), result.get(0).getSociete());
        assertEquals(expResult.getContact(), result.get(0).getContact());
        assertEquals(expResult.getFonction(), result.get(0).getFonction());
        assertEquals(expResult.getAdresse(), result.get(0).getAdresse());
        assertEquals(expResult.getVille(), result.get(0).getVille());
        assertEquals(expResult.getRegion(), result.get(0).getRegion());
        assertEquals(expResult.getCodePostal(), result.get(0).getCodePostal());
        assertEquals(expResult.getPays(), result.get(0).getPays());
        assertEquals(expResult.getTelephone(), result.get(0).getTelephone());
        assertEquals(expResult.getFax(), result.get(0).getFax());
    }
    
    /**
     * Test of testListCategorieCode method, of class DAO.
     *
     * @throws java.sql.SQLException
     *\/
    @Test
    public void testListCategorieCode() throws SQLException {
        System.out.println("testListCategorieCode");
        List<Categorie> result = this.myDAO.listCategorieCode();
        Categorie expResult = new Categorie(1, "Boissons", "Boissons, cafés, thés, bières");
        // on vérifie les données du premier Categorie
        assertEquals(expResult.getCode(), result.get(0).getCode());
        assertEquals(expResult.getDescription(), result.get(0).getDescription());
        assertEquals(expResult.getLibelle(), result.get(0).getLibelle());
    }
                
    /**
     * Test of testListCategorieCode method, of class DAO.
     *
     * @throws java.sql.SQLException
     * @throws DAO.DAOException
     *\/
    @Test
    public void testProduitByCategorieCode() throws SQLException, DAOException {
        System.out.println("testProduitByCategorieCode");
        List<Produit> result = this.myDAO.produitByCategorieCode(1);
        Produit expResult = new Produit(1, "Chai", 1, 1, "10 boîtes x 20 sacs", 90.00, 39, 0, 10, 0);
        // on vérifie les données du premier produit
        assertEquals(expResult.getReference(), result.get(0).getReference());
        assertEquals(expResult.getNom(), result.get(0).getNom());
        assertEquals(expResult.getCategorie(), result.get(0).getCategorie());
        assertEquals(expResult.getPrix_unitaire(), result.get(0).getPrix_unitaire());
    }
    
    /**
     * Test of testProduitCode method, of class DAO.
     *
     * @throws java.sql.SQLException
     *\/
    @Test
    public void testProduitCode() throws SQLException {
        System.out.println("testProduitCode");
        List<Produit> result = this.myDAO.produitCode();
        Produit expResult = new Produit(1, "Chai", 1, 1, "10 boîtes x 20 sacs", 90.00, 39, 0, 10, 0);
        // on vérifie les données du premier produit
        assertEquals(expResult.getReference(), result.get(0).getReference());
        assertEquals(expResult.getNom(), result.get(0).getNom());
        assertEquals(expResult.getCategorie(), result.get(0).getCategorie());
        assertEquals(expResult.getPrix_unitaire(), result.get(0).getPrix_unitaire());
    }
    /**
     * Test of testProduitCodeRef method, of class DAO.
     *
     * @throws java.sql.SQLException
     *\/
    @Test
    public void testProduitCodeRef() throws SQLException {
        System.out.println("testProduitCodeRef"); 
        List<Produit> result = this.myDAO.produitCode("1");
        Produit expResult = new Produit(1, "Chai", 1, 1, "10 boîtes x 20 sacs", 90.00, 39, 0, 10, 0);
        //on vérifie les données du premier produit
        assertEquals(expResult.getReference(), result.get(0).getReference());
        assertEquals(expResult.getNom(), result.get(0).getNom());
        assertEquals(expResult.getCategorie(), result.get(0).getCategorie());
        assertEquals(expResult.getPrix_unitaire(), result.get(0).getPrix_unitaire());
    }
    
    /**
     * Test of testCommandesOfClient method, of class DAO.
     *
     * @throws java.sql.SQLException
     * @throws DAO.DAOException
     *\/
    @Test
    public void testCommandesOfClient() throws SQLException, DAOException {
        System.out.println("CommandesOfClient");
        List<Commande> result = this.myDAO.commandesOfClient("VINET");
        Commande expResult = new Commande(10248, "VINET", "1994-08-04", "1994-08-16", (float) 161.00, "Vins et alcools Chevalier", "59 rue de l\'Abbaye", "Reims", null, "51100", "France", (float) 0.00);      
        //on vérifie les données du premier produit
        assertEquals(expResult.getNumero(), result.get(0).getNumero());
        assertEquals(expResult.getClient(), result.get(0).getClient());
        assertEquals(expResult.getEnvoie(), result.get(0).getEnvoie());
        assertEquals(expResult.getSaisie(), result.get(0).getSaisie());
    }
    
    /**
     * Test of testLigneOfCommandes method, of class DAO.
     *
     * @throws java.sql.SQLException
     * @throws DAO.DAOException
     *\/
    @Test
    public void testLigneOfCommandes() throws SQLException, DAOException {
        System.out.println("LigneOfCommandes");
        List<Ligne> result = this.myDAO.ligneOfCommandes(10248);
        Ligne expResult = new Ligne(10248, 11, 12);      
        //on vérifie les données du premier produit
        assertEquals(expResult.getNumProduit(), result.get(0).getNumProduit());
        assertEquals(expResult.getNumCommande(), result.get(0).getNumCommande());
        assertEquals(expResult.getQuantity(), result.get(0).getQuantity());
    }
   
    /**
     * Test of InfoClient method, of class DAO.
     *
     * @throws java.sql.SQLException
     * @throws DAO.DAOException
     *\/
    @Test
    public void testInfoClient() throws SQLException, DAOException {
        System.out.println("InfoClient");
        List<Client> result = this.myDAO.infoClient("VINET");
        Client expResult = new Client("VINET", "Vins et alcools Chevalier", "Paul Henriot", "Chef comptable", "59 rue de l'Abbaye", "Reims", null, "51100", "France", "26.47.15.10", "26.47.15.11");     
        //on vérifie les données du premier produit
        assertEquals(expResult.getCODE(), result.get(0).getCODE());
        assertEquals(expResult.getSociete(), result.get(0).getSociete());
        assertEquals(expResult.getContact(), result.get(0).getContact());
        assertEquals(expResult.getFonction(), result.get(0).getFonction());
        assertEquals(expResult.getAdresse(), result.get(0).getAdresse());
        assertEquals(expResult.getVille(), result.get(0).getVille());
        assertEquals(expResult.getRegion(), result.get(0).getRegion());
        assertEquals(expResult.getCodePostal(), result.get(0).getCodePostal());
        assertEquals(expResult.getPays(), result.get(0).getPays());
        assertEquals(expResult.getTelephone(), result.get(0).getTelephone());
        assertEquals(expResult.getFax(), result.get(0).getFax());
    }
    
    /**
     * Test of CaByClient method, of class DAO.
     *
     * @throws java.sql.SQLException
     * @throws DAO.DAOException
     *\/
    @Test
    public void testCaByClient() throws SQLException, DAOException {
        System.out.println("CaByClient");
        List<ChiffreAffaire> result = this.myDAO.caByClient("1994-08-08","1994-08-15");
        ChiffreAffaire expResult = new ChiffreAffaire((float) 329.00, "HANAR");     
        //on vérifie les données du premier produit
        assertEquals(expResult.getCA(), result.get(0).getCA());
        assertEquals(expResult.getClient(), result.get(0).getClient());
    }
    
    /**
     * Test of CaByPays method, of class DAO.
     *
     * @throws java.sql.SQLException
     * @throws DAO.DAOException
     *\/
    @Test
    public void testCaByPays() throws SQLException, DAOException {
        System.out.println("CaByPays");
        List<ChiffreAffaire> result = this.myDAO.caByPays("1994-08-08","1994-08-15");
        ChiffreAffaire expResult = new ChiffreAffaire((float) 256.00, "Belgique");     
        //on vérifie les données du premier produit
        assertEquals(expResult.getCA(), result.get(0).getCA());
        assertEquals(expResult.getClient(), result.get(0).getClient());
    }
    
    /**
     * Test of CaByCategorie method, of class DAO.
     *
     * @throws java.sql.SQLException
     * @throws DAO.DAOException
     *\/
    @Test
    public void testCaByCategorie() throws SQLException, DAOException {
        System.out.println("CaByCategorie");
        List<ChiffreAffaire> result = this.myDAO.caByCategorie("1994-08-08","1994-08-15");
        ChiffreAffaire expResult = new ChiffreAffaire((float) 741.00, "Boissons");     
        //on vérifie les données du premier produit
        assertEquals(expResult.getCA(), result.get(0).getCA());
        assertEquals(expResult.getClient(), result.get(0).getClient());
    }

    public static DataSource getTestDataSource() {
        org.hsqldb.jdbc.JDBCDataSource ds = new org.hsqldb.jdbc.JDBCDataSource();
        ds.setDatabase("jdbc:hsqldb:mem:testcase;shutdown=true");
        ds.setUser("sa");
        ds.setPassword("sa");
        return ds;
    }

}

*/