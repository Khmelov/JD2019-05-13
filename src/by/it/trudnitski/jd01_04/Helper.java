package by.it.trudnitski.jd01_04;

import java.util.Arrays;

/**
 * @autor Timofei Rudnitski;
 * Special class for work main class;
 */

public class Helper {
    /**
     * @param array - from consol;
     * @return min - minimal var in array;
     */
    static double findMin(double[ ] array){

            double min = array[0];
            for (double element : array) {
                if (min > element) min = element;
            }
            System.out.println("min" + " " + min);
            return min;

    }

    /**
     *
     * @param array - from consol;
     * @return max - maximal var in array;
     */
    static double findMax(double[ ] array){

            double max = array[0];
            for (double element : array) {
                if (max < element) max = element;
            }
            System.out.println("max" + " " + max);
            return max;
        }

    /**
     *
     * @param array - from consol;
     * Sorting array;
     */
    static void sort(double[ ] array){
        Arrays.sort(array);
        for (double element : array) {
       //     System.out.print(element+" ");
        }
       // System.out.println();
    }

    /**
     *
     * @param matrix - Matrix;
     * @param y - Vector;
     * @return res - Result matrix*vector;
     */
    static double[ ] mul(double[ ][ ] matrix, double[ ] y){
        double[] res=new double[matrix.length];
        for (int i = 0; i <matrix.length ; i++)
            for (int j = 0; j <y.length ; j++)
                res[i]=res[i]+matrix[i][j]*y[j];

        return res;
        }

    /**
     *
     * @param matrixLeft - Matrix;
     * @param matrixRight - Matrix;
     * @return res - Matrix*Matrix;
     */
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
double[][] result=new double [matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i <matrixLeft.length ; i++)
            for (int j = 0; j <matrixRight[0].length ; j++)
                for (int k = 0; k <matrixRight.length ; k++) {
                    result[i][j]=result[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                }
                return result;


    }

}
