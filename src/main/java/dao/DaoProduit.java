package dao;

/*
 *@program GenTech
 *@author SI Lu
 *@date 23/03/2021
 */

import Outil.HibernateConn;
import metier.Preference;
import metier.Produit;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DaoProduit{



    /*
     *@param codeProduit
     *@return metier.Produit
     *@author SI
     *@date 23/03/2021 12:24
     *@exception Exception
     *@description Rechercher un produit par son code
    */
    public Produit rechercheUnProduit(Integer codeProduit){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Produit p = null;
        try {
            p=session.get(Produit.class,codeProduit);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoPreference listPrefere");
            System.out.println("----------------------------");
        }
        transaction.commit();
        session.close();
        return p;
    }

    /*
     *@param order
     *@return java.util.ArrayList<metier.Produit>
     *@author SI
     *@date 23/03/2021 14:00
     *@exception Exception
     *@description Rechercher une liste de produit par l'ordre prix crossiant ou decrossiant ou pas d'ordre
    */
    public ArrayList<Produit> listProduitOrdrePrix(String order){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        String sql="Select produit.* from produit ";
        if (order.equals("desc")){
            sql=sql+"order by produit.prixVente DESC";
        }else if (order.equals("asc")){
            sql=sql+"order by produit.prixVente ASC";
        }
        ArrayList<Produit> listProduit = null;
        try{
            listProduit=(ArrayList<Produit>)session.createSQLQuery(sql).addEntity(Produit.class).list();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoPreference listPrefere");
            System.out.println("----------------------------");
        }
        transaction.commit();
        session.close();
        return listProduit;
    }

    /*
     *@param motCle
     *@return java.util.ArrayList<metier.Produit>
     *@author SI
     *@date 23/03/2021 14:22
     *@exception Exception
     *@description Rechercher une liste de produit par mot cle
    */
    public ArrayList<Produit> listProduitMotCle(String motCle){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        String sql="Select produit.* from produit where libelleProduit like ?";
        ArrayList<Produit> produitMotCle = null;
        try{
            produitMotCle=(ArrayList<Produit>)session.createSQLQuery(sql).addEntity(Produit.class).setParameter(1,"%"+motCle+"%").list();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoPreference listPrefere");
            System.out.println("----------------------------");
        }
        transaction.commit();
        session.close();
        return produitMotCle;
    }

    /*
     * @param
     * @return java.util.ArrayList<metier.Produit>
     * @author TANG
     * @date 2021/3/25 22:36
     * @description trouver tous les produit en promo
     */
    public ArrayList<Produit> listProduitEnPromo(){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        String sql=
                "select p.*" +
                " from enpromo e, promotion pr,produit p" +
                " where pr.idpromo = e.idPromo" +
                " and P.codeproduit = e.codeproduit" +
                " and date_format(curdate(),'%Y/%m/%d')between str_to_date(pr.dateDebut,'%d/%m/%Y')and str_to_date(pr.dateFin,'%d/%m/%Y')" +
                " and pr.idPromo=1001";
        ArrayList<Produit> produitEnPromo = null;
        try{
            produitEnPromo=(ArrayList<Produit>)session.createSQLQuery(sql).addEntity(Produit.class).list();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoPreference listProduitEnPromo");
            System.out.println("----------------------------");
        }
        transaction.commit();
        session.close();
        return produitEnPromo;
    }
}