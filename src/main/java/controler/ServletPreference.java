package controler;
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
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session=req.getSession();
        String email=(String) session.getAttribute("email");
        Integer idP=Integer.valueOf(req.getParameter("idPP"));
        System.out.println("---------------");
        System.out.println(email);
        System.out.println(idP);
        System.out.println("---------------");

        ServicePreference sp = new ServicePreference();
        sp.addPreference(email,idP);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
