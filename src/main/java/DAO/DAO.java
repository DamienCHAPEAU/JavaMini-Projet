/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.modele.Client;
import DAO.modele.Categorie;
import DAO.modele.ChiffreAffaire;
import DAO.modele.Commande;
import DAO.modele.Produit;
import DAO.modele.Ligne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author pedago
 */
public class DAO {

    public final DataSource myDataSource;

    public DAO(DataSource dataSource) {
        this.myDataSource = dataSource;
    }

    /**
     * Contenu de la table DISCOUNT_CODE
     *
     * @return Liste des discount codes
     * @throws SQLException renvoyées par JDBC
     */
    public List<Client> allCodes() throws SQLException {

        List<Client> result = new LinkedList<>();

        String sql = "SELECT * FROM CLIENT ORDER BY CODE";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String code = rs.getString("CODE");
                String societe = rs.getString("SOCIETE");
                String contact = rs.getString("CONTACT");
                Client c = new Client(code, societe, contact);
                result.add(c);
            }
        }
        return result;
    }

    public Client LOGIN(String Contact, String Code) throws SQLException {
        Client c1 = null;
        String sql = "SELECT * FROM CLIENT where CODE = ? and CONTACT = ?";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, Code);
            stmt.setString(2, Contact);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String code = rs.getString("CODE");
                    String contact = rs.getString("CONTACT");
                    Client c = new Client(contact, code);
                    c1 = c;
                }
                
            } catch (SQLException ex) {

                Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
            }
            return c1;
        }
    }

    public List<Categorie> listCategorieCode() throws SQLException {

        List<Categorie> result = new LinkedList<>();
        String sql = "SELECT * FROM CATEGORIE ORDER BY CODE";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int code = rs.getInt("CODE");
                String libelle = rs.getString("LIBELLE");
                String description = rs.getString("DESCRIPTION");
                Categorie c = new Categorie(code, libelle, description);
                result.add(c);

            }
        }
        return result;
    }

    public List<Produit> produitByCategorieCode(int CATEGORIE) throws SQLException, DAOException {

        List<Produit> result = new LinkedList<>();

        String sql = "SELECT * FROM PRODUIT WHERE CATEGORIE=?";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, CATEGORIE);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) { // On a trouvé
                    String nom = rs.getString("NOM");
                    int categorie = rs.getInt("Categorie");
                    float prix_unitaire = rs.getFloat("Prix_unitaire");
                    Produit p = new Produit(rs.getInt("REFERENCE"), nom, categorie, prix_unitaire);
                    result.add(p);
                }
            } catch (SQLException ex) {
                Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
                throw new DAOException(ex.getMessage());
            }

        }
        return result;
    }

    public List<Produit> produitCode() throws SQLException {

        List<Produit> result = new LinkedList<>();

        String sql = "SELECT * FROM Produit ORDER BY REFERENCE";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nom = rs.getString("NOM");
                int categorie = rs.getInt("Categorie");
                float prix_unitaire = rs.getFloat("Prix_unitaire");
                Produit p = new Produit(rs.getInt("REFERENCE"), nom, categorie, prix_unitaire);
                result.add(p);

            }
        }
        return result;
    }

    public Produit produitCode(String ref) throws SQLException {

        Produit result = null ;

        String sql = "SELECT * FROM Produit WHERE REFERENCE = ?";

        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, ref);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nom = rs.getString("NOM");
                int categorie = rs.getInt("Categorie");
                float prix_unitaire = rs.getFloat("Prix_unitaire");
                Produit p = new Produit(rs.getInt("REFERENCE"), nom, categorie, prix_unitaire);
                result = p;

            }
        }
        return result;
    }

    public void addProduit(Produit prod) throws SQLException {

        String sql = "INSERT INTO  PRODUIT(nom,fournisseur,categorie,quantite_par_unite,prix_unitaire,unites_en_stock, unites_commandees,niveau_de_reappro,indisponible)  "
                + "VALUES(?,?,?,?,?,?,?,?,?)";

        try (
                Connection connection = this.myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            connection.setAutoCommit(false);
            try {

                stmt.setString(1, prod.getNom());
                stmt.setInt(2, prod.getFournisseur());
                stmt.setInt(3, prod.getCategorie());
                stmt.setString(4, prod.getQuantite_par_unite());
                stmt.setDouble(5, prod.getPrix_unitaire());
                stmt.setInt(6, prod.getUnites_en_stock());
                stmt.setInt(7, prod.getUnites_commandees());
                stmt.setInt(8, prod.getNiveau_de_reappro());
                stmt.setInt(9, prod.getIndisponible());

                stmt.executeUpdate();
                connection.commit();

            } catch (SQLException ex) {
                Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
                // throw new DAOException(ex.getMessage());
                connection.rollback();
            } finally {
                connection.setAutoCommit(true);
            }
        }
    }

    public void suppProduit(int reference) throws SQLException {
        String sql = "UPDATE PRODUIT SET indisponible = 1  WHERE reference = " + reference;
        try (
                Connection connection = this.myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            stmt.executeUpdate();
            connection.setAutoCommit(true);
        }
    }

    public void modifProduit(int reference, String choixModif, String modifProd) throws SQLException {

        String sql = "UPDATE PRODUIT SET " + choixModif + " = '" + modifProd + "' WHERE reference = " + reference;

        try (
                Connection connection = this.myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            stmt.executeUpdate();
            connection.setAutoCommit(true);

        }
    }

    public List<Commande> commandesOfClient(String CLIENT) throws DAOException, SQLException {
        List<Commande> result = new LinkedList<>();
        String sql = "SELECT * FROM COMMANDE WHERE CLIENT = ?";

        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);) {
            stmt.setString(1, CLIENT);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Commande c = new Commande(rs.getInt("NUMERO"), rs.getString("CLIENT"), rs.getString("SAISIE_LE"), rs.getString("ENVOYEE_LE"), rs.getFloat("PORT"), rs.getString("DESTINATAIRE"), rs.getString("ADRESSE_LIVRAISON"), rs.getString("VILLE_LIVRAISON"), rs.getString("REGION_LIVRAISON"), rs.getString("CODE_POSTAL_LIVRAIS"), rs.getString("PAYS_LIVRAISON"), rs.getFloat("REMISE"));
                    result.add(c);
                }
            }

        } catch (SQLException e) {
            throw new DAOException("erreur" + e.getMessage());
        }
        return result;
    }

    public List<Ligne> ligneOfCommandes(int commande) throws DAOException, SQLException {
        List<Ligne> result = new LinkedList<>();
        String sql = "SELECT * FROM LIGNE WHERE COMMANDE = ?";

        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);) {
            stmt.setInt(1, commande);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Ligne l = new Ligne(rs.getInt("COMMANDE"), rs.getInt("PRODUIT"), rs.getInt("QUANTITE"));
                    result.add(l);
                }
            }

        } catch (SQLException e) {
            throw new DAOException("erreur" + e.getMessage());
        }
        return result;
    }

    /**
     * public List<Commande> commandes() throws DAOException, SQLException {
     * List<Commande> result = new LinkedList<>(); String sql = "SELECT * FROM
     * COMMANDE ";
     *
     * try (Connection connection = myDataSource.getConnection();
     * PreparedStatement stmt = connection.prepareStatement(sql);) {
     *
     *
     * try (ResultSet rs = stmt.executeQuery()) { while (rs.next()) { Commande c
     * = new Commande(rs.getInt("NUMERO"), rs.getString("CLIENT"),
     * rs.getString("SAISIE_LE"), rs.getString("ENVOYEE_LE"),
     * rs.getFloat("PORT"), rs.getString("DESTINATAIRE"),
     * rs.getString("ADRESSE_LIVRAISON"), rs.getString("VILLE_LIVRAISON"),
     * rs.getString("REGION_LIVRAISON"), rs.getString("CODE_POSTAL_LIVRAIS"),
     * rs.getString("PAYS_LIVRAISON"), rs.getFloat("REMISE"));
     *
     * result.add(c); } } } catch (SQLException e) { throw new
     * DAOException("erreur" + e.getMessage()); } return result; }
     *
     * @param CLIENT
     * @return
     * @throws DAO.DAOException
     * @throws java.sql.SQLException
     *
     */
    public List<Client> infoClient(String CLIENT) throws DAOException, SQLException {
        List<Client> result = new LinkedList<>();
        String sql = "SELECT * FROM CLIENT WHERE CODE = ?";

        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);) {
            stmt.setString(1, CLIENT);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Client c = new Client(rs.getString("CODE"), rs.getString("SOCIETE"), rs.getString("CONTACT"), rs.getString("FONCTION"), rs.getString("ADRESSE"), rs.getString("VILLE"), rs.getString("REGION"), rs.getString("CODE_POSTAL"), rs.getString("PAYS"), rs.getString("TELEPHONE"), rs.getString("FAX"));

                    result.add(c);
                }
            }

        } catch (SQLException e) {
            throw new DAOException("erreur" + e.getMessage());
        }
        return result;
    }

        public Client getClient(String CLIENT) throws DAOException, SQLException {
        
        String sql = "SELECT * FROM CLIENT WHERE CODE = ?";
        Client c = null;
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);) {
            stmt.setString(1, CLIENT);

            ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                     c = new Client(rs.getString("CODE"), rs.getString("SOCIETE"), rs.getString("CONTACT"), rs.getString("FONCTION"), rs.getString("ADRESSE"), rs.getString("VILLE"), rs.getString("REGION"), rs.getString("CODE_POSTAL"), rs.getString("PAYS"), rs.getString("TELEPHONE"), rs.getString("FAX"));

                    
               
                }

        }
        return c;
    }
    
    
        public void upClient(String CODE, String Societe, String Contact, String fonction, String adresse, String ville, String region, String code_postal, String pays, String tel, String Fax ) throws DAOException, SQLException, Exception {
       
        String sql = "UPDATE CLIENT SET SOCIETE = ?, CONTACT= ?, FONCTION= ?, ADRESSE= ?, VILLE= ?, REGION= ?, CODE_POSTAL= ?, PAYS=?, TELEPHONE= ?, FAX= ? WHERE CODE = ?";

        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);) {
            stmt.setString(1, Societe);
            stmt.setString(2, Contact);
            stmt.setString(3, fonction);
            stmt.setString(4, adresse);
            stmt.setString(5, ville);
            stmt.setString(6, region);
            stmt.setString(7, code_postal);
            stmt.setString(8, pays);
            stmt.setString(9, tel);
            stmt.setString(10, Fax);
            stmt.setString(11, CODE);
            
            
            int rs = stmt.executeUpdate();
            
            if(rs < 1){
                throw new Exception("erreur");
            }  
            
            }

         catch (Exception e) {
            throw new DAOException("erreur" + e.getMessage());
        }
        
            
    }

    
    
    
    //Requete visualiser les chiffres d'affaire par pays, en choisissant la période (date de début / date de fin) sur laquelle doit porter la statistique.
    //Exemple :
    //SELECT SUM(PORT) AS CA FROM COMMANDE WHERE PAYS_LIVRAISON='France' AND SAISIE_LE>='1994-08-08' AND ENVOYEE_LE<='1994-08-15';
    public List<ChiffreAffaire> caByClient(String dateSaisie, String dateEnvoyee) throws SQLException, DAOException {
        List<ChiffreAffaire> result = new LinkedList<>();

        String sql = "SELECT SUM(PORT) AS CA,CLIENT FROM COMMANDE WHERE SAISIE_LE>=? AND ENVOYEE_LE<=? GROUP BY CLIENT";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, dateSaisie);
            stmt.setString(2, dateEnvoyee);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) { // On a trouvé
                    float CA = rs.getFloat("CA");
                    String client = rs.getString("CLIENT");
                    ChiffreAffaire ca = new ChiffreAffaire(CA, client);
                    result.add(ca);
                }
            } catch (SQLException ex) {
                Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
                throw new DAOException(ex.getMessage());
            }

        }
        return result;
    }

    public List<ChiffreAffaire> caByPays(String dateSaisie, String dateEnvoyee) throws SQLException, DAOException {
        List<ChiffreAffaire> result = new LinkedList<>();

        String sql = "SELECT SUM(PORT) AS CA,PAYS_LIVRAISON FROM COMMANDE WHERE SAISIE_LE>=? AND ENVOYEE_LE<=? GROUP BY PAYS_LIVRAISON";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, dateSaisie);
            stmt.setString(2, dateEnvoyee);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) { // On a trouvé
                    float CA = rs.getFloat("CA");
                    String pays = rs.getString("PAYS_LIVRAISON");
                    ChiffreAffaire ca = new ChiffreAffaire(CA, pays);
                    result.add(ca);
                }
            } catch (SQLException ex) {
                Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
                throw new DAOException(ex.getMessage());
            }

        }
        return result;
    }

    public List<ChiffreAffaire> caByCategorie(String dateSaisie, String dateEnvoyee) throws SQLException, DAOException {
        List<ChiffreAffaire> result = new LinkedList<>();

        String sql = "SELECT SUM(PORT) AS CA, CAT.LIBELLE FROM COMMANDE C, PRODUIT P, LIGNE L, CATEGORIE CAT WHERE C.SAISIE_LE>=? AND C.ENVOYEE_LE<=? AND C.NUMERO=L.COMMANDE AND L.PRODUIT=P.REFERENCE AND P.CATEGORIE=CAT.CODE GROUP BY CAT.LIBELLE";
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, dateSaisie);
            stmt.setString(2, dateEnvoyee);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) { // On a trouvé
                    float CA = rs.getFloat("CA");
                    String libelle = rs.getString("LIBELLE");
                    ChiffreAffaire ca = new ChiffreAffaire(CA, libelle);
                    result.add(ca);
                }
            } catch (SQLException ex) {
                Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
                throw new DAOException(ex.getMessage());
            }

        }
        return result;
    }

}
