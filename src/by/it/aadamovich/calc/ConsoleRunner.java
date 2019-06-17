package by.it.aadamovich.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = sc.nextLine()).equals("end")) {
            switch (line) {
                case "printvar":
                    printer.printVar();
                    break;
                case "sortvar":
                    printer.printSortedVar();
                    break;
                default:
                    Var calc = parser.calc(line);
                    printer.print(calc);
            }
        }
    }
}
