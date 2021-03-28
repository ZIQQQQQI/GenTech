package service;/*
 *@program GenTech3
 *@author LIU Yue
 *@date 28-03-21
 */

import dao.DaoProduit;
import dao.DaoStock;
import metier.Ligneachat;
import metier.Produit;

import java.util.ArrayList;

public class ServiceStock {
    DaoStock ds = new DaoStock();
    public ArrayList<Ligneachat> listdeja(Integer idcat){
        return ds.achatDeja(idcat);
    }
    public ArrayList<Ligneachat> listfuture(Integer idcat){
        return ds.achatFurure(idcat);
    }
}
