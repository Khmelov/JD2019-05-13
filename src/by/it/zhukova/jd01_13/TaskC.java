package by.it.zhukova.jd01_13;

import java.lang.reflect.Field;
import java.util.*;

public class TaskC {

    public static void main(String[] args) {
       readData();
           }
    static void readData () { // Код по чтению чисел с клавиатуры
        LinkedList<Double> numbers = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int col=0;
        for (; ; ) {
            String str = scanner.nextLine();
            try {
                Double number = Double.parseDouble(str);
                numbers.addFirst(number);
                Thread.sleep(100);
            } catch (InterruptedException | NumberFormatException e) {
                Iterator<Double> iterator = numbers.iterator();
                while (iterator.hasNext()) {
                    System.out.printf(Locale.ENGLISH,"%.1f ", iterator.next());
                }
                System.out.println();
                col++;
                if (col==5) throw new InputMismatchException();

            }
        }
    }
}
