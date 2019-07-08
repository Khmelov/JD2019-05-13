package by.it.livanovich.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        buildOneDimArray(s);

    }

    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        mergeSort(array);
        InOut.printArray(array, "V", 4);
        int indexFirst = Arrays.binarySearch(array, first);
        System.out.println("Index of first element=" + indexFirst);
        int indexLast = Arrays.binarySearch(array, last);
        System.out.println("Index of last element=" + indexLast);
    }

    static void mergeSort(double[] array) {
        int left = 0;
        int right = array.length - 1;
        if (right <= left) return;
        int m = (right + left) / 2;
        double[] part1 = new double[m];
        double[] part2 = new double[array.length - m];
        System.arraycopy(array, 0, part1, 0, m);
        System.arraycopy(array, 0, part2, m + 1, array.length);

    }



    private static double[] merge(double[] part1, double[] part2) {
        int n = part1.length + part2.length;
        double[] array = new double[n];
        int i = 0;
        int j = 0;
        for (int k = 0; k < array.length; k++) {
            if (i == part1.length) {
                array[k] = part2[j++];
            } else if (j == part2.length) {
                array[k] = part1[i++];
            } else {
                if (part1[i] < part2[j]) {
                    array[k] = part1[i++];
                } else {
                    array[k] = part2[j++];
                }
            }
        }
        return array;
    }
}
