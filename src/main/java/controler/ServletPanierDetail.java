package controler;/*
 *@program GenTech
 *@author SI Lu
 *@date 28/03/2021
 */

import metier.*;
import service.ServiceClient;
import service.ServiceCommandeDetail;
import service.ServiceCreneau;
import service.ServicePanier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/ServletPanierDetail")
public class ServletPanierDetail extends HttpServlet {
    private ServicePanier servicePanier=new ServicePanier();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        //String emailClient = (String) session.getAttribute("email");
        String emailClient="bugubugu@gamil.com";

        Client client=new ServiceClient().unClient(emailClient);
        req.setAttribute("client",client);

        Magasin magasin=servicePanier.unMagasin(client.getIdMagasin());
        req.setAttribute("magasin",magasin);

        ArrayList<Creneau> listcre=new ServiceCreneau().allCreneau();
        req.setAttribute("listcreneau",listcre);

        HashMap<Produit,Integer> listProduitPanier = servicePanier.listPanierUnClient(emailClient);
        req.setAttribute("listProduitPanier",listProduitPanier);

        HashMap<Produit, Promotion> listProduitPromo = servicePanier.produitPrixPromo();
        req.setAttribute("listProduitPromo",listProduitPromo);




        req.getRequestDispatcher("pagePainier.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}