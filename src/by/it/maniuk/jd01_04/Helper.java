package by.it.maniuk.jd01_04;

public class Helper {

    static double findMin(double[] array) {
        if (0 == array.length) {
            return Integer.MIN_VALUE;
        } else {
            double min = array[0];
            for (double m : array) {
                if (min > m) min = m;
            }
            return min;
        }
    }

    static double findMax(double[] array) {
        if (0 == array.length) {
            return Integer.MAX_VALUE;
        } else {
            double max = array[0];
            for (double m : array) {
                if (max < m) max = m;
            }
            return max;
        }
    }

    static void sort(double[] array) {
        boolean swap;
        double last = array.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (array[i] > array[i + 1]) {
                    double buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        } while (swap);

    }

    static double[] sortArray(double[] array, boolean upDirection) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if ((upDirection && array[i] > array[j]) || (!upDirection && array[i] < array[j])) {
                    double m = array[i];
                    array[i] = array[j];
                    array[j] = m;

                }
            }
        }
        return array;
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] z = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < vector.length; j++)
                z[i] = z[i] + matrix[i][j] * vector[j];
        return z;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] z = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++)
                for (int k = 0; k < matrixRight.length; k++)
                    z[i][j] = z[i][j] + matrixLeft[i][k] * matrixRight[k][j];
        }
        return z;
    }

    static void arrayPrint2D(double[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf("%6.2f ", array[i][j]);
                System.out.println();
            }

        }
    }

    static void arrayPrint2D(double[][] array, String name) {
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[0].length; j++)
                System.out.printf(name + "[%1d,%1d]=%-6.1f ", i, j, array[i][j]);
        System.out.println();
    }

}
