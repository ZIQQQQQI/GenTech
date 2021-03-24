package controler;

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

@WebServlet("/ServletAccueil")
public class ServletAccueil extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        ArrayList<Produit> list=new ServiceProduit().listProduit("none");
        request.setAttribute("listProduit",list);
        ArrayList<Rayon> listRayon = new ServiceRayon().allRayon();
        request.setAttribute("listRayon",listRayon);
        request.getRequestDispatcher("/iframe.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }
}
