package dao;/*
 *@program GenTech
 *@author SI Lu
 *@date 29/03/2021
 */

import Outil.HibernateConn;
import metier.Enpromo;
import metier.Produit;
import metier.Promotion;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DaoPromotion {
    public ArrayList<Promotion> listPromotion(){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t=session.beginTransaction();
        ArrayList<Promotion> promotions=new ArrayList<>();
        String sql="select promotion.* from promotion";
        try{
            promotions=(ArrayList<Promotion>)session.createSQLQuery(sql).addEntity(Promotion.class).list();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoPromotions listPromotion");
            System.out.println("----------------------------");
        }
        t.commit();
        session.close();
        return promotions;
    }

    public ArrayList<Enpromo> listEnPromo(){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t=session.beginTransaction();
        ArrayList<Enpromo> enpromos=new ArrayList<>();
        String sql="select enpromo.* from enpromo";
        try{
            enpromos=(ArrayList<Enpromo>)session.createSQLQuery(sql).addEntity(Enpromo.class).list();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoPromotions listEnPromo");
            System.out.println("----------------------------");
        }
        t.commit();
        session.close();
        return enpromos;

    }
}