package dao;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/31
 */

import Outil.HibernateConn;
import metier.Listecourse;
import metier.Postit;
import metier.Rayon;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

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

    /*
     * @param id
     * @return java.util.ArrayList<metier.Postit>
     * @author TANG
     * @date 2021/3/31 14:36
     * @description
     */
    public ArrayList<Postit> listPostListeCourse(String id){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t= session.beginTransaction();
        String sql = "Select p.* from postit p where idListe=?";
        ArrayList<Postit> l = new ArrayList<>();
        try {
            l = (ArrayList<Postit>)session.createSQLQuery(sql).addEntity(Postit.class).setParameter(1,id).list();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoPostIt listPostListeCourse");
            System.out.println("----------------------------");
        }
        t.commit();
        session.close();
        return l;
    }
    /*
     * @param idPost
    	 * @param idProduit
    	 * @param quantite
     * @return void
     * @author TANG
     * @date 2021/3/31 18:22
     * @description
     */
    public void updatePost(Integer idPost,Integer idProduit,Integer quantite){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t= session.beginTransaction();
        Postit post= session.get(Postit.class,idPost);
        post.setQuantite(quantite);
        post.setIdProduit(idProduit);
        t.commit();
        session.close();

    }
    /*
     * @param id
     * @return void
     * @author TANG
     * @date 2021/3/31 18:23
     * @description supprimer tous les post dans un liste
     */
    public void supprime(String id){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t= session.beginTransaction();
        /*----- Requête SQL -----*/
        String sql="delete from postit where idListe=?";

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
