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

import static java.lang.Integer.parseInt;

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

    public void supprimer (String email){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t= session.beginTransaction();
        String sql="delete from panier where emailClient=?";
        try{
            session.createSQLQuery(sql).setParameter(1,email).executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoPanier supprimer not ok");
            System.out.println("----------------------------");
        }
        t.commit();
        session.close();

    }

    public void modifierQtePanier(String emailClient,Long qte,Integer codeProd){

        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t= session.beginTransaction();
        String sql="update panier set quantite =? where emailClient=? and codeProduit=?";
        session.createSQLQuery(sql).setParameter(1,qte).setParameter(2,emailClient).setParameter(3,codeProd).executeUpdate();

        t.commit();
        session.close();
    }



}
