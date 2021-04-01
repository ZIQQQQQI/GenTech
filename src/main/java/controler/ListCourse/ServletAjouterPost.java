package controler.ListCourse;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/31
 */

import metier.Postit;
import service.ServicePostit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletAjouterPost")
public class ServletAjouterPost extends HttpServlet {
    /*
     * @param req
    * @param resp
     * @return void
     * @author TANG
     * @date 2021/4/1 22:43
     * @description ajouter un postit dans un listecourse exist
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String post=req.getParameter("post");
        String id=req.getParameter("listC");
        ServicePostit servicePostit=new ServicePostit();
        Postit postit=new Postit();
        postit.setLibellePost(post);
        postit.setIdListe(id);
        postit.setQuantite(0);
        servicePostit.creerPost(postit);
        req.getRequestDispatcher("ServletListeCourseDetail?id="+id).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
