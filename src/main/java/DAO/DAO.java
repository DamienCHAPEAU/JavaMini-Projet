/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
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
        
        public List<Categorie> categorieCode() throws SQLException {

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
    
    
}
