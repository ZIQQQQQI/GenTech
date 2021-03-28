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

    public ArrayList<Creneau> allCreneau() {
        return dc.listCreneau();
    }
    public void UpdateCreneau(String email, String idM) {
        dc.updateCreaneau(email, idM);
    }
}