package by.it.zhukova.jd01_13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class TaskB {
      public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> enter = new ArrayList<>();
        for (; ; ) {
            String str = scanner.nextLine();
            if (str.equals("END")) break;
            enter.add(str);
        }
        //создание суммы
        double add = 0;
        Iterator<String> iterator = enter.iterator();
        while (iterator.hasNext()) {
            try {
                double aDouble = Double.parseDouble(iterator.next());
                System.out.printf(Locale.ENGLISH, "%.3f\n", aDouble);
               add += aDouble;
               if (add < 0) {throw new ArithmeticException();}
                double sqr = Math.sqrt(add);
                System.out.printf(Locale.ENGLISH, "%.3f\n", sqr);

            } catch (ArithmeticException | NumberFormatException e) {
                String name = e.getClass().getName();
                String className = TaskB.class.getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (element.getClassName().equals(className)) {
                        System.out.printf("name: %s\n" +
                                "class: %s\n" +
                                "line: %d\n", name, className, element.getLineNumber());
                        break;
                    }
                }
            }
        }
    }
}


