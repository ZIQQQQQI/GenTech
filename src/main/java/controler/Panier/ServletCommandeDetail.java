package controler.Panier;/*
 *@program GenTech
 *@author SI Lu
 *@date 28/03/2021
 */

import metier.*;
import service.ServiceClient;
import service.ServiceCommandeDetail;
import service.ServiceCompte;
import service.ServiceCreneau;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/ServletCommandeDetail")
public class ServletCommandeDetail extends HttpServlet {
    private ServiceCommandeDetail scd=new ServiceCommandeDetail();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String emailClient = (String) session.getAttribute("email");
        String idCde=req.getParameter("idCde");

        Client client=new ServiceClient().unClient(emailClient);
        req.setAttribute("client",client);

        Magasin magasin =scd.magasinCommande(idCde);
        req.setAttribute("magasin",magasin);

        Commande commande=scd.unCommande(idCde);
        req.setAttribute("commande",commande);

        HashMap<Produit,Integer> ligneCommande =scd.ligneCommandeDetail(idCde);
        req.setAttribute("ligneCommande",ligneCommande);

        ArrayList<Creneau> listcre=new ServiceCreneau().allCreneau();
        req.setAttribute("listcreneau",listcre);

        req.getRequestDispatcher("pageCommandeDetail.jsp").forward(req, resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}