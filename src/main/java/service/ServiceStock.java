package service;/*
 *@program GenTech3
 *@author LIU Yue
 *@date 28-03-21
 */

import dao.DaoProduit;
import dao.DaoStock;
import metier.Entrepot;
import metier.Ligneachat;
import metier.Produit;
import metier.Rayon;

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

    }

//    public ArrayList<Ligneachat> listfuture(Integer idcat,String idachat){
//        return ds.achatFurure(idcat,idachat);
//    }


//   public HashMap<Entrepot,ArrayList<Ligneachat>> allligneachahtnow (Integer idcat){
//       ArrayList<Entrepot> touscommandenow= ds.achatDate();
//       HashMap<Entrepot,ArrayList<Ligneachat>>ligneachaht=new HashMap<>();
//        for (Entrepot e :touscommandenow){
//            ArrayList<Ligneachat> ligneachat=ds.achatDeja(idcat,e.getIdCdeAchat());
//            ligneachaht.put(e,ligneachat);
//        }
//        return ligneachaht;
//    }
//
//
//    public HashMap<Entrepot,ArrayList<Ligneachat>> allligneachahtfuture (Integer idcat){
//        ArrayList<Entrepot> touscommandefu= ds.achatDate();
//        HashMap<Entrepot,ArrayList<Ligneachat>>ligneachatfu=new HashMap<>();
//        for (Entrepot e :touscommandefu){
//            ArrayList<Ligneachat> listachatfu=ds.achatDeja(idcat,e.getIdCdeAchat());
//            ligneachatfu.put(e,listachatfu);
//        }
//        return ligneachatfu;
//    }

//    public HashMap<Produit,HashMap<Entrepot,Ligneachat>> allligneachahtnow (Integer idcat){
//        ArrayList<Entrepot> touscommandefu= ds.achatdejaDate(1);
//
//        HashMap<Produit,HashMap<Entrepot,Ligneachat>> achatproduit =new HashMap<>();
//
//        HashMap<Entrepot,Ligneachat> el =new HashMap<>();
//        for (Produit p :achatproduit.keySet()){
//            HashMap<Entrepot,Ligneachat> h= achatproduit.get(p);
//            for (Entrepot e:h.keySet()
//                 ) {
//                Entrepot enree=e;
//                Ligneachat enrl=h.get(e);
//            }
//
//        }
//        return achatproduit;
//    }



