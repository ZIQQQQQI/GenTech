package service;/*
 *@program GenTech
 *@author SI Lu
 *@date 24/03/2021
 */

import dao.DaoClientCommande;
import metier.Commande;

import java.util.ArrayList;

public class ServiceCommande {
    private DaoClientCommande daoClientCommande=new DaoClientCommande();

    public ArrayList<Commande> listCommandeEnCours (String emailClient){
        return daoClientCommande.listCommandeEnCours(emailClient);
    }
}