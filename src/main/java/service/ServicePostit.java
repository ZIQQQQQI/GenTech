package service;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/31
 */

import dao.DaoPostIt;
import metier.Postit;

public class ServicePostit {
    DaoPostIt daoPostIt=new DaoPostIt();

    /*
     * @param postit
     * @return void
     * @author TANG
     * @date 2021/3/31 8:49
     * @description
     */
    public  void creerPost(Postit postit){daoPostIt.creerUnPostit(postit);};
}
