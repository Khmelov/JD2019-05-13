package by.it.guchek.jd01_04;


public class Helper {
    static double findMin(double[ ] arr){
        if (0==arr.length) {
            return Integer.MIN_VALUE;}
            else {
            double min=arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (min > arr[i]) min = arr[i];
            }
            return min;
        }
    }

    static double findMax(double[ ] arr){
        if (0==arr.length) {
            return Integer.MAX_VALUE;}
            else {
            double max = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (max < arr[i]) max = arr[i];
            }
            return max;
        }
    }

    static void sort(double[ ] arr){    //пузырьковая сортировка
        boolean swap;
        int last=arr.length-1;
        do {
            swap = false;   //устанавливаем булевский маркер
            for (int i = 0; i <last; i++) {
                if (arr[i] > arr[i+1]) {
                    double buffer=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=buffer;
                    swap=true;  //была хотя бы одна перестановка
                }
            }
            last--; //за один проход самый большой элемент занял свое место в конце
        }
        while (swap); //как только перестановок не было - закончить цикл
    }
    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double [] mulres = new double [matrix.length];  //инициирую резельтирующий массив
        for (int i = 0; i <matrix.length ; i++)
            for (int j = 0; j <vector.length; j++) {
                mulres [i]=mulres[i] + matrix[i][j]*vector[j];
            }
        return mulres;
    }
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double [][] mulres1 = new double [matrixLeft.length] [matrixRight[0].length];  //инициирую резельтирующий массив
        for (int i = 0; i <matrixLeft.length ; i++)
            for (int j = 0; j <matrixRight[0].length; j++)
                for (int k = 0; k <matrixRight.length ; k++)
                mulres1 [i][j]=mulres1[i][j] + matrixLeft[i][k]*matrixRight[k][j];
        return mulres1;
    }
}
