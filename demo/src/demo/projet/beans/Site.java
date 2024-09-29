/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.projet.beans;

/**
 *
 * @author OUMAIMA
 */
public class Site {
    private int id;
    private String nom;

    public Site(String nom) {
        this.nom = nom;
    }

    public Site() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Beans{" + "id=" + id + ", nom=" + nom + '}';
    }
    
    
}
