package service;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/28
 */

import com.sun.jdi.request.DuplicateRequestException;
import dao.*;
import metier.*;
import org.hibernate.boot.model.source.spi.PluralAttributeElementSourceOneToMany;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class ServicePanier {
    private DaoPanier daoPanier=new DaoPanier();
    private DaoStock daoStock=new DaoStock();

    public void ajouer(String email,Integer idP){daoPanier.ajouer(email,idP);}

    public HashMap<Produit,Integer> listPanierUnClient (String emailClient){
        ArrayList<Panier> tousLesProduitDansPainer=daoPanier.listPanierUnClient(emailClient);
        HashMap<Produit,Integer> res=new HashMap<>();
        for(Panier p:tousLesProduitDansPainer){
            Produit produit=new DaoProduit().rechercheUnProduit(p.getCodeProduit());
            res.put(produit,p.getQuantite().intValue());
        }
        return res;
    }

    public Magasin unMagasin(String idMagasin){
        return new DaoMagasin().unMagasin(idMagasin);
    }


    public HashMap<Produit, Promotion> produitPrixPromo(){
        ArrayList<Produit> tousLesProduitPromo=new DaoProduit().listProduitEnPromo();
        ArrayList<Promotion> tousLesPromo=new DaoPromotion().listPromotion();
        ArrayList<Enpromo> tousLesEnPromo=new DaoPromotion().listEnPromo();
        HashMap<Produit,Promotion> res=new HashMap<>();
        HashMap<Produit,Enpromo> pouEnPromo=new HashMap<>();

        for(Enpromo e:tousLesEnPromo){
            for(Produit p:tousLesProduitPromo){
                if(p.getCodeProduit()==e.getCodeProduit()){
                    pouEnPromo.put(p,e);
                }
            }
        }
        for (Produit produit:pouEnPromo.keySet()){
            for (Promotion p:tousLesPromo){
                if (pouEnPromo.get(produit).getIdPromo().equals(p.getIdPromo())){
                    res.put(produit,p);
                }
            }
        }

        return res;
    }

    public void supprimer(String email){
        daoPanier.supprimer(email);
    }

    public  void changeQte(String emailClient,Long qte,Integer codeProd){
        this.daoPanier.modifierQtePanier(emailClient,qte,codeProd);
    }



    public ArrayList<String> verifierStock(String emailClient,String dateRetrait){
        ArrayList<String> res=new ArrayList<>();
        HashMap<Produit,Integer> listProduitPainer = listPanierUnClient(emailClient);
        for(Produit p:listProduitPainer.keySet()){
            ArrayList<Ligneachat> ligneachats=new DaoStock().ligneachatsProduitVerifier(p.getCodeProduit(),dateRetrait);
            long sum=0;
            String note="";
            for (Ligneachat l:ligneachats){
                sum=sum+l.getQteReste();
            }
            if(listProduitPainer.get(p)<sum){
                note="";
            }else{
                note=p.getLibelleProduit()+" n'a pas assez destock,veuillez changer d'autres produits";
                res.add(note);
            }
        }
        return res;

    }

    public void modifierQteLigneAchat(String emailClient,String dateRetrait){
        HashMap<Produit,Integer> listProduitPainer = listPanierUnClient(emailClient);
        for(Produit p:listProduitPainer.keySet()){
            ArrayList<Ligneachat> ligneachats=new DaoStock().ligneachatsProduitVerifier(p.getCodeProduit(),dateRetrait);
            for (Ligneachat l:ligneachats){
                if(l.getQteReste()!=0){
                    if(l.getQteReste()>listProduitPainer.get(p)){
                        daoStock.updateLigneAchat(l.getIdCdeAchat(),p.getCodeProduit(),(l.getQteReste()-(long)listProduitPainer.get(p)));
                    }else{
                        daoStock.updateLigneAchat(l.getIdCdeAchat(),p.getCodeProduit(),0);
                        listProduitPainer.put(p, (int) (listProduitPainer.get(p)-l.getQteReste()));
                    }
                }
            }

        }

    }

    public void ajouterCommande(String idCde,String dateCdeCli,String dateRetrait,String heureRetrait,String emailClient,double prixTotal,double economie,String idMagasin){
        new DaoCommande().ajouterCommande(idCde,dateCdeCli,dateRetrait,heureRetrait,emailClient,prixTotal,economie,idMagasin);
    }

    public void ajouterLigneCommande(String idCde,Integer codeProduit,Integer qte){
        new DaoLigneCommande().ajouterLigneCommande(idCde,codeProduit,qte);
    }
}
