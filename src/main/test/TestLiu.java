import dao.DaoCommandeproduit;
import dao.DaoCreneau;
import dao.DaoStock;
import metier.*;
import org.junit.Test;
import service.ServiceCreneau;
import service.ServiceStock;

public class TestLiu {
    @Test
 public void test()

    {
        DaoCommandeproduit dr = new DaoCommandeproduit();
        String email = "bugubugu@gamil.com";
        String idcde = "affd2356";


       /* for (Produit l:dr.commandeProduit(idcde)
        ) {
            System.out.println(l);
        }

    for (Produit q:dr.produitPlusCom(email)
        ) {
            System.out.println(q);

    }*/
        DaoCreneau dc = new DaoCreneau();
       /* for (Creneau c:dc.listCreneau()) {
            System.out.println(c);
        }*/
       Commande c = new Commande();
       //c.setHeureRetrait("1");
        //dc.updateCreaneau( "3", "affd2356");
      // ServiceCreneau sc = new ServiceCreneau();
       //sc.UpdateCreneau("4","affd2356");


       //dc.supprimerPre("yufei@gamil.com",2);

        DaoStock ds = new DaoStock();

//      for (Ligneachat la:ds.achatFurure(1)
//        ) {
//            System.out.println(la);
//
//        }

      ServiceStock st = new ServiceStock();


      st.listfuture(1);
        for (Ligneachat la:st.listfuture(1)
        ) {
            System.out.println(la);
        }
} }
