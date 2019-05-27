package by.it.trudnitski.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        buildOneDimArray(s);

    }
    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last=array[array.length-1];
        InOut.printArray(array,"V",5);
        mergeSort(array);
        InOut.printArray(array,"V",4);

        for (int i = 0; i < array.length; i++) {
            if(array[i]==first){
                System.out.println("Index of first element=" + i);
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i]==last){
                System.out.println("Index of last element=" + i);
                break;
            }
        }
        //int IndexFirst = Arrays.binarySearch(array, first);
        //System.out.println("Index of first element=" + IndexFirst);
        //int IndexLast = Arrays.binarySearch(array, last);
        //System.out.println("Index of last element=" + IndexLast);
    }

    static void mergeSort(double[]array){
        if (array.length > 1) {
            int q = array.length/2;
            double[] leftArray = Arrays.copyOfRange(array, 0, q-1);
            double[] rightArray = Arrays.copyOfRange(array,q,array.length-1);

            mergeSort(leftArray);
            mergeSort(rightArray);

            merge(array,leftArray,rightArray);
        }

    }

    static void merge(double[] a, double[] l, double[] r) {
        int totElem = l.length + r.length;
        //int[] a = new int[totElem];
        int i,li,ri;
        i = li = ri = 0;
        while ( i < totElem) {
            if ((li < l.length) && (ri<r.length)) {
                if (l[li] < r[ri]) {
                    a[i] = l[li];
                    i++;
                    li++;
                }
                else {
                    a[i] = r[ri];
                    i++;
                    ri++;
                }
            }
            else {
                if (li >= l.length) {
                    while (ri < r.length) {
                        a[i] = r[ri];
                        i++;
                        ri++;
                    }
                }
                if (ri >= r.length) {
                    while (li < l.length) {
                        a[i] = l[li];
                        li++;
                        i++;
                    }
                }
            }
        }


    }
}