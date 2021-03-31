package dao;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/31
 */

import Outil.HibernateConn;
import metier.Listecourse;
import metier.Postit;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoPostIt {


    /*
     * @param p
     * @return void
     * @author TANG
     * @date 2021/3/31 8:42
     * @description creer un postit
     */
    public void creerUnPostit(Postit p){

        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t= session.beginTransaction();
        session.save(p);
        t.commit();
        session.close();

    }
}
