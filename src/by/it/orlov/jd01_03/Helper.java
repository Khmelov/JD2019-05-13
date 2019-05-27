package by.it.orlov.jd01_03;

public class Helper {
    static double findMin(double[ ] arr){
            double result = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]<result){
                    result=arr[i];
                }
            }
            return result;
    }
    static double findMax(double[ ] arr){
        double result = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>result){
                result=arr[i];
            }
        }
        return result;
    }
    static void sort(double[] arr) {
        for (double elment : arr) {
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i] > arr[(i + 1)]) {
                    double buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                }
            }
        }
        for (double element:arr) {
            System.out.print(element + (" "));
        }

    }
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i] = result[i] + matrix[i][j] * vector[j];
            }
        }
        return result;
    }
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] result = new double[matrixLeft.length][matrixRight[0].length];
        for (int i=0; i<matrixLeft.length; ++i)
            for (int j=0; j<matrixRight[0].length; ++j)
                for (int k=0; k<matrixLeft[0].length; ++k)
                    result[i][j] += matrixLeft[i][k] * matrixRight[k][j];
            return result;
    }
}