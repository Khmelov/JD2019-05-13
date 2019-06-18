package by.it.maniuk.jd01_13;



import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        double sum = 0;
        while (! (s = scanner.nextLine()).equals("END")) {
            try {
                double a = Double.parseDouble(s);

                double sqrt;
                if ( a > 0){
                    sum = sum + a;
                    sqrt = Math.sqrt(sum);}
                else throw new ArithmeticException();

                    System.out.println(a + ": " + Math.floor(sqrt*100)/100);

            } catch (NumberFormatException | ArithmeticException e) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {

                        String name = e.getClass().getName();
                        String cname = element.getClassName();
                        int number = element.getLineNumber();


                        System.out.printf(
                                " name: %s\n" +
                                "class: %s\n" +
                                " line: %d\n"
                                 , name, cname, number);
                        break;
                    }
                }
            }
        }
    }
}