package dao;/*
 *@program GenTech1
 *@author TU
 *@date 23/03/2021
 */

import metier.Produit;
import metier.Rayon;

import java.util.ArrayList;

public class DaoRayonProduit implements DaoBasic{
    public static ArrayList<Produit> listeRayonProduit(Integer numCate)
    {
        session.beginTransaction();
        String sql = "select p.* from produit p, rayon r where p.categorie = r.numCate and p.categorie=?";
        ArrayList<Produit> list = null;
        try{
            list=(ArrayList<Produit>) session.createSQLQuery(sql).addEntity(Produit.class).setParameter(1,numCate).list();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("----------------------");
            System.out.println("DaoRayonProduit listeRayonProduit");
            System.out.println("----------------------");

        }
        return list;
    }
}