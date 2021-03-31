package controler;/*
 *@program GenTech3
 *@author LIU Yue
 *@date 28-03-21
 */

import metier.Creneau;
import metier.Entrepot;
import metier.Ligneachat;
import metier.Rayon;
import service.ServiceProduit;
import service.ServiceRayon;
import service.ServiceStock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       HttpSession session = req.getSession();
       resp.setContentType("application/xml;charset=UTF-8");
       resp.setCharacterEncoding("UTF-8");
       try (PrintWriter out = resp.getWriter()){
           out.println("<?xml version=\"1.0\"?>");
           out.println("<liste_stock>");

           String nomP = req.getParameter("nomProduit");
           ServiceProduit sp = new ServiceProduit();
           Integer idP = sp.idProduit(nomP);


           ServiceStock st = new ServiceStock();
           //ArrayList<Ligneachat> lignqq = st.listdeja(idP);
           //ArrayList<HashMap<Ligneachat, Entrepot>> h = st.listCommLigne(lignqq);

           ArrayList<Ligneachat> lignff = st.ligneachatsfuture(idP);
           ArrayList<HashMap<Ligneachat, Entrepot>> f = st.listCommLigne(lignff);

           //req.setAttribute("listcommande",lignqq);
           // req.setAttribute("listmap",h);
           //req.setAttribute("listfuture",lignff);
           //req.setAttribute("listmapfuture",f);
           Integer count=0;
           for (HashMap<Ligneachat, Entrepot> r1 : f) {
               for (Ligneachat key1 : r1.keySet()) {
                   count = count+key1.getQteReste().intValue();

                   out.println("<produitid>"+key1.getIdProduit()+"</produitid>" +
                           "<qteachat>"+key1.getQteAchat()+"</qteachat>" +
                           "<date>"+r1.get(key1).getDateCdeArrive()+"</date>" +
                           "<reste>"+key1.getQteReste()+"</reste>" +
                           "<restetotal>"+count+"</restetotal>");
//                   System.out.println("-----------------------");
//                   System.out.println(key1.getIdProduit());
//                   System.out.println(key1.getQteAchat());
//                   System.out.println(r1.get(key1).getDateCdeArrive());
//                   System.out.println(key1.getQteReste());
//                   System.out.println(count);
               }


           }
           out.println("</liste_stock>");
       }
   }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }



}
