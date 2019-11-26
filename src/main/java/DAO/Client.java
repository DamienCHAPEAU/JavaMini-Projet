/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author pedago
 */
public class Client {
    private String CODE;
    private String societe;
    private String contact;
    private String fonction;
    private String Adresse;
    private String Ville;
    private String Region;
    private String CodePostal;
    private String Pays;
    private String Telephone;
    private String Fax;
    
    public Client(String code, String societe) {
		this.CODE = code;
		this.societe = societe;
	}

    public String getCODE() {
        return CODE;
    }

    public String getSociete() {
        return societe;
    }

    public String getContact() {
        return contact;
    }

    public String getFonction() {
        return fonction;
    }

    public String getAdresse() {
        return Adresse;
    }

    public String getVille() {
        return Ville;
    }

    public String getRegion() {
        return Region;
    }

    public String getCodePostal() {
        return CodePostal;
    }

    public String getPays() {
        return Pays;
    }

    public String getTelephone() {
        return Telephone;
    }

    public String getFax() {
        return Fax;
    }
    
    
}
