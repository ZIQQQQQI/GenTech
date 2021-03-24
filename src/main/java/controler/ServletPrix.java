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

@WebServlet("/ServletPrix")
public class ServletPrix extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws javax.servlet.ServletException, IOException, IOException, IOException {
        ArrayList<Produit> list = new ServiceProduit().listProduit("asc");
        request.setAttribute("ListPrix", list);
        ArrayList<Rayon> listRayon = new ServiceRayon().allRayon();
        request.setAttribute("listRayon", listRayon);
        request.getRequestDispatcher("/iframe.jsp").forward(request, response);

    }
    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }}