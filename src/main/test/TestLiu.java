import dao.DaoCommandeproduit;
import metier.Lignecommande;
import metier.Produit;
import org.junit.Test;

public class TestLiu {
    @Test
 public void test()

    {
        DaoCommandeproduit dr = new DaoCommandeproduit();
        String email = "bugubugu@gamil.com";
        String idcde = "affd2356";


        for (Produit l:dr.commandeProduit(idcde)
        ) {
            System.out.println(l);
        }

    for (Produit q:dr.produitPlusCom(email)
        ) {
            System.out.println(q);

    }
} }
