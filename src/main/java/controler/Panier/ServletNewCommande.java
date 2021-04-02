package controler.Panier;/*
 *@program GenTech3
 *@author LIU Yue
 *@date 29-03-21
 */

import service.ServiceCommandeAchat;
import service.ServiceStock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/ServletNewCommande")
public class ServletNewCommande extends HttpServlet {
    //Creer une commande achat pour preparateur
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        try {
            ServiceCommandeAchat sc = new ServiceCommandeAchat();
            String idCdeachat = (String) req.getParameter("formidCdeAchat");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

            String dateCdeAchat = df.format(sdf.parse((String)req.getParameter("formdateCdeAchat")));
            String dateCdeArrive = df.format(sdf.parse((String)req.getParameter("formdateCdeArrive")));

            String etatCdeArrive = (String) req.getParameter("formetatCdeArrive");
            String idMagasin = (String) req.getParameter("formidMagasin");

            System.out.println(idCdeachat+dateCdeAchat+dateCdeArrive+etatCdeArrive+idMagasin);

            ServiceStock ss = new ServiceStock();
            if(ss.listEntrepot().contains(idCdeachat)){

                session.setAttribute("Msg","ce commande existe deja!");
                resp.sendRedirect("/GenTech/pagePreparaeur.jsp");
            }else{
                sc.ajouterCommande(idCdeachat, dateCdeAchat, dateCdeArrive, etatCdeArrive,idMagasin);
                session.setAttribute("Msg","Ajouter succes! IdCdeachat: "+idCdeachat+" ajouté");
                resp.sendRedirect("/GenTech/pagePreparaeur.jsp");
            }

        } catch (Exception ex) {
            System.out.println("Erreur - " + ex.getMessage());
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}