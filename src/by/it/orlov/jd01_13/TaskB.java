package by.it.orlov.jd01_13;



import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string;
        double sum = 0;
        while (! (string = scanner.nextLine()).equals("END")) {
            try {
                double a = Double.parseDouble(string);

                double sqr;
                if ( a > 0){
                    sum = sum + a;
                    sqr = Math.sqrt(sum);}
                else throw new ArithmeticException();

                    System.out.println(a + ": " + Math.floor(sqr*100)/100);

            } catch (NumberFormatException | ArithmeticException e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {

                        String name = e.getClass().getName();
                        String sec_name = element.getClassName();
                        int number = element.getLineNumber();

                        System.out.printf(
                                " name: %string\n" + "class: %string\n" + " line: %d\n", name, sec_name, number);
                        break;
                    }
                }
            }
        }
    }
}