package controler.Accueil;
/*
 *@param null
 *@return 
 *@author Tu 
 *@description  
 *@exception
 *@date 28/03/2021 14:48
*/

import service.ServiceClient;
import service.ServiceMagasin;
import service.ServicePreference;
import service.ServiceProduit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletPreference")
public class ServletPreference extends HttpServlet {
    /*
     * @param req
    	 * @param resp
     * @return void
     * @author TANG
     * @date 2021/4/1 22:12
     * @description add une preference pour un client
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session=req.getSession();
        String email=(String) session.getAttribute("email");
        Integer idP=Integer.valueOf(req.getParameter("idPP"));

        ServicePreference sp = new ServicePreference();
        sp.addPreference(email,idP);
        ServiceProduit spr = new ServiceProduit();

        //spr.unProduit(idP).getLibelleProduit();
        resp.getWriter().print(spr.unProduit(idP).getLibelleProduit());


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
