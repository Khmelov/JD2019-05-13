package by.it.maniuk.calc;



import by.it.maniuk.calc.names.Messages;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        String lang = "en";
        String country = "EN";
        if (args.length == 2) {
            lang =  args[0];  country =  args[1];}
        String s;
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        lacal(lang, country);
        try {
            Var.backToMap();
        } catch (CalcException e) {
            new LogException(e);
        }
        while (!(s = scanner.nextLine()).equals("end")){
            try {
                if (s.equals("ru")) {
                    lang = "ru";
                    country = "RU";
                    lacal(lang, country);

                }
                if (s.equals("be")) {
                    lang = "be";
                    country = "BY";
                    lacal(lang, country);

                }
                if (s.equals("en")) {
                    Locale.setDefault(Locale.ENGLISH);
                    lang = "en";
                    country = "EN";
                    lacal(lang, country);

                }
                if (s.equals("sortvar")) {Printer.sortVar(); continue;}
                if(s.equals("printvar")){Printer.printVar(); continue;}
                Var result = null;
                try {
                    result = parser.calc(s);
                } catch (IOException e) {
                    new LogException(e);
                }
                printer.print(result);
            } catch (CalcException e) {
                new LogException(e);
            }

        }

    }

     static void lacal(String lang, String country) {
        Locale locale;
        ResManager manager = ResManager.INSTANCE;
        locale = new Locale(lang, country);
        String d = DateFormat.getDateInstance(DateFormat.LONG).format(new Date());
        String t = (new SimpleDateFormat("HH:mm:ss")).format(new Date());
        System.out.println(d+" "+t);
        manager.setLocale(locale);
        String welcome = manager.get(Messages.WELCOME);
        System.out.println(welcome);
        String language = manager.get(Messages.LANGUAGE);
        System.out.println(language);


    }


}
