package by.it.izaykoff.jd01_03;

 public class Helper {

   static double findMin(double[] arr){
        if (0 == arr.length){
            return  Double.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double element : arr) {
                if (min > element)
                    min = element;
            }
            return min;
        }

    }
   static double findMax(double[] arr){
        if (0 == arr.length){
            return  Double.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double element : arr) {
                if (max < element)
                    max = element;
            }
            return max;
        }

    }
   public static void sort(double[ ] arr){
        boolean swap;
        int last = arr.length -1;
        do {
            swap = false;
            for (int i = 0; i < last; i++){
                if (arr[i] > arr[i+1]){
                    double buffer = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1]  = buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
    }
   static double[] mul(double[][] matrix, double[] vector){
        double[] sum = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                sum[i] = sum[i] + matrix[i][j] * vector[j];
            }
        }
        return  sum;
    }
   static double[][] mul(double[][] matrixLeft, double[][] matrixRight){
        double[][] sum = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    sum[i][j] = sum[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return sum;
    }

}
