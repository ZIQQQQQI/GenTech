import dao.DaoRayon;
import dao.DaoRayonCategorie;
import metier.Lignecommande;
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

        DaoRayonCategorie drc = new DaoRayonCategorie();
        for (Rayon r:drc.listeRayonCategorie(2)
        ) {
            System.out.println(r);
        }

    }
}