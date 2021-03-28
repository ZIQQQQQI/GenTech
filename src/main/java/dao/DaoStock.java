package dao;/*
 *@program GenTech3
 *@author LIU Yue
 *@date 28-03-21
 */

import Outil.HibernateConn;
import metier.Entrepot;
import metier.Ligneachat;
import metier.Produit;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class DaoStock {
    public void ajouterCommande(String idCdeachat,String dateCdeAchat,String dateCdeArrive,String idMagasin){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Entrepot en =new  Entrepot();
        en.setIdCdeAchat(idCdeachat);
        en.setEtatCdeAchat(idCdeachat);
        en.setDateCdeAchat(dateCdeAchat);
        en.setDateCdeArrive(dateCdeArrive);
        en.setIdMagasin(idMagasin);
        try{
            session.save(en);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoPreference ajoute");
            System.out.println("----------------------------");

        }
        transaction.commit();
        session.close();
    }

    public void addLigneAchat(String idCdeAchat,Integer codeProduit,Long qteAchat,Long qteReste){
        Session session= HibernateConn.getSessionFactory().getCurrentSession();
        Transaction transaction=session.beginTransaction();
        Ligneachat La = new Ligneachat();
        La.setIdCdeAchat(idCdeAchat);
        La.setIdProduit(codeProduit);
        La.setQteAchat(qteAchat);
        La.setQteReste(qteReste);
        try{
            session.save(La);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoPreference ajouterLigneAchat");
            System.out.println("----------------------------");

        }
        transaction.commit();
        session.close();
    }


    public ArrayList<Ligneachat> achatDeja(Integer idcat) {
        Session session = HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();


        ArrayList<Ligneachat> listachat = null;
        String sql = "Select la.*\n" +
                "from ligneachat la ,entrepot e, produit p,rayon r,rayon r2\n" +
                "where e.idCdeAchat=la.idCdeAchat\n" +
                "and r.numcate=p.categorie \n" +
                "and r.idparant = r2.numcate\n" +
                "and p.codeProduit=la.idProduit\n" +
                "and str_to_date(dateCdearrive,'%d/%m/%Y') <date_format(curdate(),'%Y-%m-%d')\n" +
                "and r2.numcate=?";
        try {
            listachat = (ArrayList<Ligneachat>) session.createSQLQuery(sql).addEntity(Ligneachat.class).setParameter(1, idcat).list();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------");
            System.out.println("DaoCommandeProduit");
            System.out.println("----------------");
        }

        t.commit();
        session.close();
        return listachat;
    }

        public ArrayList<Ligneachat> achatFurure(Integer idcat){
            Session session= HibernateConn.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();


            ArrayList<Ligneachat> listfuture =null;
            String sql = "Select la.* from ligneachat la ,entrepot e, produit p,rayon r,rayon r2 \n" +
                    "where e.idCdeAchat=la.idCdeAchat\n" +
                    " and r.numcate=p.categorie \n" +
                    " and r.idparant = r2.numcate \n" +
                    " and p.codeProduit=la.idProduit \n" +
                    " and e.idCdeAchat=la.idCdeAchat\n" +
                    " and str_to_date(dateCdearrive,'%d/%m/%Y') \n" +
                    " between date_format(curdate(),'%Y-%m-%d')\n" +
                    " and DATE_SUB(CURDATE(), INTERVAL -15 DAY) and r2.numcate=?" ;
            try {
                listfuture= (ArrayList<Ligneachat>) session.createSQLQuery(sql).addEntity(Ligneachat.class).setParameter(1, idcat).list();
            }
            catch (Exception e){
                e.printStackTrace();
                System.out.println("----------------");
                System.out.println("DaoCommandeProduit");
                System.out.println("----------------");
            }



            t.commit();
            session.close();
            return listfuture;

        }

}
