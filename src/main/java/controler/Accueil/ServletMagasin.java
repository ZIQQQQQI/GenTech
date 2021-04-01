package controler.Accueil;/*
 *@program GenTech11
 *@author ziqi tang
 *@date 25/03/2021
 */

import dao.DaoClient;
import metier.Magasin;
import metier.Produit;
import metier.Rayon;
import service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/ServletMagasin")
public class ServletMagasin extends HttpServlet {

    /*
     * @param req
     * @param resp
     * @return void
     * @author TANG
     * @date 2021/3/25 11:18
     * @description
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //----------magasin list
        HttpSession session=req.getSession();
        resp.setContentType("application/xml;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        try (PrintWriter out = resp.getWriter())
        {
            /*----- Ecriture de la page XML -----*/
            out.println("<?xml version=\"1.0\"?>");


            String a = req.getParameter("nomMagasin");
            String e=(String) session.getAttribute("email");
            //System.out.println(a);
            //System.out.println(e);
            ServiceMagasin sm = new ServiceMagasin();

            try{
                String ma = sm.maga(a).getIdMagasin();
                //out.println("<mag>"+ma+"<mag>");
                //System.out.println("--------------");
                //System.out.println(ma);
                new ServiceClient().updateCli(e,ma);

            }catch(Exception ex){
                out.println("Erreur - " + ex.getMessage() );
            }

        }




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}