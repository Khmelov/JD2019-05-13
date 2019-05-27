package by.it.zhukova.jd01_03;

public class Helper {

    static double findMin(double[ ] arr){
        if(arr.length == 0 )
    return Integer.MAX_VALUE;
    else {
    double min = 0;
    for (double v : arr) {
        if (min > v) min = v;
    }
    return min;
}
    }
    static double findMax(double[ ] arr) {
        if (arr.length == 0)
            return Integer.MAX_VALUE;
        else {
            double max = 0;
            for (double v : arr) {
                if (max < v) max = v;
            }
            return max;
        }
    }
    static void sort(double[ ] arr)
    {
        double m=0;
        boolean swap;
        int last = arr.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    m = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = m;
                swap = true;
            }
            }
            last--;
        } while (swap);
        //Arrays.sort(arr);
        InOut.printArray(arr);
    }
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector)
    {
        double[] mult = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
mult[i]= mult[i]+matrix[i][j]*vector[j];
            }
        }
return mult;
    }
static double[ ][ ] mul(double[ ][ ] matrLeft, double[ ][ ] matrRight)
{
    double[][] c = new double[matrLeft.length][matrRight[0].length];
    for (int i = 0; i < matrLeft.length; i++) {
        for (int k = 0; k < matrRight[0].length; k++) {
            for (int j = 0; j < matrRight.length; j++) {
                c[i][k] = c[i][k] + matrLeft[i][j] * matrRight[j][k];
            }
        }
    }
    return c;

}
}
