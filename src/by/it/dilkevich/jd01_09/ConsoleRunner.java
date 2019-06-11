package by.it.dilkevich.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!((inputLine = scanner.nextLine()).equals("end"))){
            Var result = parser.calc(inputLine);
            printer.print(result);
        }
    }


}
