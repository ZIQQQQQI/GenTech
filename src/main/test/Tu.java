import dao.DaoRayon;
import dao.DaoRayonCategorie;
import dao.DaoRayonProduit;
import metier.Lignecommande;
import metier.Produit;
import metier.Rayon;
import org.junit.Test;

public class Tu {
    @Test
    public void test(){

        /*DaoRayon dr = new DaoRayon();

        for (Rayon l:dr.listeRayon()
        ) {
            System.out.println(l);
        }*/
        /*
        DaoRayonCategorie drc = new DaoRayonCategorie();
        for (Rayon r:drc.listeRayonCategorie(2)
        ) {
            System.out.println(r);
        }*/

        DaoRayonProduit drp = new DaoRayonProduit();
        for (Produit p:drp.listeRayonProduit(6)
        ) {
            System.out.println(p);
        }

    }
}