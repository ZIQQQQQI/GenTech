package dao;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/31
 */

import Outil.HibernateConn;
import metier.Listecourse;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoListeCourse {

    
    /* 
     * @param l
     * @return void
     * @author TANG
     * @date 2021/3/31 8:43
     * @description
     */
    public void creerUneListe(Listecourse l){

        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t= session.beginTransaction();
        session.save(l);
        t.commit();
        session.close();

    }
}
