package by.it.guchek.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        //создаем экземпляры
        Parser parser = new Parser();  //вычисления
        Printer printer = new Printer(); //и результат


        while (!(line = sc.nextLine()).equals("end")) {  //будем читать линии из консоли

           // if (line.equals("printvar")){
             //   printer.printMap();
            //} else if (line.equals("sortvar")) printer.sortvar();
             try {
                    if (line.equals("printvar")){
                        printer.printMap();
                    } else if (line.equals("sortvar")) printer.sortvar();
                            else {Var result = parser.calc(line);
                                  printer.print(result);}
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                    //e.printStackTrace();
                }
        }

    }
}
