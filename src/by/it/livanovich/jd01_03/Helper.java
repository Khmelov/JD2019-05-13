package by.it.livanovich.jd01_03;

import java.lang.reflect.Array;

public class Helper {
    static double findMin(double[ ] arr){
        double min=arr[0];
        for (double element : arr) {
            if (min>element) min=element;
        }
        return min;
    }
    static double findMax(double[ ] arr){
        double max=arr[0];
        for (double element : arr) {
            if (max<element) max=element;
        }
        return max;
    }
    static void sort(double[ ] arr){
        boolean upDirection=true;
        for (int i = 0; i < arr.length; i++)
            for (int j=i+1;j< arr.length;j++)
                if ((upDirection && arr[i]>arr[j]) || (!upDirection && arr[i]<arr[j])){
                    double x=arr[i];
                    arr[i]=arr[j];
                    arr[j]=x;
                }

            }
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector) {
        double[] z = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < vector.length; j++) {
                z[i] = z[i] + matrix[i][j] * vector[j];
                System.out.print(z [i] + " ");
            }
        return z;
    }

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] z=new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixRight [0].length; j++)
                for (int k = 0; k < matrixRight.length; k++) {
                    z [i][j]= z[i][j]+ matrixLeft [i][k]* matrixRight [k][j];
                    System.out.print(z [i][j] + " ");
                }
        return z;

        }
    }


