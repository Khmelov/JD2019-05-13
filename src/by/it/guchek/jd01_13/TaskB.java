package by.it.guchek.jd01_13;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class TaskB {
    public static void main(String[] args) throws RuntimeException {

    Scanner sc = new Scanner(System.in);
    String line;
    double sum=0;
    double var=0;

        try {
            while (!(line = sc.nextLine()).equals("END")){

                var=Double.parseDouble(line);
                sum=sum+var;
                double sql=sqrt(sum);
                if (sum<0) throw new ArithmeticException(); //генерирую свое исключение
                System.out.println(var+" "+sql);
                                                   //System.out.println(sum);
            }

       } catch (ArithmeticException a) {

            StackTraceElement[] stackTrace = a.getStackTrace();

            for (StackTraceElement element : stackTrace) {

                if (TaskB.class.getName().equals(element.getClassName())) {

                    String name = a.getClass().getName(); //информация об эксепшене
                    String className = element.getClassName(); //инф о классе в котором возникла ошибка
                    int number = element.getLineNumber();

                    System.out.printf(" name: %s\n", name);
                    System.out.printf("class: %s\n", className);
                    System.out.printf(" line: %d", number);
                    break;
                }

            }
        }


        catch (RuntimeException e){

            StackTraceElement[] stackTrace = e.getStackTrace();

            for (StackTraceElement element : stackTrace) {

                if (TaskB.class.getName().equals(element.getClassName())){

                    String name = e.getClass().getName(); //информация об эксепшене
                    String className= element.getClassName(); //инф о классе в котором возникла ошибка
                    int number = element.getLineNumber();

                    System.out.printf(" name: %s\n", name);
                    System.out.printf("class: %s\n", className);
                    System.out.printf(" line: %d", number);
                    break;
                }

            }
        }


}
}
