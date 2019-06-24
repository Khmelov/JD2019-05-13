package by.it.buymistrov.jd01_13;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) throws RuntimeException {
        Scanner sc = new Scanner(System.in);
        String end;
        double parse;
        double sum = 0;
        double sqrt;
        while (!(end = sc.nextLine()).equals("END")) {
            try {
                parse = Double.parseDouble(end);
                sum += parse;
                System.out.println("Сумма  " + sum);
                sqrt = Math.sqrt(sum);
                if (Double.isNaN(sqrt)) {
                    throw new ArithmeticException();
                }
                System.out.println("Корень последнего  " + sqrt);
            } catch (NumberFormatException | ArithmeticException e) {
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

