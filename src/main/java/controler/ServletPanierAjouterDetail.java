package controler;/*
 *@program GenTech6
 *@author ziqi tang
 *@date 31/03/2021
 */

import service.ServicePanier;
import service.ServiceProduit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/ServletPanierAjouterDetail")
public class ServletPanierAjouterDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer idp=Integer.valueOf((String) req.getParameter("idp")) ;
        String email=(String)req.getParameter("email");
        //System.out.println(idp+email);
        if(new ServiceProduit().unProduitDansPanier(idp,new ServiceProduit().listProduitPanier(email) )){
            resp.getWriter().print("exist");

        }else {
            new ServicePanier().ajouer(email,idp);

            resp.getWriter().print("nonexist");

        }


    }
}