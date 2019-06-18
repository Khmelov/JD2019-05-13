package by.it.akhmelev.calc13;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String expression;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(expression = scanner.nextLine()).equals("end")) {
            Var var = null;
            try {
                var = parser.calc(expression);
                printer.print(var);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
