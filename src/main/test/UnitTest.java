
import Outil.CsvReader;
import Outil.DateString;
import Outil.HibernateConn;
import Outil.RandomString;
import dao.*;

import metier.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import service.ServiceRechercher;

import java.util.ArrayList;
import java.util.List;


public class UnitTest {
    @Test
    public void test(){
//        ArrayList<Produit> list=new DaoProduit().listProduitEnPromo();
//        //ArrayList<Produit> list=new ServiceRechercher().findProduitByWord("viand");
//        System.out.println(list);

//         ArrayList<Panier> list=new DaoPanier().listPanierUnClient("bugubugu@gamil.com");
//        System.out.println(list);
//        CsvReader csvReader=new CsvReader();
//        csvReader.read();

//        DaoPanier daoPanier=new DaoPanier();
//        daoPanier.modifierQtePanier("bugubugu@gamil.com",10L,8);

//        DaoListeCourse daoListeCourse=new DaoListeCourse();
//        Listecourse listecourse=new Listecourse();
//        String id=new RandomString().getRandomString(12);
//        listecourse.setIdListe(id);
//        listecourse.setEmailClient("bugubugu@gamil.com");
//        listecourse.setLibelleListe("legume");
//        String date= DateString.dateString();
//        listecourse.setDatecree(date);
//        daoListeCourse.creerUneListe(listecourse);
//        DaoPostIt daoPostIt=new DaoPostIt();
//        daoPostIt.updatePost(1,1,20);
        DaoProduit daoProduit=new DaoProduit();
        ArrayList<Produit> list=daoProduit.listProduitEnPromo();


//        //test
//        DaoMagasin m=new DaoMagasin();
//        for (Magasin mm:m.listeMagasin()
//             ) {
//            System.out.println(mm);
//        }

        //test
//        Client client=new DaoClient().unClient("bugubugu@gamil.com");
//        System.out.println(client);
//

        //test
//        DaoClientCommande daoClientCommande=new DaoClientCommande();
//
//        ArrayList<Commande> liste=daoClientCommande.listeCommandeClient("bugubugu@gmail.com");
//        for (Commande l:liste
//             ) {
//            System.out.println(l);
//        }
//        Session session= HibernateConn.getSessionFactory().getCurrentSession();
//        Transaction transaction=session.beginTransaction();
//
//        String sql="select l.* from commande c,lignecommande l where l.idCdeCli=c.idCdeCli and c.idCdeCli=? ";
//
//
//
//        List<Lignecommande> list=session.createSQLQuery(sql).addEntity(Lignecommande.class).setParameter(1,"affd2356").list();
//        for (Lignecommande l:list
//             ) {
//            System.out.println(l);
//        }

        //add un magasin test
//        Magasin magasin=new Magasin();
//        magasin.setIdMagasin("2");
//        session.save(magasin);
        //transaction.commit();
    }
}
