package controler;/*
 *@program GenTech6
 *@author ziqi tang
 *@date 01/04/2021
 */

import service.ServicePanier;
import service.ServicePreference;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ServletPreAjouterDetail")
public class ServletPreAjouterDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer idp=Integer.valueOf((String) req.getParameter("idp")) ;
        String email=(String)req.getParameter("email");
        new ServicePreference().addPreference(email,idp);

        resp.getWriter().print("success");

    }
}