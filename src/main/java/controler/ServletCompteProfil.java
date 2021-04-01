package controler;/*
 *@program GenTech
 *@author SI Lu
 *@date 24/03/2021
 */

import metier.Commande;
import metier.Listecourse;
import metier.Produit;
import metier.Rayon;
import service.ServiceCompte;
import service.ServiceListeCourse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/ServletCompteProfil")
public class ServletCompteProfil extends HttpServlet {
    private ServiceCompte serviceCompte = new ServiceCompte();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*
        *Rechercher les commande en cours ou Termine
        */
        //String emailClient=req.getParameter("emailClient");
        HttpSession session=req.getSession();
        String emailClient = (String) session.getAttribute("email");
        HashMap<Commande,String> commandeEnCours=serviceCompte.listCommandeEnCoursOuTermine(emailClient,"encours");

        HashMap<Commande,String> commandeTermine=serviceCompte.listCommandeEnCoursOuTermine(emailClient,"Termine");
        req.setAttribute("listEnCours",commandeEnCours);
        req.setAttribute("listTermine",commandeTermine);

        //recherch les liste course
        ArrayList<Listecourse> listecourses=new ServiceListeCourse().listecoursesUnclietn(emailClient);
        req.setAttribute("listeCourse",listecourses);


        /*
        Rechercher les Rayons prefere
        */
        ArrayList<Rayon> listRayonPrefer=serviceCompte.listeRayonPrefere(emailClient);
        req.setAttribute("listRayonPrefer",listRayonPrefer);

        /*
        * Rechercher Top 5 Produit
        */
        ArrayList<Produit> listProduitPrefere= serviceCompte.listProduitPrefere(emailClient);
        req.setAttribute("listProduitPrefere",listProduitPrefere);

        /*
        *Rechercher Top 5 Marque
         */
        ArrayList<String> listMarques=serviceCompte.listMarquePrefere(emailClient);
        req.setAttribute("listMarques",listMarques);

        /*
        *Rechercher poucentage de bio
         */
        String pourcentage=serviceCompte.poucentageBio(emailClient);
        req.setAttribute("pourcentage",pourcentage);

        /*
         *Rechercher la repartition de nutri Score
        */
        String repartition=serviceCompte.repartitionNutriScore(emailClient);
        req.setAttribute("repartition",repartition);

        req.getRequestDispatcher("pageCommande.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}