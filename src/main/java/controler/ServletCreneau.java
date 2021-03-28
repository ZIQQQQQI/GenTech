package controler;/*
 *@program GenTech3
 *@author LIU Yue
 *@date 28-03-21
 */

import metier.Client;
import metier.Creneau;
import metier.Produit;
import service.ServiceClient;
import service.ServiceCreneau;
import service.ServiceProduit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
/*
 *@param null
 *@return
 *@author LIU
 *@date 28-03-21 13:38
*/
@WebServlet("/ServletCreneau")
public class ServletCreneau {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //----------creneau list
        HttpSession session = req.getSession();
        resp.setContentType("application/xml;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        try{
            ServiceCreneau sc = new ServiceCreneau();
            String idcommande="affd2356";
           //String idcommande=(String) session.getAttribute("idCommande");
            String idCreaneau = (String)session.getAttribute("idCreneau");
            //mettre à jour le commande choisi
            sc.UpdateCreneau(idcommande,idCreaneau);
            req.getRequestDispatcher("afficherCommande.jsp").forward(req, resp);
        }catch(Exception ex){
            System.out.println("Erreur - " + ex.getMessage() );
        }
    }
}
