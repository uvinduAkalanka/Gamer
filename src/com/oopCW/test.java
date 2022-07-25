package com.oopCW;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class test {
    public static void main (String[] args) {
//        System.out.println ("enter");Scanner scanner = new Scanner (System.in);
//        String s = scanner.nextLine ();
//        System.out.println (s);
//        System.out.println (s.matches ("[a-zA-Z.]*"));
//
//        String x = "2020-05-";
//        Random random = new Random ();
//        int y = random.nextInt (30) + 1;
//        System.out.println (y + " this is y");
//        String z = x + y;
//        LocalDate c = LocalDate.parse (z);
//        System.out.println (c);
//        int


//        String date= "2021-" + month + "-" + day;
//        System.out.println (date);

        List<String> l = new ArrayList<> ();
        l.add ("2020-12-01");
        l.add ("2029-05-01");
        l.add ("2001-06-01");
        l.add ("2005-12-01");
        l.add ("2003-10-01");
        l.add ("2004-11-01");
        int i = 0;

        while (i < l.size ()) {
            System.out.println ("fffff");
            i++;
        }
        l.forEach (System.out::println);

//        sortDates (l);
        System.out.println (l.get (l.size () - 1));
        System.out.println ("yoooooooooooooooooooooooooooooo");

        l.forEach (System.out::println);
        System.out.println (l.size ());

        System.out.println ("start");

        l.forEach (d->{
            if (d.equals ("2001-06-01")) {
                System.out.println ("fuck me");
                return;
            }
            System.out.println (d);
        });

        if (!l.contains ("2004-10-01")) {
            System.out.println ("fuck meeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        }
//        {"data":{"text":"Anonymous caller does not have storage.objects.get access to the Google Cloud Storage object."},"status":401,"config":{"method":"GET","transformRequest":[null],"jsonpCallbackParam":"callback","url":"https://www.googleapis.com/storage/v1/b/google-code-archive/o/v2%2Fcode.google.com%2Fj-text-utils%2Fwiki%2FUsingTextTable'%3EUsing.wiki?alt=media","headers":{"Accept":"application/json, text/plain, */*"}},"statusText":""}


    }
//    public static void sortDates (List<String> dateList) {
//        Collections.sort (dateList, new Comparator<String> () {
//            DateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
//            @Override
//            public int compare (String date_1, String date_2) {
//                try {
//                    return dateFormat.parse (date_1).compareTo (dateFormat.parse (date_2));
//                } catch (ParseException e) {
//                    e.printStackTrace ();
//                }
//                return 0;
//            }
//
//        });
//    }





}
