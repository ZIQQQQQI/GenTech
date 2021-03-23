package dao;/*
 *@program GenTech1
 *@author TU
 *@date 23/03/2021
 */

import Outil.HibernateConn;
import metier.Rayon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DaoRayonCategorie {
    public static ArrayList<Rayon> listeRayonCategorie(Integer numRayon)
        {
            Session session= HibernateConn.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
            String sql = "select rayon.* from rayon where degre = ? and idParant = ?";
            ArrayList<Rayon> list = null;
            try{
                list=(ArrayList<Rayon>) session.createSQLQuery(sql).addEntity(Rayon.class).setParameter(1,2).setParameter(2,numRayon).list();
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("----------------------");
                System.out.println("DaoRayonCategorie listeRayonCategorie");
                System.out.println("----------------------");
            }
            t.commit();
            session.close();
            return list;
        }

}