package by.it.gavrilovec.jd01_03;

import java.util.Arrays;
/**@author me)))*/
class Helper {
    /**
     *
     * @param arr исходный массив
     * @return минимальный элемент массива
     */
    static double findMin(double[ ] arr){
        if(arr.length==0) return Double.MIN_VALUE;
        else{
            double min=arr[0];
            for(double element:arr){
                if(element<min) min=element;
            }
            return min;
        }
    }

    /**
     *
     * @param arr исходный массив
     * @return максимальный элемент массива
     */
    static double findMax(double[ ] arr){
        if(arr.length==0) return Double.MAX_VALUE;
        else{
            double max=arr[0];
            for(double element:arr){
                if(element>max) max=element;
            }
            return max;
        }
    }

    /**
     *
     * @param arr исходный массив, сортируется по убыванию
     */
     static void sort(double[ ] arr){
         Arrays.sort(arr);

     }

    /**
     *
     * @param matrix исходная матрица
     * @param vector исходный вектор
     * @return результат перемножения
     */
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double[] arr=new double[matrix.length];
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
              arr[i]+=matrix[i][j]*vector[j];
            }

        }
        return arr;
    }

    /**
     *
     * @param matrixLeft первая матрица
     * @param matrixRight вторая матрица
     * @return результат перемножения
     */
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] arr=new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i <matrixLeft.length ; i++) {
            for (int j = 0; j <matrixLeft[0].length ; j++) {
               for (int k = 0; k <matrixRight[0].length ; k++) {
                    arr[i][k]+=matrixLeft[i][j]*matrixRight[j][k];
                }
            }

        }
        return arr;
    }
}
