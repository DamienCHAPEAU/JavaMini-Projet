/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.modele.Client;
import DAO.modele.Categorie;
import DAO.modele.Commande;
import DAO.modele.Produit;
import DAO.modele.Ligne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                    Produit p = new Produit(rs.getInt("REFERENCE"),nom, categorie, prix_unitaire);
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
                Produit p = new Produit(rs.getInt("REFERENCE"),nom, categorie, prix_unitaire);
                result.add(p);

            }
        }
        return result;
    }
    
        public List<Produit> produitCode(String ref) throws SQLException {

        List<Produit> result = new LinkedList<>();

        String sql = "SELECT * FROM Produit WHERE REFERENCE = ?";
        
        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql)) {
            
            stmt.setString(1, ref);
            
           ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nom = rs.getString("NOM");
                int categorie = rs.getInt("Categorie");
                float prix_unitaire = rs.getFloat("Prix_unitaire");
                Produit p = new Produit(rs.getInt("REFERENCE"),nom, categorie, prix_unitaire);
                result.add(p);
            
            }
        }
        return result;
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
    
        public List<Ligne> ligneOfCommandes (int commande) throws DAOException, SQLException {
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
    
    //Requete visualiser les chiffres d'affaire par pays, en choisissant la période (date de début / date de fin) sur laquelle doit porter la statistique.
        //Exemple :
        //SELECT SUM(PORT) AS CA FROM COMMANDE WHERE PAYS_LIVRAISON='France' AND SAISIE_LE>='1994-08-08' AND ENVOYEE_LE<='1994-08-15';
        
        public ChiffreAffaire caByPays(String pays, String dateSaisie, String dateEnvoyee) throws SQLException, DAOException {

		ChiffreAffaire result = new ChiffreAffaire(0);

		String sql = "SELECT SUM(PORT) FROM COMMANDE WHERE PAYS_LIVRAISON=(?) AND SAISIE_LE>=(?) AND ENVOYEE_LE<=(?)";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setString(1, pays);
                        stmt.setString(2, dateSaisie);
                        stmt.setString(3, dateEnvoyee);
                        try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) { // On a trouvé					                                      
                                        ChiffreAffaire ca = new ChiffreAffaire(rs.getFloat("CA"));
                                        result = ca;
				} 
			} catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
                        }                       
			
		}
		return result;
	}
        
        
        /*public ChiffreAffaire caByCategorie(int categorie, String dateSaisie, String dateEnvoyee) throws SQLException, DAOException {

		ChiffreAffaire result = new ChiffreAffaire(0);

		String sql = "A FAIRE";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setInt(1, categorie);
                        stmt.setString(2, dateSaisie);
                        stmt.setString(3, dateEnvoyee);
                        try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) { // On a trouvé					                                      
                                        ChiffreAffaire ca = new ChiffreAffaire(rs.getFloat("CA"));
                                        result = ca;
				} 
			} catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
                        }                       
			
		}
		return result;
	}*/
        
        public ChiffreAffaire caByClient(String client, String dateSaisie, String dateEnvoyee) throws SQLException, DAOException {

		ChiffreAffaire result = new ChiffreAffaire(0);

		String sql = "SELECT SUM(PORT) FROM COMMANDE WHERE CLIENT=(?) AND SAISIE_LE>=(?) AND ENVOYEE_LE<=(?)";
		try (Connection connection = myDataSource.getConnection(); 
		     PreparedStatement stmt = connection.prepareStatement(sql)) {
                        stmt.setString(1, client);
                        stmt.setString(2, dateSaisie);
                        stmt.setString(3, dateEnvoyee);
                        try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) { // On a trouvé					                                      
                                        ChiffreAffaire ca = new ChiffreAffaire(rs.getFloat("CA"));
                                        result = ca;
				} 
			} catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new DAOException(ex.getMessage());
                        }                       
			
		}
		return result;
	}
        

}
