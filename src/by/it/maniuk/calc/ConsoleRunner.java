package by.it.maniuk.calc;



import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(s = scanner.nextLine()).equals("end")){
            try {
                if (s.equals("sortvar")) {Printer.sortVar(); continue;}
                if(s.equals("printvar")){Printer.printVar(); continue;}
                Var result = parser.calc(s);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }

        }

    }

}
