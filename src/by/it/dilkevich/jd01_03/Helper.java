package by.it.dilkevich.jd01_03;

public class Helper {
    /**
     * Находит минимальное значение в массиве
     * @param arr входящий массив Double
     * @return возвращает наименьший элемент из массива
     */
    static double findMin(double[ ] arr){
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    /**
     * Находит максимальное значение в массиве
     * @param arr входящий массив Double
     * @return возвращает наибольший элемент из массива
     */
    static double findMax(double[ ] arr){
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    /**
     * Сортирует массив в порядке возрастание типом Пузырек
     * @param arr входящий массив Double
     */
    public static void sort(double[ ] arr){

        boolean swap = false;
        int lastItem  = arr.length - 1;
        do {
            swap = false;
            for (int i = 0; i < lastItem; i++) {
                if (arr[i] > arr[i + 1]) {
                    double temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swap = true;

                }
                for (double u : arr) {

                }

            }

        }
        while (swap == true);
        System.out.println();
    }

    /**
     * Умножение матрицы на вектор
     * @param matrix входящий двумерный массив
     * @param vector входящий вектор
     * @return возвращает умноженный массив на вектор
     */
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double [] multMasVector = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                multMasVector[i] = multMasVector[i] + matrix[i][j]*vector[j];
            }
        }
        return multMasVector;
    }

    /**
     * Умножает массив на массив
     * @param x входящий двумерный массив
     * @param y входящий двумерный массив
     * @return возвращает умноженный массив на массив
     */
    static double[ ][ ] mul(double[ ][ ] x, double[ ][ ] y){
        double [] [] z = new double[x.length][y[0].length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y[0].length; j++) {
                for (int k = 0; k < y.length; k++) {
                    z[i][j] = z[i][j] + x[i][k] * y[k][j];
                }
            }
        }
        return z;
    }

}
