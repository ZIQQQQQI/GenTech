package controler;

import metier.Client;
import metier.Magasin;
import metier.Produit;
import metier.Rayon;
import service.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.SoundbankResource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
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
        HttpSession session=request.getSession();

        //-----------verifier si deja connecter
        try{
            String email=(String) session.getAttribute("email");
            ArrayList<Produit> listPre=new ServiceProduit().listProduitPrefre(email);
            Client client=new ServiceClient().unClient(email);
            request.setAttribute("client",client);
            Collections.shuffle(listPre);
            request.setAttribute("listPre",listPre);
        }catch (Exception e){
            System.out.println("=============");
            System.out.println("session not ok servletAccueil");
            System.out.println("=============");
        }

        //----------------mot cle recherche
        String motCle=null;
        try{
            motCle=(String)request.getParameter("keyword");
            Enumeration<String> r= request.getAttributeNames();
            while (r.hasMoreElements()){
                System.out.println(r.nextElement());
            }
        }catch (Exception e){
            System.out.println("=============");
            System.out.println("mot cle not ok");
            System.out.println("=============");
        }


        //----------magasin list
        ArrayList<Magasin> listM=new ServiceMagasin().listMagasin();
        request.setAttribute("listMagasin",listM);

        //----------------produit list


                //produit list categorie
        Integer idCategorie= null;
        try {
            idCategorie = Integer.valueOf(request.getParameter("idCategorie"));
        } catch (Exception e){
//            System.out.println("=============");
//            System.out.println("idCategorie pas ok");
//            System.out.println("=============");
        }
                //produit list ordre
        String ordre= null;
        try{
            ordre= request.getParameter("ordre");
        }catch (Exception e){
            System.out.println("=============");
            System.out.println("ordre pas ok");
            System.out.println("=============");
        }

        //------------list init
        ArrayList<Produit> list=null;
        if(motCle!=null){
            list=new ServiceRechercher().findProduitByWord(motCle);

        }
        else if (idCategorie==null & ordre==null){
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
        //-------mot cle
        request.setAttribute("motCle",motCle);

        //------------------dispatcher
        request.getRequestDispatcher("/iframe.jsp?&math="+Math.random()).forward(request, response);
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
