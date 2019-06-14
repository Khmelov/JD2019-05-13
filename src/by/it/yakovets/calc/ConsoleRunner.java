package by.it.yakovets.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression;
        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(expression = sc.nextLine()).equals("end")) {
            if (expression.equals("printvar"))
                printer.printvar();
            if (expression.equals("sortvar"))
                printer.sotrvar();
            else {
                Var var = parser.calc(expression);
                printer.print(var);

            }
        }
    }
}
