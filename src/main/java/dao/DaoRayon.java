package dao;
/*
 *@param null
 *@return
 *@author Tu
 *@description pour afficher la liste de rayon
 *@exception
 *@date 23/03/2021 12:04
*/

import Outil.HibernateConn;
import metier.Lignecommande;
import metier.Rayon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoRayon{
     public static ArrayList<Rayon> listeRayon()
     {
         Session session= HibernateConn.getSessionFactory().getCurrentSession();
         Transaction t = session.beginTransaction();
         String sql = "select rayon.* from rayon where degre = ?";
         ArrayList<Rayon> list = null;
         try{
             list=(ArrayList<Rayon>) session.createSQLQuery(sql).addEntity(Rayon.class).setParameter(1,1).list();
         }catch(Exception e){
             e.printStackTrace();
             System.out.println("----------------------");
             System.out.println("DaoRayon listeRayon");
             System.out.println("----------------------");
         }
         t.commit();
         session.close();
         return list;
     }
}