package controler.Panier;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/4/1
 */

import service.ServicePanier;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/ServletDeletePanier")
public class ServletDeletePanier extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String email=(String)session.getAttribute("email");
        Integer id=Integer.valueOf(req.getParameter("id")) ;
        ServicePanier servicePanier=new ServicePanier();
        servicePanier.supPanier(email,id);
        resp.sendRedirect("ServletPanierDetail");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
