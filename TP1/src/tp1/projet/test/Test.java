/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.projet.test;

import tp1.projet.entities.DevData;
import tp1.projet.services.ExoJDBC;

/**
 *
 * @author OUMAIMA
 */
public class Test {
    public static void main(String[] args) {
      
        ExoJDBC e1 = new ExoJDBC();
        //e1.creatDtable();
        //DevData d1= new DevData("ALAMI", "LUNDI", 1);
        //DevData d2= new DevData("WAFI", "LUNDI", 2);
       // DevData d3= new DevData("SALAMI", "MARDI", 9);
       // DevData d4= new DevData("SAFI", "MARDI", 2);
       // DevData d5= new DevData("ALAMI", "MARDI", 2);
       //  DevData d6= new DevData("SEBIHI", "MERCREDI", 2);
        // DevData d7= new DevData("WAFI", "JEUDI", 3);
        // DevData d8= new DevData("ALAOUI", "VENDREDI", 9);
        // DevData d9= new DevData("WAFI", "VENDREDI", 3);
        // DevData d10= new DevData("SEBIHI", "VENDREDI", 4);
        // e1.update(d1);
        //  e1.update(d2);
         // e1.update(d3);
          //e1.update(d4);
          //e1.update(d5);
          //e1.update(d6);
          //e1.update(d7);
          //e1.update(d8);
          //e1.update(d9);
          //e1.update(d10);
         
         
        
        for(DevData e : e1.nbrmaxS()) {
            System.out.println(e);
    }
       e1.trieDec();
       e1.nbrtotalS( );
       e1.nbrtotalSJ("ala");
       e1.requette ();
       
       
         }
}
