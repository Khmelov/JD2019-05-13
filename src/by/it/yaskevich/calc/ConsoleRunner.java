package by.it.yaskevich.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        ResourcesManager manager = ResourcesManager.INSTANCE;
        try {
            Var.loadVariables();

            String expression;
            while (!(expression = scanner.nextLine()).equals("end")) {
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
                        } catch (CalcException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
        } finally {
            Var.saveVariables();
        }
    }
}
