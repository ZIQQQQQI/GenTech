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
        String sql = "select * from produit p, rayon r where p.categorie=?";
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

    public ArrayList<Produit> listRayonProOrdrePrix(String order){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        String sql="select * from produit p, rayon r where p.categorie = r.numCate and p.categorie=?";
        if (order.equals("desc")){
            sql=sql+"order by produit.prixVente DESC";
        }else if (order.equals("asc")){
            sql=sql+"order by produit.prixVente ASC";
        }
        ArrayList<Produit> listProduit = null;
        try{
            listProduit=(ArrayList<Produit>)session.createSQLQuery(sql).addEntity(Produit.class).list();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoRayonProduit listeRayonProduitOrderPrix");
            System.out.println("----------------------------");
        }
        transaction.commit();
        session.close();
        return listProduit;
    }
}