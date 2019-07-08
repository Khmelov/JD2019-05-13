package by.it.yakimovich.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Logger logger = Logger.loggingError();
        Scanner scan=new Scanner(System.in);
        String line;
        Parser parser=new Parser();
        Printer printer=new Printer();

        while(!(line=scan.nextLine()).equals("end")){
                 try {
                Var result = parser.calc(line);
                printer.print(result);
            } catch (CalcException e) {
                     System.out.println(e.getMessage());
                     logger.toLog(e.getMessage());
            }
        }
    }
}
