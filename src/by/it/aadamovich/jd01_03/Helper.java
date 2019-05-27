package by.it.aadamovich.jd01_03;

import java.util.Scanner;

class Helper {
    static double findMin(double[] arr) {
        double min = arr[0];
        for (double element : arr) {
            if (min > element) min = element;
        }
        return min;
    }

    static double findMax(double[] arr) {
        double max = arr[0];
        for (double element : arr) {
            if (max < element) max = element;
        }
        return max;
    }

    static void sort(double[] arr) {
        int lastElement = arr.length - 1;
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i < lastElement; i++) {
                if (arr[i] > arr[i + 1]) {
                    double buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                    swap = true;
                }
            }
            lastElement--;
        } while (swap);
    }

    static double[][] createMatrix(int equal, int nonEqual, boolean m, int lowLimit, int upLimit) {
        double[][] matrix;
        if (m) {
            matrix = new double[nonEqual][equal];
        } else {
            matrix = new double[equal][nonEqual];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (Math.random() * (upLimit - lowLimit + 1)) + lowLimit;
            }
        }
        return matrix;
    }

    static double[] createVector(int equal) {
        Scanner sc = new Scanner(System.in);
        double[] vector = new double[equal];
        for (int i = 0; i < equal; i++) {
            System.out.println("Введите значение " + i + " для вектора v:");
            vector[i] = sc.nextDouble();
        }
        return vector;
    }


    static double[] mul(double[][] matrix, double[] vector) {
        double[] resultVector = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                resultVector[i] = resultVector[i] + (matrix[i][j] * vector[j]);
            }
        }
        return resultVector;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] resultMatrix = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    resultMatrix[i][j] = resultMatrix[i][j] + (matrixLeft[i][k] * matrixRight[k][j]);
                }
            }
        }
        return resultMatrix;
    }
}
