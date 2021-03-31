package controler;
/*
 *@param null
 *@return 
 *@author Tu 
 *@description  
 *@exception
 *@date 31/03/2021 09:45
*/

import metier.Produit;
import metier.Rayon;
import service.ServiceRayon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletRayon")
public class ServletRayon extends HttpServlet {
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        /*----- Type de la réponse -----*/
        response.setContentType("application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter())
        {
            out.println("<?xml version=\"1.0\"?>");
            out.println("<liste_rayon>");
            ServiceRayon sr = new ServiceRayon();
            //sr.allRayons();

            for(Rayon r:sr.allRayons()){
                out.println("<cat>" + r.getNomCate() + "</cat><idCat>"+r.getNumCate()+"</idCat>");
            }

            out.println("</liste_rayon>");

        }
    }

    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { doGet(request, response); }

}