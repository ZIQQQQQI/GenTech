package dao;/*
 *@program GenTech
 *@author SI Lu
 *@date 28/03/2021
 */

import Outil.HibernateConn;
import Outil.RandomString;
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

    public void ajouterCommande(String idCde,String dateCdeCli,String dateRetrait,String heureRetrait,String emailClient,double prixTotal,double economie,String idMagasin){
        String etat="valide";
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t= session.beginTransaction();
        Commande commande=new Commande();
        commande.setIdCdeCli(idCde);
        commande.setDateCdeCli(dateCdeCli);
        commande.setDateRetrait(dateRetrait);
        commande.setHeureRetrait(heureRetrait);
        commande.setEtat(etat);
        commande.setEmailClient(emailClient);
        commande.setPrixTotal(prixTotal);
        commande.setEconomie(economie);
        commande.setIdMagasin(idMagasin);
        session.save(commande);
        t.commit();
        session.close();
    }
}