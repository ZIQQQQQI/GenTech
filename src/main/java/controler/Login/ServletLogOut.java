package controler.Login;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/28
 */

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/ServletLogOut")
public class ServletLogOut extends HttpServlet {
    /*
     * @param req
    	 * @param resp
     * @return void
     * @author TANG
     * @date 2021/4/1 22:46
     * @description log out clear session
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        session.invalidate();
        req.getRequestDispatcher("ServletAccueil").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doGet(req,resp);
    }
}
