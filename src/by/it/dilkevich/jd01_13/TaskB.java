package by.it.dilkevich.jd01_13;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String word = null;
        int sum = 0;
        double input = 0;

        try {

            while (!((word = scanner.nextLine()).equals("END"))) {

                input = Double.parseDouble(word);
                sum += input;
                if (sum < 0)
                    throw new ArithmeticException();
                System.out.println(input + " " + Math.sqrt((double) sum));

            }
        }
        catch (ArithmeticException | NumberFormatException e) {

            StringBuilder sb = new StringBuilder();
            sb.append("  name: ").append(e.getClass());
            sb.append("\n class: ").append(TaskB.class.getName());

            StackTraceElement[] stackTrace = e.getStackTrace();
            for (int i = 0; i < stackTrace.length; i++) {

                if (stackTrace[i].getClassName().equals(TaskB.class.getName())) {

                    sb.append("\n  line:").append(i + 1);

                }
            }
            System.out.println(sb);
        }

    }
}
