package by.it.izaykoff.jd01_03;

public class Helper {

    static double findMin(double[ ] arr){
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
    static double findMax(double[ ] arr){
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
    static void sort(double[ ] arr){
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
   // static double[ ] mul(double[ ][ ] matrix, double[ ] vector){

   //}


}
