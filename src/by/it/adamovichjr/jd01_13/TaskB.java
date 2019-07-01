package by.it.adamovichjr.jd01_13;

import java.util.Locale;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        try {
            String line;
            while (!(line = scanner.nextLine()).equals("END")) {
                double number = Double.parseDouble(line);
                if (number < 0) throw new ArithmeticException();
                sum += number;
                double sqrtNumber = Math.sqrt(number);
                double sqrtSum = Math.sqrt(sum);
                System.out.printf(Locale.ENGLISH,"Корень числа: %f\n" + "Корень суммы: %f\n",sqrtNumber, sqrtSum);
            }
        } catch (Exception e) {
            StackTraceElement[] stacktrace = e.getStackTrace();
            for (StackTraceElement element : stacktrace) {
                if (TaskB.class.getName().equals(element.getClassName())) {
                    String name = e.getClass().getName();
                    String clname = element.getClassName();
                    int number = element.getLineNumber();
                    System.out.printf(
                            " name: %s\n class: %s\n line: %d\n",
                            name, clname, number);
                    break;
                }
            }
        }

    }
}

