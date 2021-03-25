package service;/*
 *@program GenTech
 *@author ziqi tang
 *@date 2021/3/23
 */

import dao.DaoProduit;
import dao.DaoRayonCategorie;
import dao.DaoRayonProduit;
import metier.Produit;

import java.util.ArrayList;

public class ServiceProduit {
    private DaoProduit daoProduit=new DaoProduit();
    private DaoRayonProduit daoRayonProduit=new DaoRayonProduit();

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
}
