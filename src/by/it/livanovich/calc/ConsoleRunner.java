package by.it.livanovich.calc;

import by.it.livanovich.calc.Text.Helper;
import by.it.livanovich.calc.logger.Singleton;


import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Logger;

public class ConsoleRunner {
private final static Logger logger=Logger.getLogger(ConsoleRunner.class.getName());

    public static void main(String[] args) {
        Singleton singleton=Singleton.INSTANCE;

        Scanner sc = new Scanner(System.in);
        String line;
        Parsel parsel = new Parsel();
        Printer printer = new Printer();
        while (!(line = sc.nextLine()).equals("end")) {
            if (line.equals("be") || line.equals("ru") || line.equals("en")) {
                Helper helper = Helper.INSTANCE;
                String language = null;
                String country = null;
                if (line.equals("be")) {
                    language = "be";
                    country = "BY";
                    singleton.createLog(logger);
                } else if (line.equals("ru")) {
                    language = "ru";
                    country = "RU";
                    singleton.createLog(logger);
                } else {
                    language = "en";
                    country = "EN";
                    singleton.createLog(logger);
                }
                Locale locale = new Locale(language, country);
                helper.setLocale(locale);
                line = sc.nextLine();
            }
            try {
                Var result = parsel.calc(line);
                printer.print(result);
                singleton.createLog(logger);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
                singleton.createLog(logger);
            }
            if (line.equals("printvar")) {
                Var.print();
                singleton.createLog(logger);
            }
            if (line.equals("sortvar")) {
                Var.sortvar();
                singleton.createLog(logger);
            }
        }

    }
}