package by.it.yakovets.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String expression;
        double result=0;
        while (!(expression=sc.nextLine()).equals("END")){
            try {
                double inputDouble=Double.parseDouble(expression);
                 result+=inputDouble;
                 if (result<0) throw new ArithmeticException();
               else System.out.println(Math.sqrt(result));
            }
            catch (NumberFormatException|ArithmeticException e){
                String name = e.getClass().getName();
                String className = TaskB.class.getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (element.getClassName().equals(className)) {
                        System.out.printf("" +
                                "  name: %s\n" +
                                " class: %s\n" +
                                "  line: %d\n" +
                                "", name, className, element.getLineNumber());
                        break;
                    }
                }

            }
        }
    }
}
