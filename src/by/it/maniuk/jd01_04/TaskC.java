package by.it.maniuk.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
       // Scanner scanner = new Scanner(System.in);
       // String line = scanner.nextLine();
        String line = "12 43 21 43 65 75 23 53 61 74";
        buildOneDimArray(line);
    }

    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);

        double first = array[0];
        double last = array[array.length - 1];
        //InOut.printArray(array, "V", 5);
        mergeSort(array);
        //quickSort(array);
        InOut.printArray(array, "V", 4);


        InOut.printArray(array, "V", 4);
        int first2 = binarySearch(array,first);
        System.out.println("Index of first element="+first2);
        int last2 = binarySearch(array,last);
        System.out.println("Index of last element="+last2);


    }

    static void quickSort(double[] array) {
        int low = 0;
        int high = array.length - 1;
        if (array.length == 0)
            return;
        if (low >= high)
            return;
        doSort(array, low, high);

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




    private static void mergeSort(double[] array) {

        if(array == null){
            return;
        }

        if(array.length <2){
            return;
        }
        double[] leftArray = new double[array.length/2];
        System.arraycopy(array,0,leftArray,0,array.length/2);

        double[] rightArray = new double[array.length - array.length/2];
        System.arraycopy(array,array.length/2,rightArray,0,array.length-array.length/2);
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(array, leftArray, rightArray);

    }

    private static double[] merge(double[] array, double[] part1, double[] part2) {
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
    static int binarySearch(double[ ] array, double value){
        int res=0;
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        int middleIndex = (firstIndex + lastIndex)/2;
        while( firstIndex <= lastIndex ) {
            if ( array[middleIndex] < value ){
                firstIndex = middleIndex + 1;
            } else if ( array[middleIndex] == value ) {
                res = middleIndex;
                break;
            } else{
                lastIndex = middleIndex - 1;
            }
            middleIndex = (firstIndex + lastIndex)/2;
        }
        return res;
    }


}


