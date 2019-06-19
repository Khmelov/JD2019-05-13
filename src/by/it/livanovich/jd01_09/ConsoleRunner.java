package by.it.livanovich.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line;
        Parsel parsel=new Parsel();
        Printer printer=new Printer();
        while (!(line=sc.nextLine()).equals("end")){
            Var result=parsel.calc(line);
            printer.print(result);
        }
    }
}
