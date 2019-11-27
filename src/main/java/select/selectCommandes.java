/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package select;

import DAO.Commande;
import DAO.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author pedago
 */
public class selectCommandes extends DAO.DAO{

    public selectCommandes(DataSource dataSource) {
        super(dataSource);
    }

    public List<Commande> commandeOfClient(String CLIENT) throws DAOException, SQLException {
        List<Commande> result = new LinkedList<>();
        String sql = "SELECT * FROM COMMANDE WHERE CLIENT = ?";

        try (Connection connection = myDataSource.getConnection();
                PreparedStatement stmt = connection.prepareStatement(sql);) {
            stmt.setString(1, CLIENT);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Commande c = new Commande(rs.getInt("NUMERO"), rs.getString("CLIENT"), rs.getString("SAISIE_LE"), rs.getString("ENVOYEE_LE"), rs.getFloat("PORT"), rs.getString("DESTINATAIRE"), rs.getString("ADRESSE_LIVRAISON"), rs.getString("VILLE_LIVRAISON"), rs.getString("REGION_LIVRAISON"), rs.getString("CODE_POSTAL_LIVRAIS"), rs.getString("PAYS_LIVRASON"), rs.getFloat("REMISE"));
                    result.add(c);
                }
            }

        } catch (SQLException e) {
            throw new DAOException("erreur" + e.getMessage());
        }
        return result;
    }
}
