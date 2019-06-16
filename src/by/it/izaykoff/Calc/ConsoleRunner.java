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
                printer.printvar(Var.getVars());
            } else if(line.equals("sortvar")){
                printer.sortvar();
            }
            Var result = parcer.calc(line);
            printer.print(result);
        }
    }
}
