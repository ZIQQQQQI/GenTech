package service;
/*
 *@param null
 *@return
 *@author Tu
 *@description service pour rechercher un produit par mot-cle
 *@exception
 *@date 25/03/2021 09:04
 */

import dao.DaoProduit;
import metier.Produit;

import java.util.ArrayList;

public class ServiceRechercher {
    public ArrayList<Produit> findProduitByWord(String word){
        DaoProduit dp = new DaoProduit();
        return dp.listProduitMotCle(word);
    }
}