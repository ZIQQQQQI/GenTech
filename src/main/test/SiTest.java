import dao.*;
import metier.Produit;
import metier.Promotion;
import metier.Rayon;
import org.junit.Test;
import service.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class SiTest {
    @Test
    public void test(){
        //DaoPreference dp=new DaoPreference();
        //dp.ajouterPeference("test",11);
        //ArrayList<Preference> list = dp.listPrefere("bugubugu@gamil.com");
        //for (Preference p:list){
            //System.out.println(p.getCodeProduit());
        //}

        DaoProduit dp=new DaoProduit();
        //Produit p= dp.rechercheUnProduit(1);
        //System.out.println(p.getLibelleProduit());

        //ArrayList<Produit> listProduit = dp.listProduitOrdrePrix("none");

        //ArrayList<Produit> listProduit=dp.listProduitMotCle("ok");
        //for (Produit p:listProduit){
            //System.out.println(p.getLibelleProduit());
        //}
//        ServiceRayon sr=new ServiceRayon();
//        HashMap<Rayon,ArrayList<Rayon>> list=sr.allRayonAndCategories();
//        for (Rayon r:list.keySet()){
//            System.out.println("---"+r.getNomCate());
//            for (Rayon cat:list.get(r)){
//                System.out.println(cat.getNomCate());
//            }
//        }


        //System.out.println(new ServiceCommandeDetail().ligneCommandeDetail("affd2356"));
        //System.out.println(new DaoCommandeMagasin().magasinComande("affd2356"));
        //System.out.println(new ServiceCreneau().allCreneau());

        //System.out.println(new ServicePanier().listPanierUnClient("bugubugu@gamil.com"));
        //System.out.println(new DaoPanier().listPanierUnClient("bugubugu@gamil.com"));

        //System.out.println(new DaoPromotion().listEnPromo());
        //System.out.println(new DaoPromotion().listPromotion());
        //System.out.println(new ServicePanier().produitPrixPromo());
        HashMap<Produit,Integer> listProduitPanier= new ServicePanier().listPanierUnClient("bugubugu@gamil.com");
        HashMap<Produit, Promotion> listpromo=new ServicePanier().produitPrixPromo();
//        double eco=0.00;
//        for (Produit p:listProduitPanier.keySet()){
//            if (listpromo.containsKey(p)){
//                eco=p.getPrixVente()*listpromo.get(p).getReduction()*listProduitPanier.get(p);
//                System.out.println(p.getCodeProduit()+"="+eco);
//            }else{
//                eco=0.00;
//                System.out.println(p.getCodeProduit()+"="+eco);
//            }
//        }

        //new DaoPanier().supprimer("yufei@gamil.com");
        //new ServicePanier().modifierQtePanier("bugubugu@gamil.com",4,"minus","6");

//        DaoPanier daoPanier=new DaoPanier();
//        daoPanier.modifierQtePanier("bugubugu@gamil.com",15L,8);

//

        //System.out.println(new ServicePanier().verifierStock("bugubugu@gamil.com","03/04/2021"));

        //System.out.println(new DaoStock().ligneachatsProduitVerifier(6,"03/04/2021"));
        //new DaoCommande().ajouterCommande("01/04/2021","03/04/2021","2","haha",35.00,5.00,"M0001");
        new DaoLigneCommande().ajouterLigneCommande("12345678",6,4);

    }
}