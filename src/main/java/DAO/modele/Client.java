/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.modele;

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

    
    
    public Client(String CODE, String societe, String contact, String fonction, String Adresse, String Ville, String Region, String CodePostal, String Pays, String Telephone, String Fax) {
        this.CODE = CODE;
        this.societe = societe;
        this.contact = contact;
        this.fonction = fonction;
        this.Adresse = Adresse;
        this.Ville = Ville;
        this.Region = Region;
        this.CodePostal = CodePostal;
        this.Pays = Pays;
        this.Telephone = Telephone;
        this.Fax = Fax;
    }


    public Client(String code, String societe, String Contact) {
		this.CODE = code;
		this.societe = societe;
                this.contact= Contact;
	}

    public Client( String contact, String CODE) {
        this.CODE = CODE;
        this.contact = contact;
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
