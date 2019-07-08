package by.it.tbabich.calc;

import by.it.tbabich.calc.names.ConsoleCommands;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression;
        Settings settings = new Settings();
        settings.initSetting(args);
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!((expression = sc.nextLine()).equals(ConsoleCommands.END))) {
            switch (expression) {
                case "printvar":
                    Var.printvar();
                    break;
                case "sortvar":
                    Var.sortvar();
                    break;
                default:
                    if (!Settings.isSetLanguage(expression)) {
                        Settings.shortReportBuilder.addExpressionToBody("Expression: " + expression);
                        Settings.fullReportBuilder.addExpressionToBody("Expression: " + expression);
                        Var var = null;
                        try {
                            var = parser.calc(expression);
                        } catch (CalcException e) {
                            System.out.println(e.getMessage());
                        }
                        Settings.fullReportBuilder.addExpressionToBody("Result: " + var);
                        Settings.shortReportBuilder.addExpressionToBody("Result: " + var);
                        printer.print(var);
                    }
            }
        }
        settings.stop();
    }
}
