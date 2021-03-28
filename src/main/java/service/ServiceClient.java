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

    public ArrayList<Client> allClient(){
        return daoClient.listClient();
    }
    public void updateCli(String email, String idM){
        daoClient.updateClient(email, idM);
    }

}
