package controler;/*
 *@program GenTech3
 *@author LIU Yue
 *@date 24-03-21
 */



import metier.Produit;
import metier.Rayon;
import service.ServiceProduit;
import service.ServiceRayon;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
/*
 *@param null
 *@return 
 *@author LIU
 *@date 24-03-21 20:49
*/
@WebServlet("/ServletPrix")
public class ServletPrix extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws javax.servlet.ServletException, IOException, IOException, IOException {
        String c = request.getParameter("ordre");
        if (c.equals("asc"))
        {
            ArrayList<Produit> list = new ServiceProduit().listProduit("asc");
            request.setAttribute("ListPrix", list);
            request.getRequestDispatcher("/afficherPrix.jsp").forward(request, response);}
        else{ 
            ArrayList<Produit> list = new ServiceProduit().listProduit("desc");
            request.setAttribute("ListPrix", list);
            request.getRequestDispatcher("/afficherPrix.jsp").forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }
}