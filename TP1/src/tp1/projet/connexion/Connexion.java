/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.projet.connexion;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;



/**
 *
 * @author OUMAIMA
 */
public class Connexion {
    static String url = "jdbc:mysql://localhost:3306/tp1";
    static String user ="root";
    static String password ="";
    static Connection cn =null;
    public static Connection getCn(){
    try {
      Class.forName("com.mysql.jdbc.Driver");
      cn = DriverManager.getConnection(url, user, password); 
            } catch (ClassNotFoundException e) {
            System.out.println("Driver introuvale ");
            }catch(SQLException ex) {
    Logger.getLogger(Connexion.class.getName()).log(Level.SEVERE, null, ex);
}
    return cn;
    }
    
    }
    

