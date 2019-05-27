package by.it.yakovets.jd01_03;

class Helper {
    static double findMin(double[] array) {
        double min = 0;
        for (double v : array) {
            if (min > v) min = v;
        }
        return min;
    }

    static double findMax(double[] array) {
        double max = 0;
        for (double element : array) {
            if (max < element) max = element;
        }
        return max;
    }

    static void sort(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    double m = array[i];
                    array[i] = array[j];
                    array[j] = m;

                }

            }

        }

    }

    static double[] mul(double[][] matrix, double[] vector) {
        double[] kx = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < vector.length; i1++) {
                kx[i] = kx[i] + matrix[i][i1] * vector[i1];
            }
        }
        return kx;
    }
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double [][] kk=new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int i1 = 0; i1 < matrixRight[0].length; i1++) {
                for (int k = 0; k <matrixRight.length ; k++) {
                    kk[i][i1]=kk[i][i1]+matrixLeft[i][k]*matrixRight[k][i1];
                }
            }
        }
        return kk;
    }
}
