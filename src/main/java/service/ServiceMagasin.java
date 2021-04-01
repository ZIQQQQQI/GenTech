package service;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/24
 */

import dao.DaoMagasin;
import metier.Magasin;

import java.util.ArrayList;

public class ServiceMagasin {
    private DaoMagasin daoMagasin=new DaoMagasin();

    /*
     * @param
     * @return java.util.ArrayList<metier.Magasin>
     * @author TANG
     * @date 2021/3/25 11:17
     * @description trouver tous les magasin
     */
    public ArrayList<Magasin> listMagasin(){return this.daoMagasin.listeMagasin();}


}
