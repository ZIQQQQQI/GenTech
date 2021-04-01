package service;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/31
 */

import dao.DaoListeCourse;
import dao.DaoPostIt;
import metier.Listecourse;

import java.util.ArrayList;

public class ServiceListeCourse {
    DaoListeCourse daoListeCourse=new DaoListeCourse();
    DaoPostIt daoPostIt=new DaoPostIt();

    /*
     * @param listecourse
     * @return void
     * @author TANG
     * @date 2021/3/31 8:47
     * @description
     */
    public void creerListeCourse(Listecourse listecourse){ daoListeCourse.creerUneListe(listecourse);}

    /*
     * @param email
     * @return java.util.ArrayList<metier.Listecourse>
     * @author TANG
     * @date 2021/3/31 10:50
     * @description
     */
    public ArrayList<Listecourse> listecoursesUnclietn(String email){ return daoListeCourse.listecourseUnClient(email);}

    /*
     * @param id
     * @return metier.Listecourse
     * @author TANG
     * @date 2021/3/31 10:53
     * @description
     */
    public  Listecourse rechercheUneListe(String id){return  daoListeCourse.rechercheUnListecourse(id);}
    
    /* 
     * @param id
     * @return void
     * @author TANG
     * @date 2021/3/31 20:38
     * @description
     */
    public void supprimerPostList(String id){
        daoListeCourse.supprimeListCourse(id);
        daoPostIt.supprime(id);
    }
}
