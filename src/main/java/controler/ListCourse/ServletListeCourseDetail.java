package controler.ListCourse;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/31
 */

import metier.Listecourse;
import metier.Postit;
import metier.Produit;
import service.ServiceListeCourse;
import service.ServicePostit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/ServletListeCourseDetail")
public class ServletListeCourseDetail extends HttpServlet {
    /*
     * @param req
    	 * @param resp
     * @return void
     * @author TANG
     * @date 2021/4/1 22:44
     * @description consulter une listeCourse existant
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idListe=req.getParameter("id");
        //obtenir listeCourse
        Listecourse listecourse=new ServiceListeCourse().rechercheUneListe(idListe);
        req.setAttribute("listC",listecourse);
        //obtenir les post
        ArrayList<Postit> listP=new ServicePostit().listPostListCourse(idListe);
        req.setAttribute("listP",listP);
        //obtenir les recommande
        HashMap<Postit,ArrayList<Produit>> listOption=new ServicePostit().positProduitRecommande(listP);
        req.setAttribute("listOption",listOption);

        req.getRequestDispatcher("/pageListeC.jsp").forward(req, resp);





    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
