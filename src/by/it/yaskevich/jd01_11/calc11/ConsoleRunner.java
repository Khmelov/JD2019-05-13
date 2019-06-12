package by.it.yaskevich.jd01_11.calc11;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expession;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(expession = scanner.nextLine()).equals("end")) {
            Var var = parser.calc(expession);
            printer.print(var);
        }
    }
}
