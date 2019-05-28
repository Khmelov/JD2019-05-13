package by.it.maniuk.jd01_03;



        import java.util.Scanner;

public class Runner {
    static double[][] matrixLeft = {
            {1, 2, 4, 5},
            {3, 4, 5, 6},
            {5, 6, 6, 2},
            {2, 4, 6, 1}

    };
    static double[][] matrixRight = {
            {3, 4, 5, 5},
            {3, 4, 7, 6},
            {5, 8, 8, 9},
            {1, 8, 9, 1}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array, "V",  3);

        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        Helper.mul(matrixLeft, array);
        Helper.mul(matrixLeft, matrixRight);

        Helper.arrayPrint2D(Helper.mul(matrixLeft, matrixRight), "matrix");


    }
}
