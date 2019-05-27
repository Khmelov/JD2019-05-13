package by.it.maniuk.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должна появится в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
class TaskC1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] a = new int[2];
        for (int i = 0 ; i < 2; i++ ){
            a[i] = scanner.nextInt();
        }
      //  System.out.println(a[0]);
      //  System.out.println(a[1]);
       // System.out.println(a[2]);
        System.out.println("Sum = "+ (a[0]+a[1]));

    }

}
