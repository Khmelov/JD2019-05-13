package by.it.livanovich.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        Parsel parsel = new Parsel();
        Printer printer = new Printer();
        while (!(line = sc.nextLine()).equals("end")) {

            Var result = parsel.calc(line);
            printer.print(result);
            if (line.equals("printvar")) {
                Var.print();}
            if (line.equals("sortvar")) {
                Var.print();}

        }
    }
}