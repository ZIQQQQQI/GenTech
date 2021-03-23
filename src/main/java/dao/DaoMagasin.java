package dao;/*
 *@program GenTech
 *@author ziqi tang
 *@date 2021/3/23
 */

import metier.Client;
import metier.Commande;
import metier.Magasin;

import java.util.ArrayList;

public class DaoMagasin implements DaoBasic{
    /*
     * @param
     * @return java.util.ArrayList<metier.Magasin>
     * @author TANG
     * @exception Exception
     * @date 2021/3/23 11:41
     * @description trouves tous les magasin
     */
    public ArrayList<Magasin> listeMagasin(){
        session.beginTransaction();
        String sql="select m.* from magasin m";
        ArrayList<Magasin> m=null;
        try {
            m=(ArrayList<Magasin>) session.createSQLQuery(sql).addEntity(Magasin.class).list();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("----------------------------");
            System.out.println("DaoClient unclient not ok");
            System.out.println("----------------------------");
        }
        return m;
    }
}
