package by.it.livanovich.jd01_13;

import java.util.Scanner;

public class TaskB {
       public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        double sqr;
        int sum = 0;
        try {
            while (!((str = sc.next()).equals("END"))) {
                Double value = Double.valueOf(str);
                sum += value;
                if (sum<=0){
                    throw new DoubleArithmeticException("ArithmeticException");
                }
                sqr = Math.sqrt(sum);
                System.out.println(sqr);
            }
        }
        catch (NumberFormatException | DoubleArithmeticException e){
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (TaskB.class.getName().equals(element.getClassName())) {
                    String name = e.getClass().getName();
                    String className = element.getClassName();
                    int line = element.getLineNumber();
                    System.out.printf("" +
                                    "name: %s \n" +
                                    "class: %s \n" +
                                    "line: %d \n",
                            name, className, line);
                    break;
                }
            }
        }
       }
}