package by.it.orlov.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String line = scn.nextLine();
        buildOneDimArray(line);

    }


    public static void mergeSort(double[] array){
        int len = array.length;
        int n = 1; // кратность
        int shift; // сдвиг в перебираемом массиве
        int two_size; // количество элементов для 2-го массива
        double[] arr2;
        while (n < len) {
            shift = 0;
            while (shift < len) {
                if (shift + n >= len) break;
                two_size = (shift + n * 2 > len) ? (len - (shift + n)) : n;
                arr2 = merge(Arrays.copyOfRange(array, shift, shift + n),
                        Arrays.copyOfRange(array, shift + n, shift + n + two_size));
                for (int i = 0; i < n + two_size; ++i)
                    array[shift + i] = arr2[i]; // замена на отсортированное
                shift += n * 2;
            }
            n *= 2;
        }
    }
    public static double[] merge(double[] left, double[] right){
        double[] result = new double[left.length+right.length];
        int i=0, j=0;
        for (int k = 0; k < result.length; k++) {
            if(i == left.length){
                result[k] = right[j];
                j++;
            }else if(j == right.length){
                result[k] = left[i];
                i++;
            }else if(left[i]<right[j]){
                result[k]=left[i];
                i++;
            }else if (left[i]>right[j]){
                result[k] = right[j];
                j++;
            }
        }
        return result;
    }

    static int binarySearch(double[ ] array, double value) {
        int left = 0;
        int right = array.length;
        while (true) {
            int mid = left + (right - left) / 2;
            // нашли середину
            if (array[mid] == value)
                return mid;
            // нашли если число в середине
            if (array[mid] > value)
                right = mid;
            else
                left = mid + 1;
        }
    }
    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        double first = array[0], last = array[array.length-1];
        InOut.printArray(array, "V", 5);
        mergeSort(array);
        InOut.printArray(array, "V", 4);
        int index_search = binarySearch(array, first), index_search_last=binarySearch(array, last);
        System.out.println("Index of first element=" + index_search);
        System.out.println("Index of last element=" + index_search_last);
    }
}
