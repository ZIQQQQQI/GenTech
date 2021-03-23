package service;/*
 *@program GenTech
 *@author ziqi tang
 *@date 2021/3/23
 */

import dao.DaoProduit;
import metier.Produit;

import java.util.ArrayList;

public class ServiceProduit {
    private DaoProduit daoProduit=new DaoProduit();

    public ArrayList<Produit> listProduit(String facon){
        return daoProduit.listProduitOrdrePrix(facon);
    }
}
