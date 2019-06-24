package by.it.yakimovich.jd01_13;

import java.util.Locale;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str;
        try{
        double sum=0;
        while (!(str = scanner.next()).equals("END")) {
        Double doub=Double.parseDouble(str);
            sum += doub;
            double sqrt = Math.sqrt(sum);
            System.out.printf(Locale.ENGLISH,"%.3f,%.3f\n",doub,sqrt);
            if (sum<0) throw new ArithmeticException();



       }} catch (ArithmeticException|NumberFormatException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (TaskB.class.getName().equals(element.getClassName())){
                    System.out.println(element);
                    String name=e.getClass().getName();
                    String clname=element.getClassName();
                    int number=element.getLineNumber();
                    System.out.printf("name: %s\n"+
                            "class: %s\n"+
                            "line: %d\n",name,clname,number);
                    break
                            ;

        }


    }}}}

