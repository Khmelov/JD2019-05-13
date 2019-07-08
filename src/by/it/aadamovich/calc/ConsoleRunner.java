package by.it.aadamovich.calc;

import by.it.aadamovich.calc.names.Commands;
import by.it.aadamovich.calc.names.LangCountry;
import by.it.aadamovich.calc.names.ResData;
import by.it.aadamovich.calc.reportBuilder.Director;
import by.it.aadamovich.calc.reportBuilder.FullReportBuilder;
import by.it.aadamovich.calc.reportBuilder.ShortReportBuilder;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {

        Director director = Director.DIRECTOR;
        director.setBuilder(args.length == 0 ? new ShortReportBuilder() : new FullReportBuilder());
        director.startReport();
        ResourceManager manager = ResourceManager.INSTANCE;
        Scanner sc = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = sc.nextLine()).equals(Commands.END_COMMAND)) {
            printer.logData(String.format(manager.getString(ResData.CONSOLE_INPUT),line));
            switch (line) {
                case Commands.PRINTVAR_COMMAND:
                    printer.printVar();
                    break;
                case Commands.SORTVAR_COMMAND:
                    printer.printSortedVar();
                    break;
                case Commands.RUS_LANG_COMMAND:
                    manager.setLocale(LangCountry.RUS_LANG, LangCountry.RUS_COUN);
                    printer.print(manager.getString(ResData.RUSSIAN_SWITCH));
                    break;
                case Commands.BY_LANG_COMMAND:
                    manager.setLocale(LangCountry.BY_LANG, LangCountry.BY_COUN);
                    printer.print(manager.getString(ResData.BELARUSIAN_SWITCH));
                    break;
                case Commands.ENG_LANG_COMMAND:
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
                        director.addError(e);
                    }
            }
        }
        director.endReport();
        System.out.println(director.getReport());
    }
}
