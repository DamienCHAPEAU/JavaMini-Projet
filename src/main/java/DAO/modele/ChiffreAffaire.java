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
public class ChiffreAffaire {
    
    private float CA;
    private String client;

    public ChiffreAffaire(float CA, String client) {
        this.CA = CA;
        this.client = client;
    }


    public String getClient() {
        return client;
    }

    public float getCA() {
        return CA;
    }
    
    
    
}
