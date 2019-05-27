package by.it.tbabich.jd01_04;

import java.util.Arrays;

public class Helper {

    /**
     * Поиск минимального значения массива
     *
     * @param arr Одномерный массив
     */
    static double findMin(double[] arr) {
        double min = arr[0];
        for (double e : arr
        ) {
            if (e < min) min = e;
        }
        return min;
    }

    /**
     * Поиск максимального значения массива
     *
     * @param arr Одномерный массив
     */
    static double findMax(double[] arr) {
        double max = arr[0];
        for (double e : arr
        ) {
            if (e > max) max = e;
        }
        return max;
    }

    /**
     * Сортировка массива в порядке возрастания
     *
     * @param arr Одномерный массив
     */
    static void sort(double[] arr) {
        Arrays.sort(arr);
    }

    /**
     * Умножение двумерного массива на вектор
     *
     * @param matrix Двумерный массив
     * @param vector Вектор
     */
    static double[] mul(double[][] matrix, double[] vector) {
        double[] resultArray = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                resultArray[i] += matrix[i][j] * vector[j];
            }
        }
        return resultArray;
    }

    /**
     * Умножение двумерного массива на двумерный массив
     *
     * @param matrixLeft Двумерный массив
     * @param matrixRight Двумерный массив
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] resultArray = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < resultArray.length; i++) {
            for (int j = 0; j < matrixLeft.length; j++) {
                for (int k = 0; k < matrixLeft[j].length; k++) {
                    resultArray[j][i] += matrixLeft[j][k] * matrixRight[k][i];
                }
            }
        }
        return resultArray;
    }
}
