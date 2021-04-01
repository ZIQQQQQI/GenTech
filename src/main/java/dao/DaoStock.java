package dao;/*
 *@program GenTech3
 *@author LIU Yue
 *@date 28-03-21
 */

import Outil.HibernateConn;
import metier.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashMap;

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

        public ArrayList<Ligneachat> ligneachatsProduit(Integer produitId){
            Session session = HibernateConn.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
            String  sql="Select la.* " +
                    "from ligneachat la ,entrepot e, produit p " +
                    "where e.idCdeAchat=la.idCdeAchat " +
                    "and p.codeProduit=la.idProduit" +
                    " and str_to_date(dateCdearrive,'%d/%m/%Y') <date_format(curdate(),'%Y-%m-%d') " +
                    "and p.codeProduit=? " +
                    "order by str_to_date(dateCdearrive,'%d/%m/%Y') asc";
            ArrayList<Ligneachat> l=null;
            try{
        l = (ArrayList<Ligneachat>) session.createSQLQuery(sql).addEntity(Ligneachat.class).setParameter(1, produitId).list();
            }catch (Exception e){
                System.out.println("----------------");
                System.out.println("Daostockdeja");
                System.out.println("----------------");
            }
            t.commit();
            session.close();
           return l;
        }

    public ArrayList<Ligneachat> ligneachatsfuture(Integer produitId){
        Session session = HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        String  sql="\tSelect la.* from ligneachat la ,entrepot e, produit p,rayon r,rayon r2 \n" +
                "\t\twhere e.idCdeAchat=la.idCdeAchat\n" +
                "\t\t and r.numcate=p.categorie \n" +
                "\t\t and r.idparant = r2.numcate \n" +
                "\t\t and p.codeProduit=la.idProduit \n" +
                "\t\t and e.idCdeAchat=la.idCdeAchat\n" +
                "\t\t and str_to_date(dateCdearrive,'%d/%m/%Y') \n" +
                "\t\t between date_format(curdate(),'%Y-%m-%d')\n" +
                "\t\t and DATE_SUB(CURDATE(), INTERVAL -15 DAY) \n" +
                "\t\t and p.codeproduit=?\n" +
                "\t\t ";
        ArrayList<Ligneachat> l=null;
        try{
            l = (ArrayList<Ligneachat>) session.createSQLQuery(sql).addEntity(Ligneachat.class).setParameter(1, produitId).list();
        }catch (Exception e){
            System.out.println("----------------");
            System.out.println("Daostockdeja");
            System.out.println("----------------");
        }
        t.commit();
        session.close();
        return l;
    }


        public ArrayList<HashMap<Ligneachat, Entrepot>> listCommLigne(ArrayList<Ligneachat> list){
            ArrayList<HashMap<Ligneachat, Entrepot>> l=new ArrayList<>();
            Session session = HibernateConn.getSessionFactory().getCurrentSession();
            Transaction t = session.beginTransaction();
            for (Ligneachat ligne:list
                 ) {
                String idCoo=ligne.getIdCdeAchat();
                Entrepot e=session.get(Entrepot.class,idCoo);
                HashMap<Ligneachat, Entrepot> h=new HashMap<>();
                h.put(ligne,e);
                l.add(h);
            }
            t.commit();
            session.close();
            return  l;
        }

    public ArrayList<Entrepot> achatdejaDate(Integer codeproduit) {
        Session session = HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();

        ArrayList<Entrepot> listEp = null;
        String sql = "select e.* \n" +
                "from entrepot e , ligneachat la,produit p\n" +
                " where e.idCdeAchat =la.idCdeAchat \n" +
                " and p.codeProduit=la.idProduit\n" +
                " and P.codeproduit=?";
        try {
            listEp = (ArrayList<Entrepot>) session.createSQLQuery(sql).addEntity(Entrepot.class).setParameter(1,codeproduit).list();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------");
            System.out.println("entrepot");
            System.out.println("----------------");
        }
        t.commit();
        session.close();
        return listEp;
    }


    public ArrayList<Entrepot> Toutlistachat() {
        Session session = HibernateConn.getSessionFactory().getCurrentSession();
        Transaction t = session.beginTransaction();
        ArrayList<Entrepot> toutacha = null;
        String sql = "select * from entrepot";
        try{
            toutacha=(ArrayList<Entrepot>) session.createSQLQuery(sql).addEntity(Entrepot.class).list();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("----------------------");
            System.out.println("DaoRayon listeachat");
            System.out.println("----------------------");
        }
        t.commit();
        session.close();
        return toutacha;

    }
}
