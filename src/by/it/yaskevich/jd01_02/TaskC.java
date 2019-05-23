package by.it.yaskevich.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] mas = step1(n);
        step2(mas);
        step3(mas);
    }

    private static int[][] step3(int[][] mas) {

        int max = getMax(mas);

        // mark rows and cols for deleting
        int row = 0;
        int col = 0;
        boolean[] rows = new boolean[mas.length];
        boolean[] cols = new boolean[mas[0].length];

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (max == mas[i][j]) {
                    if (!rows[i]) {
                        row++;
                        rows[i] = true;
                    }
                    if (!cols[j]) {
                        col++;
                        cols[j] = true;
                    }
                }
            }
        }

        // create a new array and copy the necessary from the old
        if ((row == mas.length) || (col == mas[0].length)) {
            return null;
        } else {
            int[][] res = new int[mas.length - row][mas[0].length - col];

            int k = 0, m = 0;
            for (int i = 0; i < mas.length; i++) {
                if (!rows[i]) {
                    for (int j = 0; j < mas[i].length; j++) {
                        if (!cols[j]) {
                            res[k][m] = mas[i][j];
                            m++;
                        }
                    }
                    m = 0;
                    k++;
                }
            }

            printArray2D(res);

            return res;
        }

    }

    private static int getMax(int[][] mas) {
        int max = Integer.MIN_VALUE;
        for (int[] ma : mas)
            for (int aMa : ma)
                if (max < aMa)
                    max = aMa;
        return max;
    }

    private static int step2(int[][] mas) {
        int sum = 0;
        for (int[] ma : mas) {
            boolean first = false;
            for (int aMa : ma) {
                if (first) {
                    if (aMa < 0) {
                        sum += aMa;
                    }
                    if (aMa > 0) {
                        first = false;
                        break;
                    }
                } else if (aMa > 0) {
                    first = true;
                }
            }
        }

        System.out.println(sum);

        return sum;
    }

    private static int[][] step1(int n) {
        int[][] mas = new int[n][n];

        Random random = new Random();


        while (true) {
            boolean min = false, max = false;
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas[i].length; j++) {
                    mas[i][j] = -n + random.nextInt(n + n + 1);
                    if (!min && (mas[i][j] == -n))
                        min = true;
                    if (!max && (mas[i][j] == n))
                        max = true;
                }
            }
            if (min && max)
                break;
        }

        printArray2D(mas);

        return mas;
    }

    private static void printArray2D(int[][] mas) {
        for (int[] ma : mas) {
            for (int aMa : ma) {
                System.out.print(aMa + " ");
            }
            System.out.println();
        }
    }
}
