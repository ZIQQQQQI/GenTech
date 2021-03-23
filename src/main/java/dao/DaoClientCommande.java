package dao;/*
 *@program GenTech
 *@author ziqi tang
 *@date 2021/3/23
 */

import metier.Client;
import metier.Commande;
import metier.Lignecommande;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class DaoClientCommande implements DaoBasic{
    /*
     * @param [emailClient]
     * @return java.util.ArrayList<metier.Commande>
     * @author TANG
     * @date 2021/3/23 11:09
     * @exception Exception
     * @description trouver liste de une commande d'un client
     */
    public ArrayList<Commande> listeCommandeClient(String emailClient){
        session.beginTransaction();
        String sql="select c.* from commande c,client cl where c.emailClient=cl.emailClient and cl.emailClient=?";

        ArrayList<Commande> list=null;
        try {
            list=(ArrayList<Commande>) session.createSQLQuery(sql).addEntity(Commande.class).setParameter(1,emailClient).list();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoClientCommande listeCommandeClient");
            System.out.println("----------------------------");
        }
        return list;
    }






}
