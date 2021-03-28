package controler;/*
 *@program GenTech2
 *@author ziqi tang
 *@date 25/03/2021
 */

import metier.Client;
import service.ServiceClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/ServletLoginRechercher")
public class ServletLoginRechercher extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String email1 = request.getParameter("email");
        ServiceClient sc = new ServiceClient();
        ArrayList<String> le = new ArrayList<>();
        for(Client c:sc.allClient()){
            le.add(c.getEmailClient());
        }

        try {
            if(le.contains(email1)){

                response.getWriter().print("Ce compte existe");
            }else{
                response.getWriter().print("Ce compte n'existe pas");
            }
        } catch (Exception ex) {
            Logger.getLogger(ServletRechercher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}