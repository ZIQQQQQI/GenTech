package controler.Accueil;/*
 *@program GenTech6
 *@author ziqi tang
 *@date 29/03/2021
 */

import service.ServicePanier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/ServletSupprimerPan")
public class ServletSupprimerPan extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        String email=(String) session.getAttribute("email");
        Integer idSupPre=Integer.valueOf(request.getParameter("idSupPan"));

        ServicePanier servicePanier=new ServicePanier();
        try{
            servicePanier.supPanier(email, idSupPre);
            response.getWriter().print("supprimer succes");

        } catch (Exception ex) {
            Logger.getLogger(ServletSupprimerPre.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}