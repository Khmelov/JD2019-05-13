package by.it.tbabich.jd01_02;

import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        int[][] mas;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        mas = step1(n);
        step2(mas);
        step3(mas);

    }

    static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        boolean min = false;
        boolean max = false;
        while (true) {
            min = false;
            max = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = (int) (Math.random() * (-n - 1)) + (int) (Math.random() * (n + 1));
                    if (mas[i][j] == -n) min = true;
                    if (mas[i][j] == n) max = true;
                }
            }
            if (min && max) {
                printArray(mas);
                break;
            }
        }
        return mas;
    }

    static int step2(int mas[][]) {
        int summ = 0;
        boolean flag = false;
        for (int i = 0; i < mas.length; i++) {
            flag = false;
            for (int j = 0; j < mas.length; j++) {
                if (flag && mas[i][j] <= 0) {
                    summ += mas[i][j];
                }
                if (mas[i][j] > 0 && flag == false) flag = true;
                else if (mas[i][j] > 0 && flag) break;
            }
        }
        System.out.println(summ);
        return summ;
    }

    static int[][] step3(int[][] mas) {
        int valueMax = findMaxValue(mas);

        boolean[] checkRows = new boolean[mas.length];
        boolean[] checkColumns = new boolean[mas[0].length];

        findMaxValuesInRowsAndColumns(mas, valueMax, checkRows, checkColumns);

        int newSize_i = mas.length;
        int newSize_j = mas[0].length;
        for (boolean e : checkRows) if (e) newSize_i--;
        for (boolean e : checkColumns) if (e) newSize_j--;
        int[][] resultArray = new int[newSize_i][newSize_j];

        fillingResultingArray(mas, checkRows, checkColumns, resultArray, 0, 0);
        printArray(resultArray);

        return resultArray;
    }

    private static void fillingResultingArray(int[][] mas, boolean[] checkRows, boolean[] checkColumns, int[][] resultArray, int index_i, int index_j) {
        for (int i = 0; i < mas.length; i++) {
            if (!checkRows[i]) {
                for (int j = 0; j < mas[0].length; j++) {
                    if (!checkColumns[j]) {
                        resultArray[index_i][index_j] = mas[i][j];
                        index_j++;
                    }
                }
                index_i++;
                index_j = 0;
            }
        }
    }

    private static void printArray(int[][] resultArray) {
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < resultArray[i].length; j++) {
                System.out.print(resultArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void findMaxValuesInRowsAndColumns(int[][] mas, int valueMax, boolean[] checkRows, boolean[] checkColumns) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == valueMax) {
                    checkColumns[j] = true;
                    checkRows[i] = true;
                }
            }
        }
    }

    private static int findMaxValue(int[][] mas) {
        int valueMax = mas[0][0];

        for (int[] i : mas) {
            for (int j : i) {
                if (j > valueMax) valueMax = j;
            }
        }
        return valueMax;
    }
}
