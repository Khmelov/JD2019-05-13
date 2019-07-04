package by.it.aadamovich.calc;

import by.it.aadamovich.calc.names.ResData;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {

        ResourceManager manager = ResourceManager.INSTANCE;
        Scanner sc = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = sc.nextLine()).equals(Patterns.END_COMMAND)) {
            switch (line) {
                case Patterns.PRINTVAR_COMMAND:
                    printer.printVar();
                    break;
                case Patterns.SORTVAR_COMMAND:
                    printer.printSortedVar();
                    break;
                case Patterns.RUSSIAN_COMMAND:
                    manager.setLocale(ConsoleRunner.getLocale(Patterns.RUS_LANG, Patterns.RUS_COUN));
                    System.out.println(manager.getString(ResData.RUSSIAN_SWITCH));
                    break;
                case Patterns.BELARUSIAN_COMMAND:
                    manager.setLocale(ConsoleRunner.getLocale(Patterns.BY_LANG, Patterns.BY_COUN));
                    System.out.println(manager.getString(ResData.BELARUSIAN_SWITCH));
                    break;
                case Patterns.ENGLISH_COMMAND:
                    Locale.setDefault(Locale.ENGLISH);
                    manager.setLocale(Locale.getDefault());
                    System.out.println(manager.getString(ResData.ENGLISH_SWITCH));
                    break;

                default:
                    try {
                        Var calc = parser.calc(line);
                        printer.print(calc);
                    } catch (CalcException e) {
                        System.out.println(e.getMessage());
                    }
            }
        }
    }

    private static Locale getLocale(String language, String country) {
                return new Locale(language, country);
    }
}
