package by.it.buymistrov.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        double[] array = InOut.getArray(line);

        double[][] matrix = {{2, 3, 5, 1, 7, 8}, {6, 4, 3, 7, 9, 1}};
        double[][] matrixLeft = {{2, 3, 5, 1}, {6, 4, 3, 7}};
        double[][] matrixRight = {{2, 3}, {6, 4}, {5, 3}, {4, 9}};
        double[] vector = {5, 8};
        InOut.printArray(array);
        InOut.printArray(array, "A", 3);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        Helper.mul(matrix, vector);
        InOut.printArray(Helper.mul(matrix, vector));
        Helper.mul(matrixLeft, matrixRight);
        System.out.println();
        InOut.printmas(Helper.mul(matrixLeft, matrixRight));


    }

}
