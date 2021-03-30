package dao;/*
 *@program GenTech
 *@author SI Lu
 *@date 28/03/2021
 */

import Outil.HibernateConn;
import metier.Client;
import metier.Lignecommande;
import metier.Magasin;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DaoLigneCommande {
    /*
     *@param idCde
     *@return java.util.ArrayList<metier.Lignecommande>
     *@author SI
     *@date 28/03/2021 22:37
     *@exception Exception
     *@description Rechercher tous les ligne commande d'un commande
    */
    public ArrayList<Lignecommande> tousLigneCommande(String idCde){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t= session.beginTransaction();
        String sql="select * from ligneCommande where idCdeCli=?";
        ArrayList<Lignecommande> list=null;
        try{
            list=(ArrayList<Lignecommande>) session.createSQLQuery(sql).addEntity(Lignecommande.class).setParameter(1,idCde).list();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoLigneCommande  tousLigneCommande");
            System.out.println("----------------------------");
        }
        t.commit();
        session.close();
        return list;
    }
}