package by.it.buymistrov.jd01_13;

import java.util.Scanner;


public class TaskB {


    public static void main(String[] args) throws RuntimeException {
        Scanner sc = new Scanner(System.in);
        String end;
        double i = 0;
        double j = 0;
        double sq = 0;

        while (!(end = sc.nextLine()).equals("END")) {
            try {
                i = Double.parseDouble(end);

                j += i;
                System.out.println("Сумма  " + j);


                sq = Math.sqrt(j);

                if (Double.isNaN(sq)) {
                    throw new ArithmeticException();
                }


                System.out.println("Корень последнего  " + sq);
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

