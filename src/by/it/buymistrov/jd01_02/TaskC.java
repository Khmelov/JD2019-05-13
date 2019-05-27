package by.it.buymistrov.jd01_02;

import java.util.Scanner;

public class TaskC {

    private static boolean check(int[][] mas, int n) {
        boolean max = false;
        boolean min = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (mas[i][j] == n)
                    max = true;
                if (mas[i][j] == -n)
                    min = true;

            }
        }

        return max && min;

    }

    private static int[][] step1(int n) {
        int[][] mas = new int[n][n];

        while (!check(mas, n)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = (int) Math.round((Math.random() * n * 2) - n);
                }
            }
        }


        printmas(mas);

        System.out.println();
        return mas;
    }

    private static void printmas(int[][] mas) {

        for (int[] ma : mas) {
            System.out.println();
            for (int i : ma) {

                String numberAsString = String.valueOf(i);
                String paddedNumberAsString = "   ".substring(numberAsString.length()) + numberAsString;
                System.out.print(paddedNumberAsString);


            }
        }
        System.out.println();
    }

    private static int step2(int[][] mas) {
        int sum = 0;
        for (int[] ma : mas) {
            int y = -1;
            int y2 = -1;

            for (int j = 0; j < ma.length; j++) {


                if (ma[j] >= 0 && y != -1 && y2 == -1)
                    y2 = j;
                if (ma[j] >= 0 && y == -1)
                    y = j;


            }

            if (y == -1 || y2 == -1)
                continue;
            for (int q = y + 1; q < y2; q++)
                sum += ma[q];
        }

        return sum;


    }

    private static int[][] step3(int[][] mas) {
        int n = mas.length;
        printmas(mas);
        int max = 0;
        int[] coordi = new int[n * n];
        int[] coordj = new int[n * n];
        int coordLen = 0;
        for (int[] ma : mas) {
            for (int j = 0; j < n; j++) {
                if (ma[j] > max)
                    max = ma[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mas[i][j] == max) {
                    coordi[coordLen] = i;
                    coordj[coordLen] = j;
                    coordLen++;
                }
            }
        }


        int[][] mask = new int[n][n];

        for (int i = 0; i < coordLen; i++) {
            int pointx = coordi[i];
            int pointy = coordj[i];
            for (int j = 0; j < n; j++) {
                mask[pointx][j] = 1;

            }
            for (int j = 0; j < n; j++) {
                mask[j][pointy] = 1;

            }

        }

        int[][] mas2 = new int[n][n];
        int x;
        int y = 0;
        int maxX = 0;
        for (int i = 0; i < n; i++) {
            x = 0;
            for (int j = 0; j < n; j++) {

                if (mask[i][j] == 0) {
                    mas2[y][x] = mas[i][j];
                    x++;
                }
            }
            if (x > 0)
                y++;

            if (maxX < x)
                maxX = x;
        }

        int[][] masOut = new int[y][maxX];
        for (int i = 0; i < y; i++) {
            System.arraycopy(mas2[i], 0, masOut[i], 0, maxX);

        }

        printmas(masOut);


        return masOut;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] mas = step1(n);
        System.out.println(step2(mas));
        step3(mas);

    }
}
