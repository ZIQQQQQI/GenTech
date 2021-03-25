package controler;

import metier.Magasin;
import metier.Produit;
import metier.Rayon;
import service.ServiceMagasin;
import service.ServiceProduit;
import service.ServiceRayon;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/ServletAccueil")
public class ServletAccueil extends HttpServlet {
    /*
     * @param request
	 * @param response
     * @return void
     * @author TANG
     * @date 2021/3/25 11:16
     * @description
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //----------magasin list
        ArrayList<Magasin> listM=new ServiceMagasin().listMagasin();
        request.setAttribute("listMagasin",listM);

        //----------------produit list


                //produit list categorie
        Integer idCategorie= null;
        try {
            idCategorie = Integer.valueOf(request.getParameter("idCategorie"));
        } catch (Exception e){
            e.printStackTrace();
        }
                //produit list ordre
        String ordre= request.getParameter("ordre");
        try{
            ordre= request.getParameter("ordre");
        }catch (Exception e){
            e.printStackTrace();
        }

            //------------list init
        ArrayList<Produit> list=null;
        if (idCategorie==null & ordre==null){
            list=new ServiceProduit().listProduit("none");
        }else if (idCategorie!=null & ordre==null){
            request.setAttribute("idCategorie",idCategorie);
            list= new ServiceProduit().listeRayonProduit(idCategorie);
        }else if(idCategorie==null & ordre!=null){
           list = new ServiceProduit().listProduit(ordre);
        }else if(idCategorie!=null &ordre!=null){
            request.setAttribute("idCategorie",idCategorie);
            list=new ServiceProduit().listRayonOrdrePrix(ordre,idCategorie);
        }

        request.setAttribute("listProduit",list);



        //----------------rayon list
        HashMap<Rayon,ArrayList<Rayon>> listRayonEtCategories = new ServiceRayon().allRayonAndCategories();
        request.setAttribute("listRayonandcategories",listRayonEtCategories);


        //------------------dispatcher
        request.getRequestDispatcher("/iframe.jsp?math="+Math.random()).forward(request, response);
    }
    /*
     * @param request
     * @param response
     * @return
     * @author TANG
     * @date 2021/3/25 11:16
     * @description
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }
}
