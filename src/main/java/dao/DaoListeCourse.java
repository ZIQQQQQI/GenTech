package dao;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/31
 */

import Outil.HibernateConn;
import metier.Listecourse;
import metier.Produit;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

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

    /*
     * @param id
     * @return metier.Listecourse
     * @author TANG
     * @date 2021/3/31 15:04
     * @description
     */
    public Listecourse  rechercheUnListecourse(String id){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t= session.beginTransaction();
        Listecourse listecourse= session.get(Listecourse.class,id);
        t.commit();
        session.close();
        return  listecourse;
    }

    /*
     * @param email
     * @return java.util.ArrayList<metier.Listecourse>
     * @author TANG
     * @date 2021/3/31 15:04
     * @description
     */
    public ArrayList<Listecourse> listecourseUnClient(String email){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t= session.beginTransaction();
        /*----- Requête SQL -----*/
        String sql="select  l.* from listecourse l where emailClient=?";
        ArrayList<Listecourse> list=new ArrayList<>();
        try {
            list = (ArrayList<Listecourse>) session.createSQLQuery(sql).addEntity(Listecourse.class).setParameter(1, email).list();
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------");
            System.out.println("DaoCommandeProduit");
            System.out.println("----------------");
        }

        t.commit();
        session.close();
        return list;
    }
    /*
     * @param id
     * @return void
     * @author TANG
     * @date 2021/3/31 18:22
     * @description
     */
    public void supprimeListCourse(String id){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t= session.beginTransaction();
        /*----- Requête SQL -----*/
        String sql="delete from listecourse where idListe=?";

        try {
            session.createSQLQuery(sql).setParameter(1,id).executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------");
            System.out.println("DaoListe Cours supprimer");
            System.out.println("----------------");
        }

        t.commit();
        session.close();
    }


}
