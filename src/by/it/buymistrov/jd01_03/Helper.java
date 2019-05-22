package by.it.buymistrov.jd01_03;


public class Helper {


    /**
     * поиск минимального значения массива
     * @param array массив типа double
     * @return возвращает минимальное значение массива
     */
    static double findMin(double[] array) {
        double min = Double.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
        }
        System.out.println(min);
        return min;
    }

    /**
     * поиск максимального значения
     * @param array массив типа double
     * @return возвращает максимальное значение массива
     */
    static double findMax(double[] array) {
        double max = Double.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        System.out.println(max);
        return max;
    }

    /**
     * сортировка по возрастанию
     * @param array массив типа double
     */
    static void sort(double[] array) {

        boolean swap;
        int last = array.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (array[i] > array[i + 1]) {
                    double buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                    swap = true;
                }
            }
            last--;

        }
        while (swap);


        InOut.printArray(array);
    }

    /**
     * умножение матрицы на вектор
     * @param matrix двумерный массив(матрица) типа double
     * @param vector массив типа double
     * @return возвращает результат умножения матрицы на вектор
     */
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double [] rez = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <vector.length ; j++) {
                rez [i] = rez[i] + matrix[i][j] * vector [j];

            }

        }

        return rez;
    }

    /**
     * умножение матрицы на матрицу
     * @param matrixLeft первая матрица типа double
     * @param matrixRight вторая матрица типа double
     * @return возвращает матрицу, которая является результатом умножения матриц
     */
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double [][] rez = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length ; k++) {
                    rez[i][j] = rez [i][j] + matrixLeft[i][k]*matrixRight[k][j];

                }

            }

        }
        return rez;
    }






}
