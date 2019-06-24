package by.it.maniuk.calc;



import java.io.IOException;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        Parser parser = new Parser();
        Printer printer = new Printer();
        try {
            Var.backToMap();
        } catch (CalcException e) {
            new LogException(e);
        }
        while (!(s = scanner.nextLine()).equals("end")){
            try {
                if (s.equals("sortvar")) {Printer.sortVar(); continue;}
                if(s.equals("printvar")){Printer.printVar(); continue;}
                Var result = null;
                try {
                    result = parser.calc(s);
                } catch (IOException e) {
                    new LogException(e);
                }
                printer.print(result);
            } catch (CalcException e) {
                new LogException(e);
            }

        }

    }

}
