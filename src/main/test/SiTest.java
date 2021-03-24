import dao.DaoProduit;
import metier.Produit;
import metier.Rayon;
import org.junit.Test;
import service.ServiceRayon;

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
        ServiceRayon sr=new ServiceRayon();
        HashMap<Rayon,ArrayList<Rayon>> list=sr.allRayonAndCategories();
        for (Rayon r:list.keySet()){
            System.out.println("---"+r.getNomCate());
            for (Rayon cat:list.get(r)){
                System.out.println(cat.getNomCate());
            }
        }
    }
}