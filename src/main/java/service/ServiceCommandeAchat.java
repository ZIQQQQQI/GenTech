package service;/*
 *@program GenTech3
 *@author LIU Yue
 *@date 29-03-21
 */

import dao.DaoStock;

public class ServiceCommandeAchat {
    DaoStock ds = new DaoStock();

    /*
     *@param idCdeachat
    	 * @param dateCdeAchat
    	 * @param dateCdeArrive
    	 * @param etatCdeAchat
    	 * @param idMagasin
     *@return void
     *@author Yufei
     *@date 2021/4/2 5:21
     *@exception
     *@description ajouter une commande
    */
    public void  ajouterCommande(String idCdeachat,String dateCdeAchat,String dateCdeArrive,String etatCdeAchat,String idMagasin){
        ds.ajouterCommande(idCdeachat,dateCdeAchat,dateCdeArrive,etatCdeAchat,idMagasin);
    }

    /*
     *@param idCdeAchat
    	 * @param codeProduit
    	 * @param qteAchat
    	 * @param qteReste
     *@return void
     *@author Yufei
     *@date 2021/4/2 5:22
     *@exception
     *@description ajouter une ligneAchat
    */
    public void addLigneAchat(String idCdeAchat,Integer codeProduit,Long qteAchat,Long qteReste){
        ds.addLigneAchat(idCdeAchat,codeProduit,qteAchat,qteReste);
    }

}
