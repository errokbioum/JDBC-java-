/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.projet.dao;

import java.util.List;

/**
 *
 * @author OUMAIMA
 */
public interface Idao <T>{
    List<T> nbrmaxS();
    void requette ();
    void trieDec();
   void  nbrtotalS( );
    Boolean update (T o);
    void creatDtable ( );
}
