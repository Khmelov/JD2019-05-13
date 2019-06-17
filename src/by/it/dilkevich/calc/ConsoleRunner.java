package by.it.dilkevich.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!((inputLine = scanner.nextLine()).equals("end"))) {
            if (inputLine.equals("printvar")) {
                printer.printVar();
            }
            if (inputLine.equals("sortvar")) {
                printer.printSortVar();
            }
            if (!inputLine.equals("printvar") && !inputLine.equals("sortvar")) {
                 Var result = parser.calc(inputLine);
                 printer.print(result);
             }


        }
    }


}
