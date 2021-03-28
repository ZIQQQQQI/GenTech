package controler;/*
 *@program GenTech3
 *@author LIU Yue
 *@date 28-03-21
 */

import metier.Creneau;
import service.ServiceCreneau;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ServletListCreneau")
public class ServletListCreneau extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        //----------creneau list
        HttpSession session = req.getSession();
        resp.setContentType("application/xml;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        try{
            ServiceCreneau sc = new ServiceCreneau();
            ArrayList<Creneau> listcre=sc.allCreneau();
            System.out.println(listcre);
            req.setAttribute("listcreneau",listcre);
            req.getRequestDispatcher("/afficherCommande.jsp").forward(req, resp);


        }catch(Exception ex){
            System.out.println("Erreur - " + ex.getMessage() );
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
