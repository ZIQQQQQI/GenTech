package controler;/*
 *@program GenTech6
 *@author ziqi tang
 *@date 01/04/2021
 */

import service.ServicePanier;
import service.ServicePreference;
import service.ServiceProduit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ServletPreAjouterDetail")
public class ServletPreAjouterDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    //Ajouter un produit dans la liste de preference
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer idp=Integer.valueOf((String) req.getParameter("idp")) ;
        String email=(String)req.getParameter("email");

        if(new ServiceProduit().unProduitDansPrefre(idp,new ServiceProduit().listProduitPrefre(email))){
            resp.getWriter().print("exist");

        }else {
            new ServicePreference().addPreference(email,idp);

            resp.getWriter().print("nonexist");

        }
    }
}