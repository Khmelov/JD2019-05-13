package by.it.yaskevich.calc;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        ResourcesManager manager = ResourcesManager.INSTANCE;
        ReportBuilder builder = getReportBuilder(args);
        builder.buildName();
        try {
            builder.buildData("Program start");
            Var.loadVariables();

            String expression;
            while (!(expression = scanner.nextLine()).equals("end")) {
                Logger.INSTANCE.log(expression);
                builder.buildEvent(expression);
                switch (expression) {
                    case Patterns.COMMAND_PRINTVAR: {
                        Var.printVar();
                        break;
                    }
                    case Patterns.COMMAND_SORTVAR: {
                        Var.sortVar();
                        break;
                    }
                    case Patterns.COMMAND_RU: {
                        manager.setLocale(new Locale("ru", "RU"));
                        break;
                    }
                    case Patterns.COMMAND_BE: {
                        manager.setLocale(new Locale("be", "BY"));
                        break;
                    }
                    case Patterns.COMMAND_EN: {
                        manager.setLocale(Locale.ENGLISH);
                        break;
                    }
                    default: {
                        try {
                            Var var = parser.calc(expression);
                            printer.print(var);
                            builder.buildEvent(var.toString());
                        } catch (CalcException e) {
                            System.out.println(e.getMessage());
                            builder.buildException(e);
                        } catch (Exception e) {
                            Logger.INSTANCE.log(e.getMessage());
                            builder.buildException(e);
                        }
                    }
                }
            }
        } finally {
            Var.saveVariables();
            builder.buildData("Finish program");
        }
        builder.build("report.txt");
    }

    private static ReportBuilder getReportBuilder(String[] args) {
        if (args.length > 0) {
            switch (args[0]) {
                default:
                case "s": {
                    return new ShortReportBuilder();
                }
                case "f": {
                    return new FullReportBuilder();
                }
            }
        } else {
            return new ShortReportBuilder();
        }
    }
}
