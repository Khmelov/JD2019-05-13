package by.it.maniuk.jd01_02;

import java.util.Scanner;

public class TaskC {
    static int[][] matrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        step1(i);
        step2(matrix);
        step3(matrix);

    }

    private static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        boolean flag = false;
        while (! flag) {
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas.length; j++) {
                    //Min + (int)(Math.random() * ((Max - Min) + 1))
                    mas[i][j] = - n + (int) (Math.random() * ((n - (- n)) + 1));
                }

            }
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas.length; j++) {
                    if (mas[i][j] == n || mas[i][j] == - n) flag = true;
                }
            }
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                System.out.print(mas[i][j] + "\t");
            }
        }
        matrix = mas;
        return mas;
    }

    private static int step2(int[][] mas) {

//       int[][] mas = {
//                {3, -5, -5, 5},
//                {3, 4, 7, 6},
//                {5, 8, 8, 9},
//                {1, 8, 9, 1}
//        };
        int rowSum = 0;

        for (int i = 0; i < mas.length; i++) {

            int firsSighn = 0;
            int secondSight = 0;

            for (int k = 0; k < mas[i].length; k++) {
                if ((mas[i][k] > 0) && (k < mas[i].length - 1)) {
                    firsSighn = k;
                    break;

                }
            }
            for (int j = firsSighn + 1; j < mas[i].length; j++) {
                if ((mas[i][j] > 0) && (j < mas[i].length)) {
                    secondSight = j;
                    break;
                }
            }


            for (int l = firsSighn + 1; l < secondSight; l++) {
                rowSum = rowSum + mas[i][l];
            }

        }


        System.out.print(rowSum + "\t");
        return rowSum;
    }

    private static int[][] step3(int[][] mass) {
        int[][] mas = {
                {3, - 5, - 5, 5},
                {3, 4, 99, 6},
                {99, 8, 8, 9},
                {1, 8, 9, 1}
        };
        int max = mas[0][0];
        int[][] mas2 = new int[mas.length][mas[0].length]; //НЕ ЗАБЫТЬ ПОМЕНЯТЬ!!

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] > max) max = mas[i][j];
            }
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == max) {
                    mas2[i][j] = mas[i][j];
                }
            }
        }
//        int[][] mas2 = {
//                {0, 0, 0, 0},
//                {0, 0, 99,0},
//                {99,0, 0, 0},
//                {0, 0, 0, 0}
//        };
        int row = mas2.length;
        int stolb = mas2[0].length;
        for (int q = 0; q < mas2.length; q++) {
            for (int j = 0; j < mas2[q].length; j++) {
                if (mas2[q][j] > 0) {
                    row--;
                }
            }
        }
        for (int w = 0; w < mas2.length; w++) {
            for (int j = 0; j < mas2[w].length; j++) {
                if (mas2[w][j] > 0) {
                    stolb--;
                }
            }
        }
        int[][] mas3 = new int[row][stolb];
        boolean[][] mas4 = new boolean[mas.length][mas[0].length];
        for (int g = 0; g < mas2.length; g++) {
            for (int h = 0; h < mas2[g].length; h++) {
                if (mas2[g][h] > 0)
                    mas4[g][h] = true;
                else mas4[g][h] = false;
            }
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                if (mas4[i][j]) {
                    for (int i1 = j; i1 < mas.length; i1++) {
                    mas2[i][i1] = mas[i][i1=1];


                    }
                }


            }
        }


        return mas;
    }
}



