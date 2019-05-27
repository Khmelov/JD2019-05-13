package by.it.yaskevich.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();

        String line = "1 2 3 4 5.0 6 7 8 9 0";
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        String name = "A";
        int colCount = 5;
        InOut.printArray(array, name, colCount);

        System.out.println(Helper.findMin(array));
        System.out.println(Helper.findMax(array));
        Helper.sort(array);

        double[][] matrix = {{1, 2},{3, 4}};
        double[] vector = {5, 6};
        InOut.printArray(Helper.mul(matrix, vector));
        double[][] matrix2 = {{1, 2},{3, 4}};
        double[][] res = Helper.mul(matrix, matrix2);
        InOut.printArray(res[0]);
        InOut.printArray(res[1]);
    }
}
