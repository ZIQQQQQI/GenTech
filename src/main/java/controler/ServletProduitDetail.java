package controler;/*
 *@program GenTech
 *@author ziqi tang
 *@date 2021/3/23
 */

import metier.Produit;
import service.ServiceProduit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/ServletProduitDetail")
public class ServletProduitDetail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer idProduit=Integer.valueOf(req.getParameter("idProduit")) ;
        Produit un=new ServiceProduit().unProduit(idProduit);
        req.setAttribute("unProduit",un);
        req.getRequestDispatcher("/iframeDetail.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
