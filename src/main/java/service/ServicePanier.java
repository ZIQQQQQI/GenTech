package service;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/28
 */

import dao.DaoPanier;

public class ServicePanier {
    private DaoPanier daoPanier=new DaoPanier();

    public void ajouer(String email,Integer idP){daoPanier.ajouer(email,idP);}
}
