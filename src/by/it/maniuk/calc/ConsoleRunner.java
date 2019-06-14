package by.it.maniuk.calc;



import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(s = scanner.nextLine()).equals("end")){
            if (s.equals("sortvar")) {Var.sortVar(); continue;}
            if(s.equals("printvar")){Var.printVar(); continue;}

            Var result = parser.calc(s.trim());
            printer.print(result);

        }

    }

}
