package by.it.lasotskaya.calc;

import java.util.Scanner;


public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Parser parser=new Parser();
        Printer printer=new Printer();
        String line;
        while (!(line=scanner.nextLine()).equals("end")){
            if (line.equals("printvar")){
                Var.printvar();
                continue;
            }
            if (line.equals("sortvar")){
                Var.sortvar();
                continue;
            }
            Var result=parser.calc(line);
            printer.print(result);
        }
    }
}