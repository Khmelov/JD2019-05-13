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
            printer.logData(line);
            switch (line) {
                case Patterns.PRINTVAR_COMMAND:
                    printer.printVar();
                    break;
                case Patterns.SORTVAR_COMMAND:
                    printer.printSortedVar();
                    break;
                case Patterns.RUSSIAN_COMMAND:
                    manager.setLocale(Patterns.RUS_LANG, Patterns.RUS_COUN);
                    printer.print(manager.getString(ResData.RUSSIAN_SWITCH));
                    break;
                case Patterns.BELARUSIAN_COMMAND:
                    manager.setLocale(Patterns.BY_LANG, Patterns.BY_COUN);
                    printer.print(manager.getString(ResData.BELARUSIAN_SWITCH));
                    break;
                case Patterns.ENGLISH_COMMAND:
                    Locale.setDefault(Locale.ENGLISH);
                    manager.setLocale(Locale.getDefault());
                    printer.print(manager.getString(ResData.ENGLISH_SWITCH));
                    break;

                default:
                    try {
                        Var calc = parser.calc(line);
                        printer.print(calc);
                    } catch (CalcException e) {
                        printer.print(e);
                    }
            }
        }
    }
}
