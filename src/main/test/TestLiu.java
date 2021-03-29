import dao.DaoCommandeproduit;
import dao.DaoCreneau;
import dao.DaoStock;
import metier.*;
import org.junit.Test;
import service.ServiceCreneau;
import service.ServiceRayon;
import service.ServiceStock;

import java.util.ArrayList;
import java.util.HashMap;

public class TestLiu {
    @Test
 public void test(){

      DaoStock ds = new DaoStock();
//        for (Ligneachat la:ds.achatproduitdeja(1,"eiru0782",3)
//       ) {
//           System.out.println(la);
//        }

//        for (Entrepot e : ds.achatdejaDate(3))
//        {
//           System.out.println(e);
//        }

//        ServiceStock sr = new ServiceStock();
//        HashMap<Produit,HashMap<Entrepot,Ligneachat>> ligneachatfu=sr.allligneachahtnow(1);
//
//        for (Produit p :ligneachatfu.keySet()){
//            HashMap<Entrepot,Ligneachat> h= ligneachatfu.get(p);
//            System.out.println(p);
//            for (Entrepot e:h.keySet()
//            ) {
//                Entrepot enree=e;
//                System.out.println(enree.getIdCdeAchat());
//                Ligneachat enrl=h.get(e);
//                System.out.println(enrl.getIdProduit());
//            }

//     ArrayList<Ligneachat> lign = null;
//        lign=ds.ligneachatsProduit(4);
//        for (Ligneachat la:lign)
//        {
//            System.out.println(la);
//        }


//
//        ArrayList<HashMap<Ligneachat, Entrepot>> ll=ds.listCommLigne(lign);
//        System.out.println(ll);

//        ServiceStock sr = new ServiceStock();
//        ArrayList<Ligneachat> lignqq = sr.listdeja(4);
//        ArrayList<HashMap<Ligneachat, Entrepot>> h = sr.listCommLigne(lignqq);
//        System.out.println(h);


        ds.ajouterCommande("abcd1111","09/04/2021","21/04/2021","MD0001");
       }






}
