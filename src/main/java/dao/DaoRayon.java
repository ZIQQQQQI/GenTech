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

    /*
     *@param emailClient
     *@return java.util.ArrayList<metier.Rayon>
     *@author SI
     *@date 25/03/2021 11:59
     *@exception Exception
     *@description Rechercher les rayons plus commandee pour un client
     */
    public ArrayList<Rayon> listeRayonPrefere(String emailClient){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        ArrayList<Rayon> list = null;
        String sql = "select r.* \n" +
                "from rayon r, Produit p,lignecommande lc,commande co \n" +
                "where co.idCdeCli=lc.idCdeCli \n" +
                "and lc.codeProduit=p.codeProduit \n" +
                "and p.categorie=r.numCate \n" +
                "and co.emailClient=? \n" +
                "group by r.numcate,r.nomcate,r.idParant,r.degre \n" +
                "order by count(*) desc limit 5";
        try{
            list=(ArrayList<Rayon>) session.createSQLQuery(sql).addEntity(Rayon.class).setParameter(1,emailClient).list();
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