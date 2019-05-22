package by.it.maniuk.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);

        //InOut.printArray(array, "V", 5);
        //mergeSort(array);
        quickSort(array);
        InOut.printArray(array, "V", 4);

        double first = array[0];
        double last = array[array.length - 1];
        for (int i = 0; i < array.length; i++) {
            if (array[i] == first) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == last) {
                System.out.println("Index of last element=" + i);
                break;
            }
        }

    }

    static void quickSort(double[] array){
        int low = 0;
        int high = array.length - 1;
        if (array.length == 0)
            return;
        if (low >= high)
            return;
        doSort(array, low, high );

    }

    static void doSort(double[] array, int low, int high) {

        int middle = low + (high - low) / 2;
        double opora = array[middle];
        int i = low, j = high;

        while (i <= j) {
            while (array[i] < opora) {
                i++;
            }
            while (array[j] > opora) {
                j--;
            }
            if (i <= j) {
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
            if (low < j)
                doSort(array, low, j);
            if (high > i)
                doSort(array, i, high);
        }
    }



    static void mergeSort(double[] array) {
        int start = 0;
        int end = array.length - 1;
        if (array.length > 1) {
            if (array[0]<array.length) {

                mergeSort(array, start,  end);
            }

            }

    }

    private static double[] mergeSort (double[] array, int left, int right){
        int q = array.length / 2;
        double[] leftArray = Arrays.copyOfRange(array, 0, q - 1);
        double[] rightArray = Arrays.copyOfRange(array, q, array.length-1);
        mergeSort(leftArray, 0, leftArray.length - 1);
        mergeSort(rightArray, rightArray.length - 1, array.length);
        array = merge(array, leftArray, rightArray);
        return array;
    }

    private static double[] merge(double[] array, double[] part1, double[] part2){
            int totElem = part1.length + part2.length;
            int i, li, ri;
            i = li = ri = 0;
            while (i < totElem) {
                if ((li < part1.length) && (ri < part2.length)) {
                    if (part1[li] < part2[ri]) {
                        array[i] = part1[li];
                        i++;
                        li++;
                    } else {
                        array[i] = part2[ri];
                        i++;
                        ri++;
                    }
                } else {
                    if (li >= part1.length) {
                        while (ri < part2.length) {
                            array[i] = part2[ri];
                            i++;
                            ri++;
                        }
                    }
                    if (ri >= part2.length) {
                        while (li < part1.length) {
                            array[i] = part1[li];
                            li++;
                            i++;
                        }
                    }
                }
            }
            return array;
        }

//    private static double[] mergeSort(double[] array, int left, int right){
//
//        }





    }


