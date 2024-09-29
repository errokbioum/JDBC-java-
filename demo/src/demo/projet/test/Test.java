/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.projet.test;


import demo.projet.beans.Site;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OUMAIMA
 */
public class Test {
    public static  void save(Site s){
          String url ="jdbc:mysql://localhost:3306/db";
          String password="";
          String user ="root";
          Connection cn=null;
          Statement st =null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, user, password);
            String req= "INSERT INTO `site` VALUES (null,'"+ s.getNom() +"')";
            st=cn.createStatement();
            int n =st.executeUpdate(req);
            }
        catch(SQLException e ){
             Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, e);

        }
        catch(ClassNotFoundException ex ){
             System.out.println("impossible de charger le driver  ");
             
        }
        finally {
            try {
                st.close();
                cn.close();
            }
            catch(SQLException e){
                System.out.println("impossible de liberer  les ressources ");
            }
        }
        
    }
    public static void load(){
        String url ="jdbc:mysql://localhost:3306/db";
        String user ="root";
        String password ="";
        Statement st =null;
        Connection cn = null;
        try {
           Class.forName("com.mysql.jdbc.Driver");
           cn=DriverManager.getConnection(url, user, password);
           String req= " Select * from Site ";
           st =cn.createStatement();
           ResultSet n = st.executeQuery(req);
            while (n.next()) {
                System.out.println(n.getInt(1)+""+ n.getString(2));
                
            }
            
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found ");
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            
        }finally {
            try {
 
              st.close();
                cn.close();
        } catch (SQLException ex) {
                  System.out.println("Impossible de libérer les ressources");
        }
     } 
         } 
    
  public static void main(String[] args) {
 //save(new Site("SAFI"));
 //save(new Site("MARRAKECH"));
 //save(new Site ("EL JADIDA"));
 load();
 }
    
}
