package service;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/31
 */

import dao.DaoPostIt;
import dao.DaoProduit;
import metier.Postit;
import metier.Produit;

import java.util.ArrayList;
import java.util.HashMap;

public class ServicePostit {
    DaoPostIt daoPostIt=new DaoPostIt();
    DaoProduit daoProduit=new DaoProduit();

    /*
     * @param postit
     * @return void
     * @author TANG
     * @date 2021/3/31 8:49
     * @description
     */
    public  void creerPost(Postit postit){daoPostIt.creerUnPostit(postit);};

    /*
     * @param id
     * @return java.util.ArrayList<metier.Postit>
     * @author TANG
     * @date 2021/3/31 11:01
     * @description
     */
    public ArrayList<Postit> listPostListCourse(String id){return daoPostIt.listPostListeCourse(id);}

    /*
     * @param listP
     * @return java.util.HashMap<metier.Postit,java.util.ArrayList<metier.Produit>>
     * @author TANG
     * @date 2021/3/31 13:13
     * @description reche
     */
    public HashMap<Postit,ArrayList<Produit>> positProduitRecommande(ArrayList<Postit>  listP){
        HashMap<Postit,ArrayList<Produit>> res=new HashMap<>();
        for (Postit p:listP
             ) {
            ArrayList<Produit> list=daoProduit.listProduitMotCle(p.getLibellePost());
            res.put(p,list);
        }
        return res;
    }
    /*
     * @param idPost
     * @param idProduit
     * @param quantite
     * @return void
     * @author TANG
     * @date 2021/3/31 14:47
     * @description
     */
    public  void updatePost(Integer idPost,Integer idProduit,Integer quantite){daoPostIt.updatePost(idPost,idProduit,quantite);}
}
