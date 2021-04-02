package controler.Panier;/*
 *@program GenTech
 *@author SI Lu
 *@date 30/03/2021
 */

import Outil.RandomString;
import metier.Client;
import metier.Magasin;
import metier.Produit;
import metier.Promotion;
import service.ServiceClient;
import service.ServicePanier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@WebServlet("/ServletConfirmerCommande")
public class ServletConfirmerCommande extends HttpServlet {
    private ServicePanier servicePanier=new ServicePanier();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String emailClient="bugubugu@gamil.com";
        //String emailClient = (String) session.getAttribute("email");

        Client client=new ServiceClient().unClient(emailClient);

        //recupere depuis form
        Magasin magasin=servicePanier.unMagasin(client.getIdMagasin());
        String idMagasin=magasin.getIdMagasin();

        DateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        Date date =new Date();
        String dateCommande =sdf.format(date);
        String dateRetrait=(String)req.getParameter("dateRetrait");
        String creneau=(String)req.getParameter("idCreneau");
        String avoirReduction=(req).getParameter("avoirReductionOuPas");

        //verifier stock
        ArrayList<String> note=servicePanier.verifierStock(emailClient,dateRetrait);
        req.setAttribute("note",note);

        HashMap<Produit,Integer> listProduitPanier = servicePanier.listPanierUnClient(emailClient);
        HashMap<Produit, Promotion> listpromo = servicePanier.produitPrixPromo();
        //Calculer les prix
        double eco=0.00;
        double sum=0.00;
        double sumEco=0.00;
        for (Produit p:listProduitPanier.keySet()){
            sum=sum+p.getPrix()*listProduitPanier.get(p);;
            if (listpromo.containsKey(p)){
                eco=p.getPrixVente()*listpromo.get(p).getReduction()*listProduitPanier.get(p);
                sumEco=sumEco+eco;
            }else{
                eco=0.00;
                sumEco=sumEco+eco;
            }
        }


        //verifier si le client utilise la reduction

        int updateScore=client.getScore();

        if(avoirReduction.equals("1")){
            sumEco=sumEco+5.00;

            updateScore= updateScore-10+(int) ((sum-sumEco)/10)+1;
        }else{
            updateScore=  updateScore+(int) ((sum-sumEco)/10)+1;
        }



          
        

        //Si tous les produit a des stocks

        if(note.size()==0){
            //Creer une nouvelle commande
            String idCdeCli=new RandomString().getRandomString(8);

            servicePanier.ajouterCommande(idCdeCli,dateCommande,dateRetrait,creneau,emailClient,sum,sumEco,idMagasin);

            for(Produit p:listProduitPanier.keySet()){
                servicePanier.ajouterLigneCommande(idCdeCli,p.getCodeProduit(),listProduitPanier.get(p));
            }

            //Modifier le stock
            servicePanier.modifierQteLigneAchat(emailClient,dateRetrait);

            //Supprimer les produits dans le panier
            servicePanier.supprimer(emailClient);

            //mise a jour le point fedalite
            servicePanier.updateScoreClient(emailClient,updateScore);
        }

        req.getRequestDispatcher("/pageInfo.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}