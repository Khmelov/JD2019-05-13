package by.it.tbabich.calc;

import by.it.tbabich.jd02_05.names.ConsoleCommands;

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
                        Var var = null;
                        try {
                            var = parser.calc(expression);
                        } catch (CalcException e) {
                            e.printStackTrace();
                        }
                        printer.print(var);
                    }
            }
        }
    }
}
