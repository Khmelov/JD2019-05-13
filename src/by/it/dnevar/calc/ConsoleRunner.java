package by.it.dnevar.calc;

import java.util.Scanner;

public class ConsoleRunner {

/*TODO реализуйте автоматическое сохранение и восстановление при запуске списка переменных (A) векторов (B) и
матриц (C), добавленных в Map после операций присваивания. Файл с переменными должен храниться в
текстовом формате переменная=значение в каталоге с исходными кодами проекта calc под именем vars.txt.
реализуйте дублирование консольных сообщений о работе проекта в файле log.txt:
• с сообщениями об ошибках (A)
• c дублированием данных о проведенных вычислениях (B)
• c ограничением размера файла log.txt в 50 последних сообщений и ошибок (С)*/

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
