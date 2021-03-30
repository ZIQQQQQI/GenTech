package service;/*
 
/*
 *@param null
 *@return 
 *@author Tu 
 *@description  
 *@exception
 *@date 28/03/2021 14:44
*/


import dao.DaoPreference;

public class ServicePreference {
    DaoPreference dp = new DaoPreference();
    public void addPreference(String email, Integer idProduit){
        dp.ajouterPeference(email, idProduit);
    }



    public void supPreference(String email, Integer idProduit) {
        dp.supprimerPre(email, idProduit);
    }

}
