package controler;/*
 *@program GenTech3
 *@author LIU Yue
 *@date 28-03-21
 */

import metier.Creneau;
import service.ServiceCreneau;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class ServletListCreneau {

        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //----------creneau list
            HttpSession session = req.getSession();
            resp.setContentType("application/xml;charset=UTF-8");
            resp.setCharacterEncoding("UTF-8");
            try{
                ServiceCreneau sc = new ServiceCreneau();
                ArrayList<Creneau> listcre=sc.allCreneau();
            }catch(Exception ex){
                System.out.println("Erreur - " + ex.getMessage() );
            }
        }}


