package by.it.guchek.jd02_05;

import by.it.guchek.jd02_05.names.Message;
import by.it.guchek.jd02_05.names.ResData;

import java.text.DateFormat;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TaskB {

    public static ResManager manager = ResManager.INSTANCE;

    public static void main(String[] args) {

        manager.setLocale(Locale.getDefault());

        if (args.length == 2) {
            String lang=args[0];
            String country=args[1];
            Locale locale = new Locale(lang,country);
            manager.setLocale(locale);
        }

        TaskA.printWellcoming(manager);

        DateFormat dateInstance = DateFormat.getDateInstance(DateFormat.LONG, manager.getLocale());
        System.out.println(manager.get(ResData.DATA)+" "+dateInstance.format(Date.from(Instant.now())));

        Scanner sc = new Scanner(System.in);
        String line;

        while (!(line=sc.nextLine()).equals("end")){
            switch (line){
                case "ru":{
                    Locale locale = new Locale("ru", "RU");
                    manager.setLocale(locale);
                    reWelcomByLocale();
                    break;
                }
                case "be":{
                    Locale locale = new Locale("be", "BY");
                    manager.setLocale(locale);
                    reWelcomByLocale();
                    break;
                }
                case "en":{
                    Locale locale = new Locale("en", "EN");
                    manager.setLocale(locale);
                    reWelcomByLocale();
                    break;
                }
            }

        }
    }

    private static void reWelcomByLocale() {
        DateFormat dateInstance;
        TaskA.printWellcoming(manager);
        dateInstance = DateFormat.getDateInstance(DateFormat.LONG, manager.getLocale());
        System.out.println(manager.get(ResData.DATA)+" "+dateInstance.format(Date.from(Instant.now())));
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
