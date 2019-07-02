package by.it.yaskevich.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        try {
            Var.loadVariables();

            String expression;
            while (!(expression = scanner.nextLine()).equals("end")) {
                switch (expression) {
                    case Patterns.PRINTVAR: {
                        Var.printVar();
                        break;
                    }
                    case Patterns.SORTVAR: {
                        Var.sortVar();
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
