package controler.ListCourse;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/30
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/ServletCreerList")
public class ServletCreerList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");

        HashMap<Integer,String> post=new HashMap<>();
        for(int i=1;i<6;i++){
            String nom=req.getParameter("num"+i);
            post.put(i,nom);
        }
       

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
