package by.it.guchek.jd02_05;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class TaskB {
    public static void main(String ... args) {

        //ResManager manager = ResManager.INSTANCE;
        if (args.length == 2) {
            String lang1=args[0];
            String country1=args[1];
            //Locale locale = new Locale(lang,country);
            //manager.setLocale(locale);
        }

        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("lang","country") );
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
    System.out.println(df.format(d));
}
}
