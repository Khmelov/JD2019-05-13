package by.it.voitehovich.jd01_03;

public class Helper {
    /**
     *
     * @param arr входной статический массив double
     * @return min минимальное значение входного массива типа double
     */
    static double findMin(double[] arr) {

        double min = arr[0];
        for (double element : arr) {
            if (min > element) min = element;
        }
        return min;
    }
    /**
     *
     * @param arr входной статический массив double
     * @return max максимальное значение входного массива типа double
     */
    static double findMax(double[] arr) {

        double max = arr[0];
        for (double element : arr) {
            if (max < element) max = element;
        }
        return max;
    }
    /**
     *
     * @param arr входной статический массив double
     * Сортировка массивов типа Double пузырьковым алгоритмом
     */
    static void sort(double[ ] arr){
            boolean swap;
            int last = arr.length - 1;
            do{
                swap = false;
                for (int j = 0; j < last; j++) {
                    if (arr[j] > arr[j+1]){
                        double buffer = arr[j];
                        arr[j] = arr[j +1 ];
                        arr[j+1] = buffer;
                        swap = true;
                    }
                }
                last --;
            } while (swap);
        }
    /**
     *
     * @param matrix входной статический двухмерный массив double
     * @param vector входной статический  массив double
     * @return result статический массив типа double значениями элементов которого
     * является результат матричного перемножения входной матрицы и вектора
     */
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        if(matrix[0].length != vector.length) return null;
        double []  result = new double[matrix.length];
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] = result[i] + matrix [i][j] * vector[j];
            }
        }
        return result;
    }
    /**
     *
     * @param matrixLeft входной статический двухмерный массив double
     * @param matrixRight входной статический двухмерный массив double
     * @return result двухмерный массив типа double значениями элементов которого
     * является результат матричного перемножения входных матриц
     */
    static double [][] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        if(matrixLeft[0].length != matrixRight.length) return null;
        double [][] result  = new double[matrixLeft.length][matrixRight[0].length];
            for (int i = 0; i < matrixLeft.length; i++) {
                for (int j = 0; j < matrixRight[0].length; j++) {
                    for (int k = 0; k < matrixRight.length; k++) {
                        result[i][j] = result[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                    }
                }
            }

        return  result;

    }
    }

