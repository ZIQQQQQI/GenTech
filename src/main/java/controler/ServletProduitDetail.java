package controler;/*
 *@program GenTech
 *@author ziqi tang
 *@date 2021/3/23
 */

import metier.Magasin;
import metier.Produit;
import metier.Rayon;
import service.ServiceMagasin;
import service.ServiceProduit;
import service.ServiceRayon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

@WebServlet("/ServletProduitDetail")
public class ServletProduitDetail extends HttpServlet {

    /*
     * @param req
	 * @param resp
     * @return void
     * @author TANG
     * @date 2021/3/25 11:18
     * @description
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //produits promo
        ArrayList<Produit> listPromo=new ServiceProduit().listProduisPromo();
        req.setAttribute("listPromo",listPromo);

        //----------magasin list
        ArrayList<Magasin> listM=new ServiceMagasin().listMagasin();
        req.setAttribute("listMagasin",listM);

        //----------------rayon list
        HashMap<Rayon,ArrayList<Rayon>> listRayonEtCategories = new ServiceRayon().allRayonAndCategories();
        req.setAttribute("listRayonandcategories",listRayonEtCategories);
        Integer idProduit=Integer.valueOf(req.getParameter("idProduit")) ;
        Produit un=new ServiceProduit().unProduit(idProduit);
        req.setAttribute("unProduit",un);
        req.getRequestDispatcher("/iframeDetail.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
