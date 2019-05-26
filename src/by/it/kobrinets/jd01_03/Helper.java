package by.it.kobrinets.jd01_03;

public class Helper {
    static double findMax(double[] arr) {
        if (0 == arr.length) {
            return Double.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double m : arr) {
                if (max < m) max = m;
            }
            return max;
        }
    }

    static double findMin(double[] arr) {
        if (0 == arr.length) {
            return Double.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double m : arr) {
                if (min > m) min = m;
            }
            return min;
        }
    }
    static void sort(double [] arr){
        boolean isSorted;
        int last = arr.length -1;
        do {
            isSorted = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                        double buffer = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = buffer;
                        isSorted = true;
                }

            }
            last--;
        }
        while (isSorted);
        printMas(arr);

    }

    private static void printMas(double[] massive){
        for (double m : massive) {
            System.out.print(m + " ");
            System.out.println();
        }
    }

    public static double[] mul(double[][] matrix, double[] vector){
        double[] z = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < vector.length; j++)
                z[i] = z[i] + matrix[i][j] * vector[j];
                return z;
    }
    public static double[][] mul(double[][] matrixLeft, double[][] matrixRight){
        double[][] z = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixRight[0].length; j++)
                for (int k = 0; k < matrixRight.length; k++)
                    z[i][j] = z[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                return z;
    }
}
