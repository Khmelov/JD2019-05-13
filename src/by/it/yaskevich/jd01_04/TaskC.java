package by.it.yaskevich.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);

    }
    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        System.out.println();

        double firstElement = array[0];
        double lastElement = array[array.length - 1];

        mergeSort(array);
        InOut.printArray(array, "V", 4);
        System.out.println();

        int i = binarySearch(array, firstElement);
        System.out.println("Index of first element=" + i);

        i = binarySearch(array, lastElement);
        System.out.println("Index of last element=" + i);
    }

    private static void mergeSort(double[] array) {
        double[] source = mergeSort(array, 0, array.length - 1);
        System.arraycopy(source, 0, array, 0, source.length);
    }

    private static double[]mergeSort(double[] array, int left, int right) {
        if (array.length < 2)
            return array;
        else {
            int middle = (right + left) / 2;
            double[] part1 = Arrays.copyOfRange(array, left, middle + 1);
            double[] part2 = Arrays.copyOfRange(array, middle + 1, right + 1);

            return  merge(mergeSort(part1, 0, part1.length - 1), mergeSort(part2, 0, part2.length - 1));
        }
    }

    private static double[] merge(double[] part1, double[] part2) {
        double[] array = new double[part1.length + part2.length];

        int i = 0, j = 0;
        while ((i < part1.length) || (j < part2.length)) {
            if (i == part1.length) {
                array[i + j] = part2[j];
                j++;
            } else if (j == part2.length) {
                array[i + j] = part1[i];
                i++;
            } else {
                if (part1[i] <= part2[j]) {
                    array[i + j] = part1[i];
                    i++;
                } else {
                    array[i + j] = part2[j];
                    j++;
                }
            }
        }

        return array;
    }

    private static int binarySearch(double[] array, double value) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (right + left) / 2;
            if (array[middle] == value)
                return middle;
            else if (array[middle] > value)
                right = middle - 1;
            else
                left = middle + 1;
        }

        return -1;
    }
}
