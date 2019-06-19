package by.it.adamovichjr.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line=scanner.nextLine()).equals("end")){
            if(line.equals("printvar")){
                printer.printvar(Var.getVars());
            }
            else if(line.equals("sortvar")){
                printer.sortvar();
            }
            else {
                try {
                    Var result = parser.calc(line);
                    printer.print(result);
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
