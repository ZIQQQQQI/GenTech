package Outil;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/30
 */

import java.util.Random;

public class RandomString {

    private static String range = "0123456789abcdefghijklmnopqrstuvwxyz";

     public  String getRandomString(Integer length){

        Random random = new Random();

        StringBuffer result = new StringBuffer();

         for ( int i = 0; i < length; i++ ){

            result.append( range.charAt( random.nextInt( range.length() ) ) );

             }

    return result.toString();
 }

}
