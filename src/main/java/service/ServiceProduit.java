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

    public ArrayList<Produit> listProduit(String facon){
        return daoProduit.listProduitOrdrePrix(facon);
    }

    public Produit unProduit(Integer id){return  daoProduit.rechercheUnProduit(id);}

    public ArrayList<Produit> listeRayonProduit(Integer numCate){
        return daoRayonProduit.listeRayonProduit(numCate);
    }
}
