package controler.ListCourse;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/31
 */

import service.ServiceListeCourse;
import service.ServicePostit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletSupprimerListe")
public class ServletSupprimerListe extends HttpServlet {
    /*
     * @param req
    	 * @param resp
     * @return void
     * @author TANG
     * @date 2021/4/1 22:44
     * @description supprimer une liste course dans le page compteProfil
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
         ServiceListeCourse serviceListeCourse=new ServiceListeCourse();
        serviceListeCourse.supprimerPostList(id);
        req.getRequestDispatcher("ServletCompteProfil").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
