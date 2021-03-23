package dao;/*
 *@program GenTech
 *@author ziqi tang
 *@date 2021/3/23
 */

import metier.Client;
import metier.Commande;
import org.hibernate.hql.internal.classic.ClassicQueryTranslatorFactory;

import java.util.ArrayList;

public class DaoClient implements DaoBasic{
    /*
     * @param [emailClient]
     * @return metier.Client
     * @author TANG
     * @date 2021/3/23 11:31
     * @exception Exception
     * @description trouver un client selon email
     */
    public Client unClient(String emailClient){
        session.beginTransaction();
        Client c=null;
        try {
            c=session.get(Client.class,emailClient);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoClient unclient not ok");
            System.out.println("----------------------------");
        }

        return c;
    }
}
