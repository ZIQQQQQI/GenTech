package service;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/31
 */

import dao.DaoListeCourse;
import metier.Listecourse;

public class ServiceListeCourse {
    DaoListeCourse daoListeCourse=new DaoListeCourse();


    /*
     * @param listecourse
     * @return void
     * @author TANG
     * @date 2021/3/31 8:47
     * @description
     */
    public void creerListeCourse(Listecourse listecourse){ daoListeCourse.creerUneListe(listecourse);}
}
