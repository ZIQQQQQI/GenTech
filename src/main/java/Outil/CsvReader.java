package Outil;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/29
 */

import metier.Ligneachat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader {
    public ArrayList<Ligneachat> read(){
        String csvFile = "C:/CS/JAVA/apache-tomcat-9.0.38/webapps/GenTech/WEB-INF/test.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        ArrayList<Ligneachat> l=new ArrayList<>();

        try{

            br = new BufferedReader(new FileReader(csvFile));
            Integer i=0;
            while ((line = br.readLine()) != null) {
                if(i>0){
                    // use comma as separator
                    String[] ligne = line.split(cvsSplitBy);
                    Ligneachat unL=new Ligneachat();
                    unL.setIdCdeAchat(null);
                    unL.setQteReste( Integer.valueOf(ligne[2]).longValue() );
                    unL.setIdProduit(Integer.valueOf(ligne[1]) );
                    unL.setIdCdeAchat(ligne[0]);

                    l.add(unL);


                }
                i=i+1;


            }

        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException f) {
            f.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return l;
    }



}
