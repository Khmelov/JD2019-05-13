package by.it.adamovichjr.jd01_03;

public class Helper {
    static double findMin(double[]arr){
        double min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < min)
                min = arr[i];
        }
        return min;
    }
    static double findMax(double[]arr){
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }
    public static void sort(double[]arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if(arr[j] > arr[j+1]){
                    double buf = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = buf;
                }
            }
        }
    }
    static double[]mul (double[][]matrix, double[]vector){
        double[] fin = new double[matrix.length];
        if(matrix[0].length == vector.length){
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < vector.length; j++) {
                    fin[i] += matrix[i][j]*vector[j];
                }
            }
        }
        return fin;
    }
    static double[][]mul (double[][]matrixLeft, double[][]matrixRight){
        double[][]fin = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    fin[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return fin;
    }
}
