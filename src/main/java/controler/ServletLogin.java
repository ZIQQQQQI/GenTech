package controler;
/*
 *@param null
 *@return
 *@author Tu
 *@description  servlet de login
 *@exception
 *@date 25/03/2021 15:42
*/

import metier.Client;
import org.hibernate.Session;
import service.ServiceClient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ServletLogin")
public class    ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String emailC =req.getParameter("idEmail");
        String mdpC = req.getParameter("mdp");

        Client c = new ServiceClient().unClient(emailC);
        ArrayList<String> le = new ArrayList<String>();
        for(Client cli:new ServiceClient().allClient()){
            le.add(cli.getEmailClient());
        }
        try{
            if(le.contains(emailC)){
                if(c.getMdpClient().equals(mdpC)){
                    HttpSession session=req.getSession();
                    session.setAttribute("email",emailC);
                    req.getRequestDispatcher("ServletAccueil").forward(req, resp);
                }else{
                    //System.out.println("mots de passe incorrect");
                    resp.sendRedirect("/GenTech/Front-End/login.jsp");
                }
            }else{
                resp.getWriter().print("Ce compte n'existe pas");
                resp.sendRedirect("/GenTech/Front-End/login.jsp");
            }

        }catch(Exception ex){
            req.setAttribute("msg_erreur","Erreur de connexion");

        }

    }


}