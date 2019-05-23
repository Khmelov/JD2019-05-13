package by.it.yaskevich.jd01_04;

class Helper {
    static double findMin(double[] array) {
        if (array.length == 0)
            return Double.MIN_VALUE;
        else {
            double min = array[0];
            for (double item : array) {
                if (item < min)
                    min = item;
            }
            return min;
        }
    }

    static double findMax(double[] array) {
        if (array.length == 0)
            return Double.MAX_VALUE;
        else {
            double max = array[0];
            for (double item : array) {
                if (item > max)
                    max = item;
            }
            return max;
        }
    }

    static void sort(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    double temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }

        }
    }

    /**
     * Перемножаем матрицу на вектор и получаем вектор
     * @author I...
     * @version 1.0
     * @param matrix входная матрица
     * @param vector входной вектор
     * @return на выходе получаем вектор
     */
    static double[] mul(double[][] matrix, double[] vector) {
        double[] temp = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                temp[i] += matrix[i][j] * vector[j];
            }
        }

        return temp;
    }

    /**
     * Перемножаем матрицу на матрицу и получаем матрицу
     * @param matrixLeft входная матрица
     * @param matrixRight входная матрица
     * @return на выходе получаем матрицу
     * @version 1.0
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] temp = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int m = 0; m < matrixRight[0].length; m++) {
                for (int n = 0; n < matrixRight.length; n++) {
                    temp[i][m] += matrixLeft[i][n] * matrixRight[n][m];
                }
            }
        }
        return temp;
    }
}
