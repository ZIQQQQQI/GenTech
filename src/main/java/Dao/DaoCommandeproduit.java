package Dao;/*
 *@program gentech2
 *@author LIU Yue
 *@date 23-03-21
 */

import Outil.HibernateConn;
import metier.Lignecommande;
import metier.Produit;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCommandeproduit {

    public static ArrayList<Produit> Commandeproduit (String idCdeCli)
            throws ClassNotFoundException, SQLException {
        /*----- Création de la connexion à la base de données -----*/
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();

        /*----- Interrogation de la base -----*/


        /*----- Requête SQL -----*/
        String sql="select codeProduit lignecommande l where l.idCdeCli=c.idCdeCli and c.idCdeCli=? ";
        List<Produit> list=session.createSQLQuery(sql).addEntity(Lignecommande.class).setParameter(1,"idCdeCli").list();
        for (Produit l:list
        ) {
            System.out.println(l);
        }

       return list;
    }



}
