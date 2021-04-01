package service;/*
 *@program GenTech
 *@author SI Lu
 *@date 28/03/2021
 */

import dao.DaoCommande;
import dao.DaoCommandeMagasin;
import dao.DaoLigneCommande;
import dao.DaoProduit;
import metier.Commande;
import metier.Lignecommande;
import metier.Magasin;
import metier.Produit;

import java.util.ArrayList;
import java.util.HashMap;

public class ServiceCommandeDetail {
    /*
     *@param idCde
     *@return metier.Magasin
     *@author SI
     *@date 28/03/2021 22:33
     *@exception
     *@description Rechercher magasin retrait d'un commande
    */
    public Magasin magasinCommande(String idCde){
        return new DaoCommandeMagasin().magasinComande(idCde);
    }

    /*
     *@param idCde
     *@return java.util.HashMap<metier.Produit,java.lang.Integer>
     *@author SI
     *@date 28/03/2021 22:34
     *@exception
     *@description Rechercher tous les ligne commande d'un commande
    */
    public HashMap<Produit,Integer> ligneCommandeDetail(String idCde){
        ArrayList<Lignecommande> tousLigneCommande =new DaoLigneCommande().tousLigneCommande(idCde);
        HashMap<Produit,Integer> res=new HashMap<>();
        for (Lignecommande l:tousLigneCommande){
            Produit p= new DaoProduit().rechercheUnProduit(l.getCodeProduit());
            res.put(p,l.getQuantite());
        }
        return res;
    }






    /*
     *@param idCde
     *@return metier.Commande
     *@author SI
     *@date 28/03/2021 22:35
     *@exception
     *@description Rechercher un commande par id de commande
    */
    public Commande unCommande(String idCde){
        return new DaoCommande().unCommande(idCde);
    }
}