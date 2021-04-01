package controler.ListCourse;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/31
 */

import metier.Postit;
import metier.Produit;
import service.ServiceListeCourse;
import service.ServicePanier;
import service.ServicePostit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/ServletAjouterPanier")
public class ServletAjouterPanier extends HttpServlet {
    /*
     * @param req
    	 * @param resp
     * @return void
     * @author TANG
     * @date 2021/4/1 22:42
     * @description ajouter liste course au panier et la supprimer
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //email
        HttpSession session=req.getSession();
        String email=(String) session.getAttribute("email");
        //liste id
        String id=req.getParameter("id");
        ServiceListeCourse serviceListeCourse=new ServiceListeCourse();
        ServicePanier servicePanier=new ServicePanier();
        ServicePostit servicePostit=new ServicePostit();
        HashMap<Produit,Integer> h=servicePanier.listPanierUnClient(email);
        ArrayList<Integer> produitPanie=new ArrayList<>();
        HashMap<Integer,Integer> panierClient=servicePanier.listPanierUnClientCode(email);
        for (Produit p:h.keySet()
             ) {
            produitPanie.add(p.getCodeProduit());
        }
        //liste post au panier
        ArrayList<Postit> listp=servicePostit.listPostListCourse(id);
        for (Postit p:listp
             ) {
            if(panierClient.keySet().contains(p.getIdProduit())){
                Integer qte=panierClient.get(p.getIdProduit())+p.getQuantite();
                servicePanier.modifierPanier(email,qte.longValue(),p.getIdProduit());

            }
           else if(p.getQuantite()>0){

                servicePanier.ajouterAvecQte(email,p.getIdProduit(),p.getQuantite());
            }

        }
        serviceListeCourse.supprimerPostList(id);
        req.getRequestDispatcher("ServletPanierDetail").forward(req, resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
