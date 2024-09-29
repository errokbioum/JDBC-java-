 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.projet.services;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import tp1.projet.connexion.Connexion;
import tp1.projet.dao.Idao;
import tp1.projet.entities.DevData;

/**
 *
 * @author OUMAIMA
 */
public class ExoJDBC implements Idao <DevData> {
           
    
    @Override
    public  List <DevData> nbrmaxS() {
         List<DevData> Data = new ArrayList<>();
        try {
        Statement st = Connexion.getCn().createStatement();
        String req = "SELECT Developpeurs, jour, MAX(NBScripts)   FROM devdata GROUP BY jour";
        ResultSet sn = st.executeQuery(req);
        while (sn.next()) {
            Data.add(new DevData(sn.getString("developpeurs"), sn.getString("jour"),sn.getInt(3)));  
           }
        }catch ( SQLException  ex){
            Logger.getLogger(DevData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Data;
        }
 
    public void trieDec(){
  List<DevData> Datas= new ArrayList<>();
     try {
      Statement st = Connexion.getCn().createStatement();
       String req ="SELECT Developpeurs, sum(NBScripts) as c  FROM devdata GROUP BY Developpeurs  order by c desc ";
         ResultSet sn=st.executeQuery(req);
        
         while  (sn.next()){
              Datas.add(new DevData(sn.getString("developpeurs"), null, sn.getInt(2))); 
         }
        }catch(SQLException e ){
            Logger.getLogger(DevData.class.getName()).log(Level.SEVERE, null, e);
        }
      System.out.println("*liste  des perssones liee par ordre decroissant selon leur nombre de script* :  ");
      for(DevData e: Datas){
          System.out.println("-nom : "+e.getDeveloppeur()+" ; le nombre de script : "+e.getNbScript()+".");
      }
    }
  @Override
  public void  nbrtotalS( ){
      boolean r=false;
      try {
          Statement st =Connexion.getCn().createStatement() ;
          String req= " Select SUM(NBScripts) as c from devdata";
          ResultSet sn =st.executeQuery(req);
          if (sn.next()){
              r=true;
              System.out.println(" nombre totale des Script realisee en une semaine : "+ sn.getInt(1));
          }
          
      }catch( SQLException e ){
          Logger.getLogger(DevData.class.getName()).log(Level.SEVERE, null, e);
  }
  }
  public  void  nbrtotalSJ( String dt ){
      boolean r=false;
      try {
          Statement st =Connexion.getCn().createStatement() ;
          String req= " Select  Developpeurs   ,SUM(NBScripts) from devdata GROUP BY Developpeurs ";
          ResultSet sn =st.executeQuery(req);
          while(sn.next()){
              
              if(dt.trim().equalsIgnoreCase(sn.getString("developpeurs").trim())){  // trim() pour enlever les espaces et en utilisant equalsIgnoreCase() pour ignorer la casse 
                  
                   System.out.println(" nombre totale des Script realisee par "+ sn.getString(1) +" est :  "+ sn.getInt(2));
                r=true;
           }
              else {
                  System.out.println("ce nom n'existe pas dans la base de donnee");
                  
              }
              break;
           }
              
              
          } catch (SQLException ex) {
            Logger.getLogger(ExoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         
      
  }
  public void requette (){
       boolean r=false;
       System.out.println("entrer la requette : ");
       Scanner sc = new Scanner(System.in);
      try {
          Statement st =Connexion.getCn().createStatement() ;
          String req= sc.nextLine();
          ResultSet sn =st.executeQuery(req);
          ResultSetMetaData data = sn.getMetaData();
          System.out.println("information sur la requette fournit ");
          int c= data.getColumnCount();
          System.out.println("le nombre de colonne de la table est :"+ data.getColumnCount());
          System.out.println("");
          if (req.trim().toLowerCase().startsWith("select")) {
              r=true;
              
          }   for (int i = 1; i <= c; i++) {
                String columnName = data.getColumnName(i);
                String columnType = data.getColumnTypeName(i);
                System.out.println("Colonne " + i + ": " + columnName + " (Type: " + columnType + ")");
            }
          
            while (sn.next()) {
                for (int i = 1; i <= c; i++) {
                    System.out.print(sn.getString(i) + " ");
                }
                System.out.println();
            }
          
      }catch( SQLException e ){
          Logger.getLogger(DevData.class.getName()).log(Level.SEVERE, null, e);
  }
      
  }

    @Override
    public Boolean update(DevData o) {
       Boolean r= false;
       try {
           String req ="INSERT INTO devdata (developpeurs , jour, NBScripts) VALUES ('" 
                     + o.getDeveloppeur() + "', '" 
                     + o.getJour() + "', " 
                     + o.getNbScript() + ")";
           Statement st = Connexion.getCn().createStatement();
           int n = st.executeUpdate(req);
           if (n==1){
               r=true ;
               
           }
           
       }catch( SQLException e ){
           Logger.getLogger(DevData.class.getName()).log(Level.SEVERE, null, e);
       }
       return r;
    }

    @Override
    public void creatDtable() {
        try  {
            String req ="CREATE TABLE devdata (" +
                                "developpeurs VARCHAR(32), " +
                                "jour CHAR(11), " +
                                "NBScripts INTEGER)";
        ;
            Statement st = Connexion.getCn().createStatement();
            int n= st.executeUpdate(req);
            if(n==1){
                System.out.println("la table est cree");
            }else{
                System.out.println("table non cree ");;
            }
        }catch( SQLException e){
            Logger.getLogger(DevData.class.getName()).log(Level.SEVERE, null, e);
        }
    }
  }
 
 


   
    
    

