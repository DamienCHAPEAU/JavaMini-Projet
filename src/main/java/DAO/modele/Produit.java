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
public class Produit {
    
    
    private int reference;
    private String nom;
    private String fournisseur;
    private int categorie;
    private String quantite_par_unite;
    private float prix_unitaire;
    private int unites_en_stock;
    private int unites_commandees;
    private int niveau_de_reappro;
    private int indisponible;
    private int quantity;

    public Produit(int reference, String nom, String fournisseur, int categorie, String quantite_par_unite, float prix_unitaire, int unites_en_stock, int unites_commandees, int niveau_de_reappro, int indisponible, int quantity) {
        this.reference = reference;
        this.nom = nom;
        this.fournisseur = fournisseur;
        this.categorie = categorie;
        this.quantite_par_unite = quantite_par_unite;
        this.prix_unitaire = prix_unitaire;
        this.unites_en_stock = unites_en_stock;
        this.unites_commandees = unites_commandees;
        this.niveau_de_reappro = niveau_de_reappro;
        this.indisponible = indisponible;
        this.quantity = quantity;
    }
    
    

    public Produit(int reference, String nom, int categorie, String quantite_par_unite, float prix_unitaire, int unites_en_stock, int unites_commandees, int niveau_de_reappro, int indisponible) {
        this.reference = reference;
        this.nom = nom;
        this.categorie = categorie;
        this.quantite_par_unite = quantite_par_unite;
        this.prix_unitaire = prix_unitaire;
        this.unites_en_stock = unites_en_stock;
        this.unites_commandees = unites_commandees;
        this.niveau_de_reappro = niveau_de_reappro;
        this.indisponible = indisponible;
    }

    public String getFournisseur() {
        return fournisseur;
    }
    
    public Produit(int ref, String nom, int categorie, float prix_unitaire) {
        this.reference = ref;
        this.nom = nom;
        this.categorie = categorie;        
        this.prix_unitaire = prix_unitaire;
       
    }
        public Produit(int ref, String nom, int categorie, float prix_unitaire, int quantity) {
        this.reference = ref;
        this.nom = nom;
        this.categorie = categorie;        
        this.prix_unitaire = prix_unitaire;
        this.quantity = quantity;
       
    }

    public int getQuantity() {
        return quantity;
    }
    
    public int getReference() {
        return reference;
    }

    public String getNom() {
        return nom;
    }

    public int getCategorie() {
        return categorie;
    }

    public String getQuantite_par_unite() {
        return quantite_par_unite;
    }

    public float getPrix_unitaire() {
        return prix_unitaire;
    }

    public int getUnites_en_stock() {
        return unites_en_stock;
    }

    public int getUnites_commandees() {
        return unites_commandees;
    }

    public int getNiveau_de_reappro() {
        return niveau_de_reappro;
    }

    public int getIndisponible() {
        return indisponible;
    }

    
}
