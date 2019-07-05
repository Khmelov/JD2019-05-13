package by.it.livanovich.calc;

import by.it.livanovich.calc.Text.Helper;
import by.it.livanovich.jd02_05.names.Data;
import by.it.livanovich.jd02_05.names.Message;
import by.it.livanovich.jd02_05.names.User;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {


    public static void main(String[] args) {

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
                } else if (line.equals("ru")) {
                    language = "ru";
                    country = "RU";
                } else {
                    language = "en";
                    country = "EN";
                }
                Locale locale = new Locale(language, country);
                helper.setLocale(locale);
                line = sc.nextLine();
            }
            try {
                Var result = parsel.calc(line);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
            if (line.equals("printvar")) {
                Var.print();
            }
            if (line.equals("sortvar")) {
                Var.sortvar();
            }
        }
    }
}