package dao;/*
 *@program GenTech1
 *@author TU
 *@date 23/03/2021
 */

import metier.Rayon;

import java.util.ArrayList;

public class DaoRayonCategorie implements DaoBasic{
    public static ArrayList<Rayon> listeRayonCategorie(Integer numRayon)
        {
            session.beginTransaction();
            String sql = "select rayon.* from rayon where degre = ? and idParant = ?";
            ArrayList<Rayon> list = null;
            try{
                list=(ArrayList<Rayon>) session.createSQLQuery(sql).addEntity(Rayon.class).setParameter(1,2).setParameter(2,numRayon).list();
            }catch(Exception e){
                e.printStackTrace();
                System.out.println("----------------------");
                System.out.println("DaoRayonCategorie listeRayonCategorie");
                System.out.println("----------------------");
            }
            return list;
        }

}