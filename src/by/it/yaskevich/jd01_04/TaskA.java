package by.it.yaskevich.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA
{
    public static void main(String[] args) {
        printMulTable();

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }

    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);

        double firstElement = array[0];
        double lastElement = array[array.length - 1];

        Helper.sort(array);
        InOut.printArray(array, "V", 4);

        int i = Arrays.binarySearch(array, firstElement);
        System.out.println("Index of first element=" + i);

        i = Arrays.binarySearch(array, lastElement);
        System.out.println("Index of last element=" + i);
    }
}
