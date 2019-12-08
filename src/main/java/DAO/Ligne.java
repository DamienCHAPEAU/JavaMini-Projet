/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Clément
 */
public class Ligne {
    private final int numCommande;
    private final int numProduit;
    private final int quantity;

    public Ligne(int numCommande, int numProduit, int quantity) {
        this.numCommande = numCommande;
        this.numProduit = numProduit;
        this.quantity = quantity;
    }

    public int getNumCommande() {
        return numCommande;
    }

    public int getNumProduit() {
        return numProduit;
    }

    public int getQuantity() {
        return quantity;
    }
    
    
    
}
