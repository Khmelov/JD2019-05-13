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
                                                            //до тех пор пока не введут это выражение
            //if (line.equals("sortvar"))

            if (!line.equals("printvar")){
            Var result = parser.calc(line);
            printer.print(result);}
            else printer.printMap();   //{System.out.println("еще не реализован");};


        }

    }
}
