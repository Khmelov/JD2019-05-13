package by.it.trudnitski.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String expression;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(expression = scanner.nextLine()).equals("end")) {
            if (expression.contains("printvar")) {
                printer.printvar(Var.getVars());
            } else if (expression.contains("sortvar")) {
                printer.sortVar();
            }
            try {
                Var var = parser.calc(expression);
                printer.print(var);
            } catch (CalcExeption e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
