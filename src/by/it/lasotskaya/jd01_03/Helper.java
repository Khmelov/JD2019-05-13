package by.it.lasotskaya.jd01_03;
import java.util.Arrays;
/** Class contains realization of methods: findMin(arr), findMax(arr), sort(arr)
 */
class Helper {
    /**
     * Method to find minimum element of the array,
     *
     * @param arr is one-dimensional array
     * @return minimum element
     */
    static double findMin(double[] arr) {
        double min = arr[0];
        for (double element : arr) {
            if (min > element) {
                min = element;
            }
        }
        return min;
    }

    /**
     * Method to find maximum element of the array
     *
     * @param arr is one-dimensional array
     * @return minimum element
     */
    static double findMax(double[] arr) {
        double max = arr[0];
        for (double element : arr) {
            if (max < element) {
                max = element;
            }
        }
        return max;
    }

    /**
     * Method to sort elements in array
     *
     * @param arr is one-dimensional array
     *            sorted array
     */
    static void sort(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Arrays.sort(arr);
        }
        for (double element : arr) {
            System.out.print(element + "  ");
        }
    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] mas = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                mas[i] += matrix[i][j] * vector[j];
                System.out.print(mas[i] + " ");
            }
        }
        System.out.println();
        return mas;

    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] mas = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    mas[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                    System.out.print(mas[i][j] + " ");}}
                }
return mas;

            }
        }



