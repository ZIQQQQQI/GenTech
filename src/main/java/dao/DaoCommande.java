package dao;/*
 *@program GenTech
 *@author SI Lu
 *@date 28/03/2021
 */

import Outil.HibernateConn;
import metier.Client;
import metier.Commande;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoCommande {
    /*
     *@param idCde
     *@return metier.Commande
     *@author SI
     *@date 28/03/2021 22:43
     *@exception Exception
     *@description Rechercher un commande par id de commande
    */
    public Commande unCommande(String idCde){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t= session.beginTransaction();
        Commande c=null;
        try {
            c=session.get(Commande.class,idCde);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoCommande unCommande");
            System.out.println("----------------------------");
        }
        t.commit();
        session.close();
        return c;
    }
}