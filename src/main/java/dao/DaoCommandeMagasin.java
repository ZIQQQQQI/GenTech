package dao;/*
 *@program GenTech
 *@author SI Lu
 *@date 28/03/2021
 */

import Outil.HibernateConn;
import metier.Client;
import metier.Magasin;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DaoCommandeMagasin {
    /*
     *@param idCde
     *@return metier.Magasin
     *@author SI
     *@date 28/03/2021 22:41
     *@exception Exception
     *@description Rechercher Magasin retraiy d'un commande
    */
    public Magasin magasinComande(String idCde){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t= session.beginTransaction();
        String sql="select m.* from magasin m,commande c where c.idMagasin=m.idMagasin and c.idcdecli=?";
        Magasin magasin=null;
        try{
           ArrayList<Magasin> res=(ArrayList<Magasin>) session.createSQLQuery(sql).addEntity(Magasin.class).setParameter(1,idCde).list();
           magasin=res.get(0);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoCommandeMagasin  magasinComande");
            System.out.println("----------------------------");
        }
        t.commit();
        session.close();
        return magasin;
    }
}