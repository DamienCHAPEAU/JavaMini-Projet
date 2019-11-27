/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 * Eregistrement de la table Commande
 * @author pedago
 */
public class Commande {   

    private int numero;
    private String client;
    private String saisie;
    private String envoie;
    private float port;
    private String destinataire;
    private String adresse_livraison;
    private String ville_livraison;
    private String region_livraison;
    private String code_postal_livraison;
    private String pays_livraison;
    private float remise;

    public Commande(int numero, String client, String saisie, String envoie, float port, String destinataire, String adresse_livraison, String ville_livraison, String region_livraison, String code_postal_livraison, String pays_livraison, float remise) {
        this.numero = numero;
        this.client = client;
        this.saisie = saisie;
        this.envoie = envoie;
        this.port = port;
        this.destinataire = destinataire;
        this.adresse_livraison = adresse_livraison;
        this.ville_livraison = ville_livraison;
        this.region_livraison = region_livraison;
        this.code_postal_livraison = code_postal_livraison;
        this.pays_livraison = pays_livraison;
        this.remise = remise;
    }
    
    
    
    
    public Commande(int numero){
        this.numero = numero;
    }
    
    

    public int getNumero() {
        return numero;
    }

    public String getClient() {
        return client;
    }

    public String getSaisie() {
        return saisie;
    }

    public String getEnvoie() {
        return envoie;
    }

    public float getPort() {
        return port;
    }

    public String getDestinataire() {
        return destinataire;
    }

    public String getAdresse_livraison() {
        return adresse_livraison;
    }

    public String getVille_livraison() {
        return ville_livraison;
    }

    public String getRegion_livraison() {
        return region_livraison;
    }

    public String getCode_postal_livraison() {
        return code_postal_livraison;
    }

    public String getPays_livraison() {
        return pays_livraison;
    }

    public float getRemise() {
        return remise;
    }
    

}
