package service;/*
 *@program GenTech3
 *@author LIU Yue
 *@date 28-03-21
 */

import dao.DaoCreneau;
import metier.Client;
import metier.Creneau;


import java.util.ArrayList;

public class ServiceCreneau {
    DaoCreneau dc = new DaoCreneau();
    /*
     *@param
     *@return java.util.ArrayList<metier.Creneau>
     *@author SI
     *@date 28/03/2021 22:31
     *@exception
     *@description Rechercher tous les creneau
    */
    public ArrayList<Creneau> allCreneau() {
        return dc.listCreneau();
    }

    /*
     *@param idheureretrait
	 *@param idcommande
     *@return void
     *@author SI
     *@date 28/03/2021 22:31
     *@exception
     *@description Mise a jour un creneau
    */
    public void UpdateCreneau(String idheureretrait, String idcommande) {
        dc.updateCreaneau(idheureretrait, idcommande);
    }
}