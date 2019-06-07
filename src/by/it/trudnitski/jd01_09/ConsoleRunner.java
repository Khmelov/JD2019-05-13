package by.it.trudnitski.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws Exception  {

        Scanner scanner = new Scanner(System.in);
        String expression;
        Parser parser=new Parser();
        Printer printer=new Printer();
        while (!(expression=scanner.nextLine()).equals("end")){
            Var var=parser.calc(expression);
            printer.print(var);
        }
    }
}
