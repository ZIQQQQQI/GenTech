package Outil;/*
 *@program GenTechTang
 *@author ziqi tang
 *@date 2021/3/31
 */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateString {
    public static String dateString(){
        DateFormat sdf=new SimpleDateFormat("dd/MM/YYYY");
        Date date=new Date();
        return sdf.format(date);
    }
}
