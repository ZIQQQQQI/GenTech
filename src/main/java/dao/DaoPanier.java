package dao;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/28
 */

import Outil.HibernateConn;
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

    /*
     * @param emailClient
	 * @param qte
	 * @param operation
	 * @param codeProd
     * @return
     * @author SI
     * @date 2021/3/30 9:00
     * @description
     */
    public void modifierQtePanier(String emailClient,int qte,String operation,String codeProd){
        System.out.println(emailClient);
        System.out.println(qte);
        System.out.println(operation);
        System.out.println(codeProd);
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t= session.beginTransaction();
        String sql="update panier set quantite =? where emailClient=? and codeProduit=?";

        System.out.println(sql);
        if(operation=="add"){
            qte = qte+1;
            session.createSQLQuery(sql).setParameter(1,qte).setParameter(2,emailClient).setParameter(3,codeProd).executeUpdate();
            System.out.println(sql);
        }
        else if(operation=="minus"){
            qte = qte-1;
            session.createSQLQuery(sql).setParameter(1,qte).setParameter(2,emailClient).setParameter(3,codeProd).executeUpdate();
        }

        t.commit();
        session.close();
    }

    /*
     * @param email
     * @return void
     * @author Si
     * @date 2021/3/30 8:59
     * @description
     */
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

    /*
     * @param email
	 * @param idP
     * @return void
     * @author Tang
     * @date 2021/3/30 8:59
     * @description
     */
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


    /*
     * @param emailClient
	 * @param codeProduit
     * @return void
     * @author Tu
     * @date 2021/3/30 8:59
     * @description
     */
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
