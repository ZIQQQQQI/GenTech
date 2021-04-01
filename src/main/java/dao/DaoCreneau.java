package dao;/*
 *@program GenTech3
 *@author LIU Yue
 *@date 28-03-21
 */

import Outil.HibernateConn;
import metier.Commande;
import metier.Creneau;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
/*

 *@return
 *@author LIU
 *@date 28-03-21 11:33
*/
public class DaoCreneau {

    /*
     *@param idheureretrait
	 *@param idcommande
     *@return void
     *@author SI
     *@date 28/03/2021 22:39
     *@exception Exception
     *@description mise a jour apres changer le creneau
    */
    public void updateCreaneau(String idheureretrait, String idcommande) {
        Session session = HibernateConn.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Commande commande = (Commande) session.get(Commande.class,idcommande);
        System.out.println(commande);
        commande.setHeureRetrait(idheureretrait);
       session.update(commande);
        session.getTransaction().commit();
        session.close();
    }

    /*
     *@param
     *@return java.util.ArrayList<metier.Creneau>
     *@author SI
     *@date 28/03/2021 22:40
     *@exception Exception
     *@description Rechercher tous les creneau
    */
    public ArrayList<Creneau> listCreneau() {
        Session session = HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();

        String sql = "select creneau.* from creneau";
        ArrayList<Creneau> list = null;
        try {
            list = (ArrayList<Creneau>) session.createSQLQuery(sql).addEntity(Creneau.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------------");
            System.out.println("DaoRayon listeCreaneau");
            System.out.println("----------------------");
        }
       t.commit();
       session.close();
       return list;
    }
}