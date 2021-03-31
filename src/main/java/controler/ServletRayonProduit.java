package controler;/*
 *@program GenTech6
 *@author ziqi tang
 *@date 29/03/2021
 */

import metier.Entrepot;
import metier.Ligneachat;
import metier.Produit;
import metier.Rayon;
import service.ServiceRayon;
import service.ServiceStock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;


@WebServlet("/ServletRayonProduit")
public class ServletRayonProduit extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        /*----- Type de la réponse -----*/
        response.setContentType("application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String nomRayon = request.getParameter("nomRayon");
        ServiceRayon sr = new ServiceRayon();

        Integer idRayon = Integer.valueOf(sr.nomRayon(nomRayon));


        try (PrintWriter out = response.getWriter())
        {
            out.println("<?xml version=\"1.0\"?>");
            out.println("<liste_rayon_Produit>");

            try {
                for (Produit pro : sr.allRayonsProduit(idRayon)) {
                    out.println("<prod><![CDATA[" + pro.getLibelleProduit() + "]]></prod><idProd>"+pro.getCodeProduit()+"</idProd>");
                    //System.out.println(pro.getCodeProduit());

                }

            }catch(Exception ex){
                out.println("<prod>Erreur - " + ex.getMessage() + "</prod>");
            }

            out.println("</liste_rayon_Produit>");

        }
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { doGet(request, response); }

}