package dao;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/28
 */

import Outil.HibernateConn;
import metier.Magasin;
import metier.Panier;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DaoPanier {

    /*
     * @param email
     * @return java.util.ArrayList<metier.Panier>
     * @author TANG
     * @date 2021/3/28 22:14
     * @description trouver les produit dans panier d'un client
     */
    public ArrayList<Panier> listPanierUnClient(String email){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t= session.beginTransaction();
        ArrayList<Panier> list=null;
        String sql="select p.* from panier p where emailClient=?";
        try{
            list=(ArrayList<Panier>) session.createSQLQuery(sql).addEntity(Panier.class).setParameter(1,email).list();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoPanier listPanierUnClient not ok");
            System.out.println("----------------------------");
        }
        t.commit();
        session.close();
        return list;
    }


    public void ajouer(String email,Integer idP){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t= session.beginTransaction();
        Panier panier=new Panier();
        panier.setCodeProduit(idP);
        panier.setEmailClient(email);
        panier.setQuantite((long)1);
        session.save(panier);
        t.commit();
        session.close();

    }

    public void supprimerPanier(String emailClient,Integer codeProduit)
    {
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        String sql="Delete from panier where emailClient=? and codeProduit=?";

        try {
            session.createSQLQuery(sql).setParameter(1,emailClient).setParameter(2,codeProduit).executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoPanier listPanier");
            System.out.println("----------------------------");
        }
        transaction.commit();
        session.close();


    }





}
