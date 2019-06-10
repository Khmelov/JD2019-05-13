package by.it.guchek.jd01_09;

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
          Var result = parser.calc(line);
          printer.print(result);
        }

    }
}
