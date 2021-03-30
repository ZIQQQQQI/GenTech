package controler;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/28
 */

import service.ServicePanier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/ServletPanier")
public class ServletPanier extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer idp=Integer.valueOf((String) req.getParameter("idp")) ;
        String email=(String)req.getParameter("email");
        new ServicePanier().ajouer(email,idp);



    }
}
