package service;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/25
 */

import dao.DaoClient;
import metier.Client;

import java.util.ArrayList;

public class ServiceClient {
    private DaoClient daoClient=new DaoClient();


    /*
     * @param email
     * @return metier.Client
     * @author TANG
     * @date 2021/3/25 12:19
     * @description recherche un client avec son email
     */
    public Client unClient(String email){
        return daoClient.unClient(email);
    }

    /*
     *@param
     *@return java.util.ArrayList<metier.Client>
     *@author SI
     *@date 28/03/2021 22:36
     *@exception
     *@description Rechercher tous les client
    */
    public ArrayList<Client> allClient(){
        return daoClient.listClient();
    }

}
