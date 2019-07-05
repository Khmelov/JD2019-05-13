package by.it.guchek.jd02_05;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        ResManager manager = ResManager.INSTANCE;
        if (args.length == 2) {
            String lang=args[0];
            String country=args[1];
            Locale locale = new Locale(lang,country);
            manager.setLocale(locale);
        }

        TaskA.printWellcoming(manager);

        DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.LONG, manager.getLocale());
        System.out.println(dateInstance.format(Date.from(Instant.now())));
        Scanner sc = new Scanner(System.in);
        String line;
        while (!(line=sc.nextLine()).equals("end")){
            switch (line){
                case "ru":{
                    Locale locale = new Locale("ru", "RU");
                    manager.setLocale(locale);
                    break;
                }
                case "be":{
                    Locale locale = new Locale("be", "BY");
                    manager.setLocale(locale);
                    break;
                }
                case "us":{
                    Locale locale = new Locale("us", "EN");
                    manager.setLocale(locale);
                    break;
                }
            } break;
        }
        DateFormat dateInstance2 = DateFormat.getDateInstance(DateFormat.LONG, manager.getLocale());
        System.out.println(dateInstance2.format(Date.from(Instant.now())));
    }
}


 /*DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US );
    Date d = null;
    String str = "April 12, 2016";
    try {
        d = df.parse(str);
        System.out.println(d);
    } catch (ParseException e) {
        System.err.print("Error position: " + e.getErrorOffset());
    }
    df = DateFormat.getDateInstance(DateFormat.LONG, new Locale("ru","RU"));
    System.out.println(df.format(d));
    df = DateFormat.getDateInstance(DateFormat.FULL,Locale.GERMAN);
    System.out.println(df.format(d));*/
