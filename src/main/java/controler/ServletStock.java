package controler;/*
 *@program GenTech3
 *@author LIU Yue
 *@date 28-03-21
 */

import metier.Creneau;
import metier.Ligneachat;
import service.ServiceCreneau;
import service.ServiceStock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ServletStock")
public class ServletStock extends HttpServlet {
/*
 *@param request
	 * @param response
 *@return void
 *@author LIU
 *@date 28-03-21 23:24
*/
   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    {
        HttpSession session = req.getSession();
        resp.setContentType("application/xml;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");

        try {
            ServiceStock sc = new ServiceStock();

            Integer idcate = Integer.valueOf(req.getParameter("idcategorie"));
            ArrayList<Ligneachat> listdeja = sc.listdeja(idcate);
            System.out.println(listdeja );
            ArrayList<Ligneachat> listfuture = sc.listfuture(idcate);
            System.out.println(listfuture);
        } catch (Exception ex) {
            System.out.println("Erreur - " + ex.getMessage());
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws javax.servlet.ServletException, IOException {
        this.doPost(req,resp);
    }



}
