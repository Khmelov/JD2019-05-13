package by.it.dilkevich.jd01_04;

import by.it.dilkevich.jd01_03.Helper;
import java.util.Arrays;

public class TaskC {
    static void buildOneDimArray(String line) {
        double[] mas = InOut.getArray(line);
        InOut.printArray(mas, "V", 5);
        double first = mas[0];
        double last = mas[mas.length - 1];
        mergeSort(mas);
        InOut.printArray(mas, "V", 4);
        int indexFirst = binarySearch(mas, first);
        int indexLast = binarySearch(mas, last);
        System.out.println();
        System.out.println("Index of first element=" + indexFirst);
        System.out.println("Index of last element=" + indexLast);
    }

    public static void mergeSort(double[] a) {
        if (a.length < 2) {
            return;
        }
        int mid = a.length / 2;
        double[] l = new double[mid];
        double[] r = new double[a.length - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < a.length; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l);
        mergeSort(r);

        merge(a, l, r, mid, a.length - mid);
    }

    public static void merge(
            double[] a, double[] l, double[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
    static int binarySearch(double[ ] array, double value) {
        int start, end, middle;
        start = 0;
        end = array.length;
        middle = (start + end) / 2;
        while (array[middle] != value){
            if(value < array[middle]){
                end = middle -1;
                middle = (start + end) / 2;
            }
            if(value > array[middle]){
                start = middle +1;
                middle = (start + end) / 2;
            }
        }
        return middle;
    }
}
