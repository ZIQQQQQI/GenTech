package controler.ListCourse;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/30
 */

import Outil.DateString;
import metier.Listecourse;
import metier.Postit;
import service.ServiceListeCourse;
import service.ServicePostit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/ServletCreerList")
public class ServletCreerList extends HttpServlet {
    /*
     * @param req
    	 * @param resp
     * @return void
     * @author TANG
     * @date 2021/4/1 22:44
     * @description creer une list course
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String email=(String) session.getAttribute("email");
        String nom=(String) req.getParameter("nom");
        //creer un listecourse
        String id=req.getParameter("id");
        Listecourse listecourse=new Listecourse();
        listecourse.setIdListe(id);
        listecourse.setDatecree(DateString.dateString());
        listecourse.setLibelleListe(nom);
        listecourse.setEmailClient(email);
        ServiceListeCourse serviceListeCourse=new ServiceListeCourse();
        serviceListeCourse.creerListeCourse(listecourse);

        ServicePostit servicePostit=new ServicePostit();
        // creer post it pour listecourse
        for(int i=1;i<6;i++){

            String post=req.getParameter("num"+i);
            if(post.length()>0){
                Postit postit=new Postit();
                postit.setLibellePost(post);
                postit.setIdListe(id);
                postit.setQuantite(0);
                servicePostit.creerPost(postit);

            }


        }
        req.getRequestDispatcher("ServletCompteProfil").forward(req, resp);
       

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
