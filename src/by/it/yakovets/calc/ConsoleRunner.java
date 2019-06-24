package by.it.yakovets.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression;
        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(expression = sc.nextLine()).equals("end")) {
            if (expression.equals("printvar")) {
                printer.printvar();
                continue;
            }
            if (expression.equals("sortvar")) {
                printer.sotrvar();
                continue;
            }


            try {
                Var var = parser.calc(expression);
                printer.print(var);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}

