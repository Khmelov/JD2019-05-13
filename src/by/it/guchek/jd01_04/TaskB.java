package by.it.guchek.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] surn = new String[n];
        for (int i = 0; i < surn.length; i++) //Заполняем массив вводом фамилий с клавиатуры через пробел
            surn[i] = sc.next();

        int[][] zp = new int[n][4];
        int[] sumzp = new int[n];
        int s = 0, s1 = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + surn[i]);
            for (int j = 0; j < 4; j++) {
                zp[i][j] = sc.nextInt();

            }
        }


        for (int i1 = 0; i1 < n; i1++) {
            if (i1 == 0) {
                System.out.printf("     %-12s%-9s%-15s%-14s%-14s%-15s%n",
                        "Фамилия", "Квартал 1", "Квартал 2", "Квартал 3", "Квартал 4", "Итого");
                System.out.println("-------------------------------------------------------------------");
            }
            System.out.printf("%12s: ", surn[i1]);
            s = 0;
            s1 = 0;
            for (int j1 = 0; j1 < 4; j1++) {
                s = zp[i1][j1];
                s1 = s1 + s;
                System.out.printf("   %-10d ", zp[i1][j1]);
                sumzp[i1] = s1;
            }
            System.out.println(s1);
        }
        int itogo = 0;
        for (int elem : sumzp) {
            itogo = elem + itogo;
        }
        double sredn;
        sredn = (double) ((double) itogo / (4 * n));
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-10s%-10d%n", "Итого", itogo);
        System.out.printf("%-10s%-10.4f", "Средняя", sredn);


    }

}
