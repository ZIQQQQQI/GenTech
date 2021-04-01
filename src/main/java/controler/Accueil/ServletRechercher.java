package controler.Accueil;
/*
 *@param null
 *@return
 *@author Tu
 *@description servlet pour rechercher un produit par mot-cle
 *@exception
 *@date 25/03/2021 09:04
*/


import dao.DaoProduit;
import metier.Produit;
import service.ServiceRechercher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.ArrayList;
@WebServlet("/ServletRechercher")
public class ServletRechercher extends HttpServlet {
    /*
     * @param request
    	 * @param response
     * @return void
     * @author TANG
     * @date 2021/4/1 22:14
     * @description recherche dan page d'accuiel
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            /*----- Ecriture de la page XML -----*/
            out.println("<?xml version=\"1.0\"?>");
            out.println("<liste_Produit>");

            String a = request.getParameter("keyword");
            //System.out.println(a);
            ServiceRechercher sr = new ServiceRechercher();

            try{


                for(Produit p:sr.findProduitByWord(a)){

                    out.println("<nomp><![CDATA[" + p.getLibelleProduit() + "]]></nomp>");
                }

            }catch(Exception ex){
                out.println("<nomp>Erreur - " + ex.getMessage() + "</nomp>");
            }
            out.println("</liste_Produit>");
        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

}