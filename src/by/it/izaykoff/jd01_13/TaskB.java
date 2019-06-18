package by.it.izaykoff.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String enter;
        double sum = 0;

        while (!(enter = scan.nextLine()).equals("END")) {
            try {
                double number = Double.parseDouble(enter);
                sum += number;
                System.out.println(number);
                if (sum <= 0)
                    throw new ArithmeticException();

                System.out.println(Math.sqrt(sum));

            } catch (ArithmeticException | NumberFormatException | NullPointerException e) {
                String name = e.getClass().getName();
                String className = TaskB.class.getName();
                StackTraceElement[] stackTrace = e.getStackTrace();

                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement.getClassName().equals(className)) {
                        System.out.printf("" + " name: %s\n" +
                                "class: %s\n" +
                                " line: %d\n" +
                                "", name, className, stackTraceElement.getLineNumber());
                        break;
                    }
                }
            }
        }

    }
}
