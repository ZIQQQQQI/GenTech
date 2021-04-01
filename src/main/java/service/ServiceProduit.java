package service;/*
 *@program GenTech
 *@author ziqi tang
 *@date 2021/3/23
 */

import dao.*;
import metier.Panier;
import metier.Preference;
import metier.Produit;

import java.util.ArrayList;
import java.util.Collections;

public class ServiceProduit {
    private DaoProduit daoProduit=new DaoProduit();
    private DaoRayonProduit daoRayonProduit=new DaoRayonProduit();
    private DaoPreference daoPreference=new DaoPreference();
    private DaoPanier daoPanier=new DaoPanier();
    /*
     * @param facon
     * @return java.util.ArrayList<metier.Produit>
     * @author TANG
     * @date 2021/3/25 11:18
     * @description trouves tous les produits
     */
    public ArrayList<Produit> listProduit(String facon){
        return daoProduit.listProduitOrdrePrix(facon);
    }


    /*
     * @param id
     * @return metier.Produit
     * @author TANG
     * @date 2021/3/25 11:18
     * @description trouver un produit selon id
     */
    public Produit unProduit(Integer id){return  daoProduit.rechercheUnProduit(id);}

    public ArrayList<Produit> listeRayonProduit(Integer numCate){
        return daoRayonProduit.listeRayonProduit(numCate);
    }

    /*
     * @param prix
     * @return java.util.ArrayList<metier.Produit>
     * @author LIU Yue
     * @date 2021/3/25 11:19
     * @description trier les produit selon prix
     */
    public ArrayList<Produit> listParPrix(String prix){

        ArrayList<Produit> list;
        if (prix.equals("asc")) {
            list = this.listProduit("asc");
        }
        else{
             list = this.listProduit("desc");

        }
        return list;
    }

    /*
     * @param prix
     * @return java.util.ArrayList<metier.Produit>
     * @author LIU Yue
     * @date 2021/3/25 11:19
     * @description trier les produit selon prix et categorie
     */
    public ArrayList<Produit> listRayonOrdrePrix(String ordre,Integer codecat){
        return DaoRayonProduit.listRayonProOrdrePrix(ordre,codecat);
    }
    /*
     * @param email
     * @return java.util.ArrayList<metier.Produit>
     * @author TANG
     * @date 2021/3/25 17:25
     * @description list produit preference d'un client
     */
    public ArrayList<Produit> listProduitPrefre(String email){
        ArrayList<Preference> listPre=daoPreference.listPrefere(email);

        ArrayList<Produit> listPro=new ArrayList<>();

        for (Preference p:listPre){

            listPro.add(daoProduit.rechercheUnProduit(p.getCodeProduit()));
        }


        return listPro;
    }

    /*
     * @param email
     * @return java.util.ArrayList<metier.Produit>
     * @author TANG
     * @date 2021/3/28 17:44
     * @description recherche un panier d'un client avec son email
     */
    public ArrayList<Produit> listProduitPanier(String email){
        ArrayList<Panier> list=daoPanier.listPanierUnClient(email);
        ArrayList<Produit> listP=new ArrayList<>();

        for (Panier p:list
        ) {
            listP.add(daoProduit.rechercheUnProduit(p.getCodeProduit()));
        }

        return listP;
    }



    public ArrayList<Produit> listProduisPromo(){
        return daoProduit.listProduitEnPromo();
    }



}
