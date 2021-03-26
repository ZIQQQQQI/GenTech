package service;

/*
 *@program GenTech
 *@author SI Lu
 *@date 23/03/2021
 */

import dao.DaoRayon;
import dao.DaoRayonCategorie;
import metier.Rayon;

import java.util.ArrayList;
import java.util.HashMap;

public class ServiceRayon {
    public DaoRayon dr=new DaoRayon();
    public DaoRayonCategorie drg=new DaoRayonCategorie();

    /*
     * @param
     * @return java.util.HashMap<metier.Rayon,java.util.ArrayList<metier.Rayon>>
     * @author SI Lu
     * @date 2021/3/25 11:19
     * @description recherche les categories d'un rayon
     */
    public HashMap<Rayon,ArrayList<Rayon>> allRayonAndCategories(){
        ArrayList<Rayon> tousLesRayon= dr.listeRayon();
        HashMap<Rayon,ArrayList<Rayon>> rayonCategorie=new HashMap<>();
        for (Rayon r:tousLesRayon){
            ArrayList<Rayon> categories=drg.listeRayonCategorie(r.getNumCate());
            rayonCategorie.put(r,categories);
        }
        return rayonCategorie;
    }
}
