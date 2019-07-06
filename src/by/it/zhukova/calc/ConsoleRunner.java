package by.it.zhukova.calc;

import java.util.Locale;
import java.util.Scanner;

import static by.it.zhukova.calc.Var.sortvar;

public class ConsoleRunner {
    public static ResManager manager = ResManager.INSTANCE;
    public static void main(String[] args) throws Exception {

        if (args.length == 2) {
            String lang=args[0];
            String country=args[1];
            Locale locale = new Locale(lang,country);
            manager.setLocale(locale);
        }
        System.out.println("Choose language,please: ru be en:");
        Scanner scanner = new Scanner(System.in);
        String lang=scanner.nextLine();
        String country = "";
        switch (lang) {
            case "ru":
                country = "RU";
                break;
            case "be":
                country = "BY";
                break;
            default:
                lang = "en";
                country = "US";
        }
        Locale locale = new Locale(lang,country);
        manager.setLocale(locale);
        String expression;
        Parser parser = new Parser();
        Printer printer = new Printer();

            while (!(expression = scanner.nextLine()).equals("end")) {
              if (expression.equals("printvar")) {Var.printvar(); continue;}
                if (expression.equals("sortvar")) {
                    sortvar(); continue;}
               try{ Var result = parser.calc(expression);
                    printer.print(result);}
               catch (CalcException e) {
                   System.out.println(e.getMessage());
               }
            }
    }
            }


