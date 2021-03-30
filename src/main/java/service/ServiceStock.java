package service;/*
 *@program GenTech3
 *@author LIU Yue
 *@date 28-03-21
 */

import dao.DaoProduit;
import dao.DaoStock;
import metier.Entrepot;
import metier.Ligneachat;


import java.util.ArrayList;
import java.util.HashMap;
/*
 *@param null
 *@return
 *@author LIU
 *@date 30-03-21 15:47
*/
public class ServiceStock {
    DaoStock ds = new DaoStock();
    DaoProduit dp = new DaoProduit();

    public ArrayList<Ligneachat>ligneachatsfuture(Integer codeproduit){
        return ds.ligneachatsfuture(codeproduit);
    }
    public ArrayList<HashMap<Ligneachat, Entrepot>> listCommLigne(ArrayList<Ligneachat> list){
        return ds.listCommLigne(list);
    }

    }





