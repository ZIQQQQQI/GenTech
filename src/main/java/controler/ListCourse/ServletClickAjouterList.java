package controler.ListCourse;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/30
 */

import Outil.RandomString;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/ServletClickAjouterList")
public class ServletClickAjouterList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         String id=new RandomString().getRandomString(12);
         req.setAttribute("id",id);
        req.getRequestDispatcher("/pageListeCourses.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req,resp);
    }
}
