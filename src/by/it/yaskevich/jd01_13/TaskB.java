package by.it.yaskevich.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        double sumNumbers = 0;
        Scanner scanner = new Scanner(System.in);
        String rawData;
        while (!"END".equals(rawData = scanner.nextLine())) {
            try {
                double number = Double.parseDouble(rawData);
                sumNumbers += number;
                double sqrtNumber = Math.sqrt(sumNumbers);
                if (Double.isNaN(sqrtNumber)) {
                    throw new ArithmeticException();
                }
                System.out.printf("Number: %f Sum: %f\n", number, sqrtNumber);
            }
            catch (NumberFormatException | ArithmeticException e) {
                printException(e);
            }
        }
    }

    private static void printException(RuntimeException e) {
        System.out.printf(" name: %s\n", e.getClass().getName());
        System.out.printf("class: %s\n", TaskB.class.getName());
        StackTraceElement[] stackTrace = e.getStackTrace();
        for (StackTraceElement element : stackTrace) {
            if (element.getClassName().equals(TaskB.class.getName())) {
                System.out.printf(" line: %d\n", element.getLineNumber());
                break;
            }
        }
    }
}
