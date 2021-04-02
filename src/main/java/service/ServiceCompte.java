package service;/*
 *@program GenTech
 *@author SI Lu
 *@date 25/03/2021
 */

import dao.DaoMagasin;
import dao.DaoProduit;
import dao.DaoRayon;
import metier.Commande;
import metier.Produit;
import metier.Rayon;

import java.text.DecimalFormat;
import java.util.*;
import dao.DaoClientCommande;
public class ServiceCompte {
    private DaoClientCommande daoClientCommande=new DaoClientCommande();
    private DaoRayon dr=new DaoRayon();
    private DaoProduit daoProduit=new DaoProduit();

    /*
     *@param emailClient
    	 * @param etat
     *@return java.util.HashMap<metier.Commande,java.lang.String>
     *@author Yufei
     *@date 2021/4/2 5:25
     *@exception
     *@description liste de commandes
    */
    public HashMap<Commande,String> listCommandeEnCoursOuTermine (String emailClient, String etat){
        ArrayList<Commande> tousLesCommandes =daoClientCommande.listCommandeEnCoursOuTermine(emailClient,etat);
        HashMap<Commande,String> res=new HashMap<>();
        for(Commande c:tousLesCommandes){
            String libelleMagasin=new DaoMagasin().unMagasin(c.getIdMagasin()).getLibelleMagasin();
            res.put(c,libelleMagasin);
        }
        return res;
    }

    /*
     *@param emailClient
     *@return java.util.ArrayList<metier.Rayon>
     *@author SI
     *@date 25/03/2021 17:24
     *@exception
     *@description Categorile le plus commande top5
    */
    public ArrayList<Rayon> listeRayonPrefere(String emailClient){
        return dr.listeRayonPrefere(emailClient);
    }

    /*
     *@param emailClient
     *@return java.util.ArrayList<metier.Produit>
     *@author SI
     *@date 25/03/2021 16:26
     *@exception
     *@description Recherche les produit le plus achetes
     */
    public ArrayList<Produit> listProduitPrefere(String emailClient){
        ArrayList<Produit> touslesProduit =daoProduit.produitsPourUnClient(emailClient);
        HashMap<Produit,Integer> top5=new HashMap<>();
        for (Produit p:touslesProduit){
            if(top5.containsKey(p)){
                top5.put(p,top5.get(p)+1);
            }else {
                top5.put(p,1);
            }
        }
        List<Map.Entry<Produit, Integer>> list =new ArrayList(top5.entrySet());
        Collections.sort(list, (o1, o2) -> (o2.getValue()-o1.getValue()));
        ArrayList<Produit> finalTop5 = new ArrayList();
        for (int i = 0; i <5 ; i++) {
            finalTop5.add(list.get(i).getKey());
        }
        return finalTop5;
    }

    /*
     *@param emailClient
     *@return java.util.ArrayList<java.lang.String>
     *@author SI
     *@date 25/03/2021 17:29
     *@exception
     *@description  Recherche les marque les plus commandes
    */
    public ArrayList<String> listMarquePrefere(String emailClient){
        ArrayList<Produit> tousLesProduit =daoProduit.produitsPourUnClient(emailClient);
        HashMap<String,Integer> marques=new HashMap<>();
        for(Produit p:tousLesProduit){
            if(marques.containsKey(p.getMarque())){
                marques.put(p.getMarque(),marques.get(p.getMarque())+1);
            }else{
                marques.put(p.getMarque(),1);
            }
        }
        List<Map.Entry<String, Integer>> list =new ArrayList(marques.entrySet());
        Collections.sort(list, (o1, o2) -> (o2.getValue()-o1.getValue()));
        ArrayList<String> finalMarque =new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            finalMarque.add(list.get(i).getKey());
        }

        return finalMarque;

    }
    /*
     *@param emailClient
     *@return java.lang.String
     *@author SI
     *@date 25/03/2021 20:35
     *@exception
     *@description Rechercher le pourcentage de produit bio dans tous les produit commande
    */
    public String poucentageBio(String emailClient){
        ArrayList<Produit> tousLesProduit =daoProduit.produitsPourUnClient(emailClient);
        int total=tousLesProduit.size();
        int bio=0;
        for(Produit p:tousLesProduit){
            if (p.getBio()==1){
                bio++;
            }
        }
        if (bio==0){
            return "0";
        }else{
            DecimalFormat df=new DecimalFormat("0.00");
            return(df.format((float)bio/total*100)+"%");
        }

    }


    /*
     *@param emailClient
     *@return
     *@author SI
     *@date 25/03/2021 21:08
     *@exception
     *@description Rechercher la repartition de  nutriScore
     */
    public String repartitionNutriScore(String emailClient){
        ArrayList<Produit> tousLesProduit =daoProduit.produitsPourUnClient(emailClient);
        String s="";
        int total=0;
        int a=0;
        int b=0;
        int c=0;
        int d=0;
        int e=0;
        DecimalFormat df=new DecimalFormat("0.00");
        for(Produit p: tousLesProduit){
            if(p.getNutriScore()!=null){
                total++;
                if(p.getNutriScore().equals("A")){
                    a++;
                }else if(p.getNutriScore().equals("B")){
                    b++;
                }else if(p.getNutriScore().equals("C")){
                    c++;
                }else if(p.getNutriScore().equals("D")){
                    d++;
                }else{
                    e++;
                }
            }
            s=df.format((float)a/total*100)+","+df.format((float)b/total*100)+","+df.format((float)c/total*100)+","+df.format((float)d/total*100)+","+df.format((float)e/total*100);
        }
        return s;
    }
    /*
     *@param emailClient
     *@return java.lang.String
     *@author SI
     *@date 28/03/2021 22:32
     *@exception
     *@description Rechercher des economies d'un client par mois
     */
    public String economies(String emailClient){
        ArrayList<Commande> commandesCetAnnee=daoClientCommande.commandeCetAnnee(emailClient);
        String res="";
        HashMap<String, Double> economies=new HashMap<>();
        economies.put("01",(double)0);
        economies.put("02",(double)0);
        economies.put("03",(double)0);
        economies.put("04",(double)0);
        economies.put("05",(double)0);
        economies.put("06",(double)0);
        economies.put("07",(double)0);
        economies.put("08",(double)0);
        economies.put("09",(double)0);
        economies.put("10",(double)0);
        economies.put("11",(double)0);
        economies.put("12",(double)0);
        for(Commande c:commandesCetAnnee){
            String mois=c.getDateCdeCli().substring(3,5);
            if(economies.containsKey(mois)) {
                Double o=economies.get(mois);
                Double xin=o+c.getEconomie();
                economies.put(mois, xin);
            }
        }
        res= economies.get("01")+","+economies.get("02")+","+economies.get("03")+","+economies.get("04")+","+economies.get("05")+","+economies.get("06")+","+economies.get("07")+","+economies.get("08")+","+economies.get("09")+","+economies.get("10")+","+economies.get("11")+","+economies.get("12");
        return res;
    }






}