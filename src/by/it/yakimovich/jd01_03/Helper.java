package by.it.yakimovich.jd01_03;



import java.util.Arrays;

public class Helper {
   public static double findMin(double[] arr) {
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


   public  static void sort(double[] arr) {
        Arrays.sort(arr);
    }


    static  double[] mul(double[][] matrix, double[] vector) {


        double[] mul = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                mul[i] = mul[i] + matrix[i][j] * vector[j];
            }


        }
        return mul;
    }

    static double[][] mul( double[][] matrixLeft,  double[][] matrixRight) {
        double[][] mul = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixRight[0].length; j++)
                for (int k = 0; k < matrixRight.length; k++)
                    mul[i][j] = mul[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                       return mul;
}


}









