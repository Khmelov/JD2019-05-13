package by.it.izaykoff.Calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;

        Parcer parcer = new Parcer();
        Printer printer = new Printer();

        while (!(line = scan.nextLine()).equals("end")){
            if (line.equals("printvar")){
                
            }
            Var result = parcer.calc(line);
            printer.print(result);
        }
    }
}
