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

public class ServiceStock {
    DaoStock ds = new DaoStock();
    DaoProduit dp = new DaoProduit();

    public ArrayList<Ligneachat> listdeja(Integer codeproduit){
        return ds.ligneachatsProduit(codeproduit);
    }

    public ArrayList<Ligneachat>ligneachatsfuture(Integer codeproduit){
        return ds.ligneachatsfuture(codeproduit);
    }

    public ArrayList<HashMap<Ligneachat, Entrepot>> listCommLigne(ArrayList<Ligneachat> list){
        return ds.listCommLigne(list);
    }

    public ArrayList<String> listEntrepot(){
        ArrayList<String> listIdCdeAchat = new ArrayList<>();
        for(Entrepot e: ds.Toutlistachat()){
            listIdCdeAchat.add(e.getIdCdeAchat());
        }
        return listIdCdeAchat;
    }
    }





