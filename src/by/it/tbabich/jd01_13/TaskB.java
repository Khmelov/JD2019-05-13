package by.it.tbabich.jd01_13;

import java.util.Locale;
import java.util.Scanner;

class TaskB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double result = 0;
        try {
            String line;
            while (!(line = sc.nextLine()).equals("END")) {
                double value = Double.parseDouble(line);
                if (value < 0) throw new ArithmeticException();
                result = result + value;
                System.out.printf(Locale.ENGLISH, "Number: %.3f Summa square root: %.3f\n", value, Math.sqrt(result));
            }
        } catch (NumberFormatException | ArithmeticException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (element.getClassName().equals(TaskB.class.getName())) {
                    System.out.printf("name: %s\n"
                            + "class: %s\n"
                            + "line: %d", e.getClass().getName(), element.getClassName(), element.getLineNumber());
                }
            }
        }
    }
}
