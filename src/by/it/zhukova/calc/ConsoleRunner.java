package by.it.zhukova.calc;

import java.util.Scanner;

import static by.it.zhukova.calc.Var.sortvar;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {
        Scanner scanner = new Scanner(System.in);
        String expression;
        Parser parser = new Parser();
            Printer printer = new Printer();
            while (!(expression = scanner.nextLine()).equals("end")) {
              if (expression.equals("printvar")) {Var.printvar(); continue;}
                if (expression.equals("sortvar")) {
                    sortvar(); continue;}
               try{ Var result = parser.calc(expression);
                    printer.print(result);}
               catch (CalcException e) {
                   System.out.println(e.getMessage());
               }
            }
    }
            }


