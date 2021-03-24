package controler;/*
 *@program GenTech
 *@author SI Lu
 *@date 23/03/2021
 */

import metier.Rayon;
import service.ServiceRayon;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ServletRayon extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Rayon> listRayon = new ServiceRayon().allRayon();
        req.setAttribute("listRayon",listRayon);
        req.getRequestDispatcher("/iframe.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}