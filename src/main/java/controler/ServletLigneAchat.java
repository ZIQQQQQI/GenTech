package controler;
/*
 *@param null
 *@return 
 *@author Tu 
 *@description  
 *@exception
 *@date 30/03/2021 20:27
*/

import service.ServiceCommandeAchat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ServletLigneAchat")
public class ServletLigneAchat extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        try {
            ServiceCommandeAchat sc = new ServiceCommandeAchat();

            String idCdeachatA = (String) req.getParameter("formidCdeAchatA");
            Integer codeProduit = Integer.valueOf(req.getParameter("formidProduit"));
            Long qteAchat = Long.valueOf(req.getParameter("formqteAchat"));
            Long qteReste = Long.valueOf(req.getParameter("formqteReste"));

            sc.addLigneAchat(idCdeachatA, codeProduit, qteAchat, qteReste);
            session.setAttribute("LinMsg","Ajouter succes! Id Commande Achat: "+idCdeachatA+" idProduit: "+codeProduit+"ajouté");
            resp.sendRedirect("/GenTech/pagePreparaeur.jsp");

        } catch (Exception ex) {
            System.out.println("Erreur - " + ex.getMessage());
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

}