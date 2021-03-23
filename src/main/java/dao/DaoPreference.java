package dao;
/*
 *@program GenTech
 *@author SI Lu
 *@date 23/03/2021
 */

import Outil.HibernateConn;
import metier.Preference;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DaoPreference{

    /*
     *@param emailClient
	 *@param codeProduit
     *@return void
     *@author SI
     *@date 23/03/2021 11:57
     *@exception Exception
     *@description un client ajoute un produit preferee
    */
    public void ajouterPeference(String emailClient,Integer codeProduit){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Preference p=new Preference();
        p.setCodeProduit(codeProduit);
        p.setEmailClient(emailClient);
        try{
            session.save(p);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoPreference ajouterPeference");
            System.out.println("----------------------------");

        }
        transaction.commit();
        session.close();
    }

    /*
     *@param emailClient
     *@return java.util.ArrayList<metier.Preference>
     *@author SI
     *@date 23/03/2021 12:02
     *@exception Exception
     *@description Recherche tous les preference d'un client
    */
    public ArrayList<Preference> listPrefere(String emailClient){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        String sql="select preference.* from preference where emailClient=?";
        ArrayList<Preference> listeProduitPrefere = null;
        try {
            listeProduitPrefere=(ArrayList<Preference>)session.createSQLQuery(sql).addEntity(Preference.class).setParameter(1,emailClient).list();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoPreference listPrefere");
            System.out.println("----------------------------");
        }
        transaction.commit();
        session.close();
        return listeProduitPrefere;
    }



}