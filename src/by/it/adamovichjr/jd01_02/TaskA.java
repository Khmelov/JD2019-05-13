package by.it.adamovichjr.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] massiv = new int[10];
        for (int i = 0; i < massiv.length; i++) {
            massiv[i] = scanner.nextInt();
        }
        step1(massiv);
        step2(massiv);
        step3(massiv);
    }

    static void step1(int[] mas) {
        int min = mas[0];
        int max = mas[0];
        for (int i = 1; i < mas.length; i++) {
            if(mas[i] > max) {max = mas[i];}
            if(mas[i] < min) {min = mas[i];}
        }
        System.out.println(min + " " + max);
    }
    static void step2(int[] mas){
        double sum = 0;
        for (int i = 0; i < mas.length; i++) {
            sum += mas[i];
        }
        double average = sum / mas.length;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < average)
                System.out.print(mas[i] + " ");
        }
        System.out.println();
    }
    static void step3(int[] mas){
        int min = mas[0];
        for (int i = 1; i < mas.length; i++) {
            if(mas[i] < min) {min = mas[i];}
        }
        for (int i = mas.length - 1; i >= 0; i--) {
            if(mas[i] == min)
                System.out.print(i + " ");
        }

    }
}
