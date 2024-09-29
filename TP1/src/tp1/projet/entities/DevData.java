/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.projet.entities;

/**
 *
 * @author OUMAIMA
 */
public class DevData {
    private String developpeur ;
    private String jour;
    private int  nbScript;

    public DevData(String developpeur, String jour, Integer nbScript) {
        this.developpeur = developpeur;
        this.jour = jour;
        this.nbScript = nbScript;
    }

    public DevData(String developpeur, int nbScript) {
        this.developpeur = developpeur ;
        this.nbScript = nbScript;
   }
    

    public DevData() {
    }

    public String getDeveloppeur() {
        return developpeur;
    }

    public String getJour() {
        return jour;
    }

    public Integer getNbScript() {
        return nbScript;
    }

    public void setDeveloppeur(String developpeur) {
        this.developpeur = developpeur;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public void setNbScript(Integer nbScript) {
        this.nbScript = nbScript;
    }

    @Override
    public String toString() {
        return "DevData{" + "developpeur=" + developpeur + ", jour=" + jour + ", nbScript=" + nbScript + '}';
    }
    
    
    
    
}
