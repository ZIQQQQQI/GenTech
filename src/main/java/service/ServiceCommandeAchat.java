package service;/*
 *@program GenTech3
 *@author LIU Yue
 *@date 29-03-21
 */

import dao.DaoStock;

public class ServiceCommandeAchat {
    DaoStock ds = new DaoStock();
    public void  ajouterCommande(String idCdeachat,String dateCdeAchat,String dateCdeArrive,String idMagasin){
        ds.ajouterCommande(idCdeachat,dateCdeAchat,dateCdeArrive,idMagasin);
    }
    public void addLigneAchat(String idCdeAchat,Integer codeProduit,Long qteAchat,Long qteReste){
        ds.addLigneAchat(idCdeAchat,codeProduit,qteAchat,qteReste);
    }

}
