package dao;

/*
 *@param null
 *@return 
 *@author Tu 
 *@description  
 *@exception
 *@date 28/03/2021 22:55
*/

import Outil.HibernateConn;
import metier.Ligneachat;
import metier.Preference;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoLigneAchat {
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
}