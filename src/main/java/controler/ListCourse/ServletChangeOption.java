package controler.ListCourse;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/31
 */

import controler.ServletCompteProfil;
import metier.Postit;
import service.ServicePostit;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ServletChangeOption")
public class ServletChangeOption extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
        ServicePostit postit=new ServicePostit();
        //size post
        Integer size=Integer.valueOf(req.getParameter("size")) ;
        //idL
        String idL=req.getParameter("idL");
        //listPost
        ArrayList<Postit> listP=new ServicePostit().listPostListCourse(idL);
        for (Postit p:listP
             ) {
            Integer idProduit=Integer.valueOf( req.getParameter(String.valueOf(p.getIdPost())));
            Integer qte=Integer.valueOf( req.getParameter("qte"+p.getIdPost()));
            postit.updatePost(p.getIdPost(),idProduit,qte);
        }
        req.getRequestDispatcher("ServletListeCourseDetail?id="+idL).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
