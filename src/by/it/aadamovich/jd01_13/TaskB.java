package by.it.aadamovich.jd01_13;

import java.util.Locale;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double sum = 0;

        try {
            String inputLine;
            while (!(inputLine = sc.nextLine()).equals("END")) {
                double number = Double.parseDouble(inputLine);
                if (number < 0) throw new ArithmeticException();
                sum += number;
                double squareRoot = Math.sqrt(sum);
                System.out.printf(Locale.ENGLISH, "Number: %.3f Sum square root: %.3f\n", number, squareRoot);

            }
        } catch (NumberFormatException | ArithmeticException e) {
            StackTraceElement[] trace = e.getStackTrace();
            for (StackTraceElement element : trace) {
                if (element.getClassName().equals(TaskB.class.getName())) {
                    String name = e.getClass().getName();
                    String className = element.getClassName();
                    int line = element.getLineNumber();
                    System.out.printf("name: %s\n" +
                                    "class: %s\n" +
                                    "line: %d",
                            name, className, line);
                }
            }
        }
    }
}
