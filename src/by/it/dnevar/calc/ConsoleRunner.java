package by.it.dnevar.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while(!(line = sc.nextLine()).equals("end")){
            if(line.equals("printvar")){
                Var.printVar();
            }else if(line.equals("sortvar")) {
                Var.printSortVar();
            }else{
                try{
                    Var result = parser.calc(line);
                    printer.print(result);
                } catch(CalcException e){
                    System.out.println(e.getMessage());
                }

            }
        }


    }
}
