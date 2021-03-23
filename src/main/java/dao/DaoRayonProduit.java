package dao;/*
 *@program GenTech1
 *@author TU
 *@date 23/03/2021
 */

import Outil.HibernateConn;
import metier.Produit;
import metier.Rayon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DaoRayonProduit{
    public static ArrayList<Produit> listeRayonProduit(Integer numCate)
    {
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        String sql = "select * from produit p, rayon r where p.categorie = r.numCate and p.categorie=?";
        ArrayList<Produit> list = null;
        try{
            list=(ArrayList<Produit>) session.createSQLQuery(sql).addEntity(Produit.class).setParameter(1,numCate).list();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("----------------------");
            System.out.println("DaoRayonProduit listeRayonProduit");
            System.out.println("----------------------");

        }
        t.commit();
        session.close();
        return list;
    }
}