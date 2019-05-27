package by.it.guchek.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array,"V",5);
        double min=Helper.findMin(array);
        System.out.println(min);
        double max=Helper.findMax(array);
        System.out.println(max);
        Helper.sort(array);
        double [][] matrix = {{1,5,8,1,2},
                              {2,4,8,7,6}};
        double [] vector = {1,2,3};
        double [] mulres = Helper.mul(matrix, vector);
        double [][] matrixLeft = {{1,5,8,1,2},
                                 {2,4,8,7,6}};
        double [][] matrixRight  = {{1,2,3},
                                    {2,3,5}};
        double[][] mulres2 = Helper.mul(matrixLeft,matrixRight);

    }
}
