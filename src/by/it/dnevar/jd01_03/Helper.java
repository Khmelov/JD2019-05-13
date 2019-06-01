/**
 * @param arr входной массив
 * @return возвращает минимальное значение в массиве
 */

package by.it.dnevar.jd01_03;

public class Helper {


    public static double findMin(double[ ] arr){
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min>arr[i]){
                min=arr[i];
            }
        }
        return min;
    }

    public static double findMax(double[ ] arr){
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }

    public static void sort(double[] arr){
        boolean swap;
        int last = arr.length-1;

        do{
            swap = false;
            for (int i = 0; i < last; i++) {
                if(arr[i]>arr[i+1]){
                    double buffer = arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=buffer;
                    swap = true;
                }
            }
            last--;
        } while (swap);

    }

    public static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i]=result[i]+matrix[i][j]*vector[j];
            }
            
        }
        return result;
    }

    public static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] result = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j]=result[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }

        return result;
    }

}
