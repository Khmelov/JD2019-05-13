package by.it.aadamovich.jd01_04;

import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        buildOneDimArray(sc.nextLine());

    }

    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstElem = array[0], lastElem = array[array.length - 1];

        InOut.printArray(array, "V", 5);
        mergeSort(array);
        InOut.printArray(array, "V", 4);

        System.out.println("Index of first element=" + binarySearch(array, firstElem));
        System.out.println("Index of last element=" + binarySearch(array, lastElem));
    }

    private static void mergeSort(double[] array) {
        quickSort(array, 0, array.length - 1);

    }

    private static void quickSort(double[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        double base = array[low];
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < base) {
                i++;
            }
            while (array[j] > base) {
                j--;

            }
            if (i <= j) {
                double buffer = array[i];
                array[i] = array[j];
                array[j] = buffer;
                i++;
                j--;
            }
        }
        if (low < j) quickSort(array, low, j);
        if (high > i) quickSort(array, i, high);
    }


    private static int binarySearch(double[] array, double value) {
        int left = 0, right = array.length - 1;

        while (left <= right) {
            int medium = (right + left) / 2;
            if (array[medium] == value) {
                return medium;
            } else if (array[medium] > value) {
                right = medium - 1;
            } else left = medium + 1;
        }
        return -1;
    }
}
