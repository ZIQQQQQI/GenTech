package service;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/25
 */

import dao.DaoClient;
import metier.Client;

public class ServiceClient {
    private DaoClient daoClient;


    /*
     * @param email
     * @return metier.Client
     * @author TANG
     * @date 2021/3/25 12:19
     * @description recherche un client avec son email
     */
    public Client unClient(String email){
        return this.daoClient.unClient(email);
    }
}
