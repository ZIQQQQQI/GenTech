package controler;/*
 *@program GenTech3
 *@author LIU Yue
 *@date 28-03-21
 */

import metier.Creneau;
import metier.Entrepot;
import metier.Ligneachat;
import metier.Rayon;
import service.ServiceCreneau;
import service.ServiceRayon;
import service.ServiceStock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
       HttpSession session = req.getSession();
       resp.setContentType("application/xml;charset=UTF-8");
       resp.setCharacterEncoding("UTF-8");
       try {
           ServiceStock sc = new ServiceStock();

           //Integer idcate = Integer.valueOf(req.getParameter("idproduit"));

           ServiceStock st = new ServiceStock();
           ArrayList<Ligneachat> lignqq = st.listdeja(4);
           ArrayList<HashMap<Ligneachat, Entrepot>> h = st.listCommLigne(lignqq);

           ArrayList<Ligneachat> lignff = st.ligneachatsfuture(4);
           ArrayList<HashMap<Ligneachat, Entrepot>> f =st.listCommLigne(lignff);

           req.setAttribute("listcommande",lignqq);
           req.setAttribute("listmap",h);
           req.setAttribute("listfuture",lignff);
           req.setAttribute("listmapfuture",f);



           req.getRequestDispatcher("/afficherCommande.jsp").forward(req, resp);
       } catch (Exception ex) {
           System.out.println("Erreur - " + ex.getMessage());
       }


   }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws javax.servlet.ServletException, IOException {
        this.doPost(req,resp);
    }



}
