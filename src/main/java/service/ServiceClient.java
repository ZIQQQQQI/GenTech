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
     *@author Yufei
     *@date 2021/4/2 5:21
     *@exception 
    */
    public ArrayList<Client> allClient(){
        return daoClient.listClient();
    }
    
    /*
     *@param email
    	 * @param idM
     *@return void
     *@author Yufei
     *@date 2021/4/2 5:20
     *@exception 
    */
    public void updateCli(String email, String idM){
        daoClient.updateClient(email, idM);
    }

}
