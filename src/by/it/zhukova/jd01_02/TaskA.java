package by.it.zhukova.jd01_02;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        int[] mas = new int[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scanner.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
        
    }

    private static void step1(int[] mas) {
        int max = mas[0];
        int min = mas[0];
               for (int i = 0; i < mas.length; i++) {
            if (max < mas[i]) max = mas[i];
            if (min > mas[i]) min = mas[i];}
        System.out.print(min + " ");
        System.out.println(max);
    }
    private static void step2(int[] mas) {
       double sum = 0;

        for (int i = 0; i < mas.length; i++) {
           sum = sum + mas[i];}
        sum = sum / (mas.length-1);
        for (int i = 0; i < mas.length; i++) {
           if (mas[i] < sum )
               System.out.print(mas[i] + " ");
        }

        System.out.println();
    }
    private static void step3(int[] mas) {
        int min = mas[0];
        for (int i = 0; i < mas.length; i++) {
             if (min > mas[i]) min = mas[i];}

        for (int i = mas.length-1; i >=0; i--) {
            if (mas[i] == min )
                System.out.print(i + " ");
        }

        System.out.println();
    }
    }



