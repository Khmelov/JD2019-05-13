package by.it.tbabich.jd01_02;

import java.util.Scanner;

public class TaskA {

    private static int[] mas = new int[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            mas[i] = sc.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }

    static void step1(int[] mas) {
        int min = mas[0];
        int max = mas[0];
        for (int i : mas
        ) {
            if (i < min) min = i;
            if (i > max) max = i;
        }
        System.out.println(min + " " + max);
    }


    static void step2(int[] mas) {
        double average = 0;
        int summ = 0;
        for (int i : mas
        ) {
            summ += i;
        }
        average = summ / 10.0;
        for (int i : mas
        ) {
            if (i < average) System.out.print(i + " ");
        }
        System.out.println();
    }


    static void step3(int[] mas) {
        int min = mas[0];
        int index = 0;
        for (int i = 0; i < 10; i++){
            if (mas[i] <= min) {
                min = mas[i];
                index = i;
            }
        }
        for (int i = index; i >= 0; i--){
            if (mas[i] == min) System.out.print(i + " ");
        }
        System.out.println();
    }

}
