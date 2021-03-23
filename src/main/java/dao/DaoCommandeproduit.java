package dao;/*
 *@program gentech2
 *@author LIU Yue
 *@date 23-03-21
 */

import Outil.HibernateConn;
import metier.Produit;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DaoCommandeproduit {
/*
 *@param idCdeCli
 *@return java.util.ArrayList<metier.Produit>
 *@author LIU
 *@date 23-03-21 14:00
*/
    public static ArrayList<Produit>  commandeProduit (String idCdeCli)
            {
        /*----- Création de la connexion à la base de données -----*/
                Session session= HibernateConn.getSessionFactory().getCurrentSession();
                Transaction t = session.beginTransaction();


        ArrayList<Produit> list =null;

        /*----- Interrogation de la base -----*/
        /*----- Requête SQL -----*/
        String sql="select p.* from produit p, lignecommande l where l.idcdeCli=? and p.codeProduit=l.codeProduit";

       try {
         list = (ArrayList<Produit>) session.createSQLQuery(sql).addEntity(Produit.class).setParameter(1, idCdeCli).list();
       }
       catch (Exception e){
           e.printStackTrace();
           System.out.println("----------------");
           System.out.println("DaoCommandeProduit");
           System.out.println("----------------");
       }
                t.commit();
                session.close();
        return list;
    }
    
    /*
     *@param null
     *@return 
     *@author LIU
     *@date 23-03-21 14:00
    */

    public static ArrayList<Produit>  produitPlusCom (String email)
             {
                 Session session= HibernateConn.getSessionFactory().getCurrentSession();
                 Transaction t = session.beginTransaction();session.beginTransaction();
        ArrayList<Produit> list =null;
        String sql="select p.* from lignecommande lc,commande c,produit p \n" +
                "where c.emailClient=? \n" +
                "and c.idCdeCli = lc.idCdeCli \n" +
                "and p.codeproduit = lc.codeproduit\n" +
                "group by codeProduit order by count(*) desc limit 5";

        try {
            list = (ArrayList<Produit>) session.createSQLQuery(sql).addEntity(Produit.class).setParameter(1,email).list();
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------");
            System.out.println("DaoCommandeProduit");
            System.out.println("----------------");
        }
                 t.commit();
                 session.close();
        return list;

    }
}


