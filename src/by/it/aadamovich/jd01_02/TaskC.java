package by.it.aadamovich.jd01_02;

import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int[][] mas = step1(sc.nextInt());
        System.out.println(step2(mas) + "\n");
        step3(mas);


    }

    private static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        boolean nPresent, nMinusPresent;

        do {
            nPresent = false;
            nMinusPresent = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = (int) (Math.random() * (n + n + 1)) - n;
                    System.out.print(mas[i][j] + " ");
                    if (mas[i][j] == n) nPresent = true;
                    if (mas[i][j] == -n) nMinusPresent = true;
                    if (j == n - 1) System.out.println();
                }
            }
        } while (!nPresent || !nMinusPresent);
        System.out.println();
        return mas;
    }

    private static int step2(int[][] mas) {

        int sum = 0;
        for (int[] elem : mas) {
            search:
            for (int j = 0; j < elem.length - 2; j++) {
                if (elem[j] >= 0) {
                    for (int k = j + 1; k < elem.length; k++) {
                        if (elem[k] >= 0) {
                            for (int l = j + 1; l < k; l++) {
                                sum = sum + elem[l];
                            }
                            break search;
                        }
                    }
                    break;
                }
            }
        }

        return sum;
    }

    private static int[][] step3(int[][] mas) {

        // Maximum search
        int max = mas[0][0];
        for (int[] innerMas : mas) {
            for (int element : innerMas) {
                if (element > max) max = element;
            }
        }

        // Number of lines to be deleted calculation
        int countLine = 0;
        for (int[] innerMas : mas) {
            for (int element : innerMas) {
                if (element == max) {
                    countLine = countLine + 1;
                    break;
                }
            }
        }

        // Number of columns to be deleted calculation
        int countColumn = 0;
        for (int j = 0; j < mas[0].length; j++) {
            for (int[] elem : mas) {
                if (elem[j] == max) {
                    countColumn = countColumn + 1;
                    break;
                }
            }
        }

        // Array with lines indexes to be deleted
        int[] line = new int[countLine];
        int indexLine = countLine - 1;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                if (mas[i][j] == max) {
                    line[indexLine] = i;
                    indexLine = indexLine - 1;
                    break;
                }
            }
        }

        // Array with column's indexes to be deleted
        int[] column = new int[countColumn];
        int indexColumn = countColumn - 1;
        for (int j = 0; j < mas[0].length; j++) {
            for (int[] elem : mas) {
                if (elem[j] == max) {
                    column[indexColumn] = j;
                    indexColumn = indexColumn - 1;
                    break;
                }
            }
        }

        int[][] masDeleted = new int[mas.length - countLine][mas.length - countColumn];
        int lineIndex = 0;
        checkLine:
        for (int i = 0; i < mas.length; i++) {
            int columnIndex = 0;
            for (int elementLine : line) {
                if (elementLine == i) continue checkLine;
            }
            checkColumn:
            for (int j = 0; j < mas.length; j++) {
                for (int elementColumn : column) {
                    if (elementColumn == j) continue checkColumn;
                }
                masDeleted[lineIndex][columnIndex] = mas[i][j];
                columnIndex = columnIndex + 1;
                if (columnIndex == masDeleted[0].length) {
                    lineIndex = lineIndex + 1;
                    continue checkLine;
                }
            }
        }


        for (
                int[] ints : masDeleted) {
            for (int j = 0; j < masDeleted.length; j++) {
                System.out.print(ints[j] + " ");
                if (j == (masDeleted.length - 1)) System.out.println();
            }
        }
        return masDeleted;
    }
}





