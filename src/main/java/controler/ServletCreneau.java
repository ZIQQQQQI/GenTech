package controler;/*
 *@program GenTech3
 *@author LIU Yue
 *@date 28-03-21
 */

import service.ServiceCreneau;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ServletCreneau")
public class ServletCreneau extends HttpServlet {

    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
            //----------creneau list
            HttpSession session = req.getSession();
            resp.setContentType("application/xml;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");

            try{
                ServiceCreneau sc = new ServiceCreneau();
                //String idcommande=(String) session.getAttribute("idCommande");
                String idC = (String)req.getParameter("idCreneau");
                System.out.println(idC);
                //mettre à jour le commande choisi
                sc.UpdateCreneau(idC,"affd2356");
                System.out.println("ok");
                req.getRequestDispatcher("ServletAccueil").forward(req, resp);

            }catch(Exception ex){
                System.out.println("Erreur - " + ex.getMessage() );
            }
        }
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doPost(req, resp);
        }
}
