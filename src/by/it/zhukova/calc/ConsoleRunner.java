package by.it.zhukova.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression;
        String printerTabl;
        String sorted;
        Parser parser = new Parser();
            Printer printer = new Printer();
            while (!(expression = scanner.nextLine()).equals("end")) {
              if (expression.equals("printvar")) {Var.printvar(); continue;}
                if (expression.equals("sortvar")) {Var.sortvar(); continue;}
                Var result = parser.calc(expression);
                    printer.print(result);
              //  if ((sorted =scanner.nextLine()).equals("sortvar")) Var.sortvar();


            }
    }
            }


