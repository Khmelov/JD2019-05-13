package by.it.yakovets.jd01_04;

import java.util.Scanner;

class TaskB {
    public static void main(String[] args) {
        double avg;
        int itogo = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите n");
        int n = sc.nextInt();
        String[] mas = new String[n];
        // System.out.println("Введите " + n + " фамилии");
        int[][] zp = new int[n][4];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = sc.next();
        }
        for (int i = 0; i < mas.length; i++) {
            System.out.println("Введите зарплату для " + mas[i]);
            for (int j = 0; j < 4; j++) {
                zp[i][j] = sc.nextInt();

            }
        }
        for (int i = 0; i < 54; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("%-9s%-10s%-10s%-10s%-10s%-5s", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println();
        for (int i = 0; i < 54; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            int[] itog = new int[n];
            System.out.printf("%7s: ", mas[i]);
            for (int j = 0; j < 4; j++) {
                itog[i] = itog[i] + zp[i][j];

                System.out.printf("%-10d", zp[i][j]);
            }

            itogo = itogo + itog[i];
            System.out.printf("%-5d", itog[i]);
            System.out.println();
        }
        for (int i = 0; i < 54; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.print("Итого    " + itogo);
        System.out.println();
        avg = (double) itogo / (n * 4);
        System.out.printf("%-9s%8.6f", "Средняя", avg);
    }
}