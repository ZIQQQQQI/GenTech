package controler;/*
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

@WebServlet("/ServletNewCommande")
public class ServletNewCommande extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        resp.setContentType("application/xml;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        try {
            ServiceCommandeAchat sc = new ServiceCommandeAchat();
            String idCdeachat = (String) req.getParameter("idCdeachat");
            String dateCdeAchat = (String) req.getParameter("dateCdeAchat");
            String dateCdeArrive = (String) req.getParameter("dateCdeArrive");
            String idMagasin = (String) req.getParameter("dateCdeArrive");

            sc.ajouterCommande(idCdeachat, dateCdeAchat, dateCdeArrive, idMagasin);

            String idCdeachatA = (String) req.getParameter("idCdeachatA");
            Integer codeProduit = Integer.valueOf(req.getParameter("codeProduit"));
            Long qteAchat = Long.valueOf(req.getParameter("qteAchat"));
            Long qteReste = Long.valueOf(req.getParameter("qteAchat"));
            sc.addLigneAchat(idCdeachatA, codeProduit, qteAchat, qteReste);

        } catch (Exception ex) {
            System.out.println("Erreur - " + ex.getMessage());
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}