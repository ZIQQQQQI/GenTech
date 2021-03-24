package service;

/*
 *@program GenTech
 *@author SI Lu
 *@date 23/03/2021
 */

import dao.DaoRayon;
import metier.Rayon;

import java.util.ArrayList;

public class ServiceRayon {
    public DaoRayon dr=new DaoRayon();

    public ArrayList<Rayon> allRayon(){
        return dr.listeRayon();
    }
}