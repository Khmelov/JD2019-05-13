package by.it.trudnitski.jd01_13;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        NumberFormat format = NumberFormat.getInstance();
        double sum = 0;
        for (; ; ) {
            String next = sc.next();
            if (next.equals("END")) break;
            list.add(next);
        }
        try {
            for (int i = 0; i < list.size(); i++) {
                String line = list.get(i);
                double numberFormat = Double.parseDouble(line);
                sum = sum + numberFormat;
                if (sum < 0)
                    throw new ArithmeticException();
                System.out.println(numberFormat + " " + sum + " " + Math.sqrt(sum));
            }
        } catch (NumberFormatException | ArithmeticException e) {
            String name = e.getClass().getName();
            String className = TaskB.class.getClass().getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (element.getClassName().equals(className)) {
                    System.out.println(element);
                }
                System.out.printf(" " +
                        "name:%s\n" +
                        "class:%s\n" +
                        "line:%s\n" +
                        "", name, className, element.getClassName());

            }
        }
    }
}
