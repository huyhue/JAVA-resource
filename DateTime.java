package Outsource;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateTime {

    //get current date 
    public static String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

    public static void main(String[] args) {
        //L?y ngày gi? hi?n t?i c?a h? th?ng:
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        System.out.println(year);
        
        int month = cal.get(Calendar.MONTH);
        System.out.println(month + 1);
        
        int day = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(day);

        Date t = cal.getTime();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(sdf.format(t));

        SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println(sdf2.format(t));

        SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        System.out.println(sdf3.format(t));

        SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aaa");
        System.out.println(sdf4.format(t));

//    -------------------------------------------------------------------------------------------
        Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR);

        System.out.println("M?i thím nh?p n?m sinh(dd/MM/yyyy):");
        String ns = new Scanner(System.in).nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date birthday = sdf.parse(ns);
            //??i ngày tháng n?m:
            cal.setTime(birthday);
            int yearNs = cal.get(Calendar.YEAR);

            int tuoi = yearNow - yearNs;
            System.out.println("B?n " + tuoi + " tu?i");

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//    -------------------------------------------------------------------------------------------

    }
    
    //start, end type of Date
    public long NumberOfYear() {
		return this.end.getTime()/86400000 - this.start.getTime()/86400000;
    }
}
