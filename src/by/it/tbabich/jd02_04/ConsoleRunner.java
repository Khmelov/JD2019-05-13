package by.it.tbabich.jd02_04;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while(!((expression = sc.nextLine()).equals("end"))){
            Var var = null;
            try {
                var = parser.calc(expression);
            } catch (CalcException e) {
                e.printStackTrace();
            }
            printer.print(var);
        }
    }
}
