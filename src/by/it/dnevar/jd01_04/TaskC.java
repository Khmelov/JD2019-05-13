package by.it.dnevar.jd01_04;

import by.it.dnevar.jd01_03.Helper;
import by.it.dnevar.jd01_03.InOut;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

//        Scanner sc=new Scanner(System.in);
//        String line = sc.nextLine();
        String line = "12 43 21 43 65 75 23 53 61 74";
        buildOneDimArray(line);

    }

    static int binarySearch(double[ ] array, double value){
        int res=0;
        int firstIndex  = 0;
        int lastIndex   = array.length - 1;
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

    static void mergeSort(double[]array){
        if(array == null){
            return;
        }

        if(array.length <2){
            return;
        }

        double[] array1 = new double[array.length/2];
        System.arraycopy(array,0,array1,0,array.length/2);

        double[] array2 = new double[array.length - array.length/2];
        System.arraycopy(array,array.length/2,array2,0,array.length-array.length/2);

        mergeSort(array1);
        mergeSort(array2);

        merge(array,array1,array2);
    }

    static void merge(double[] array, double[] array1, double[] array2) {
        int totElem = array1.length + array2.length;
        int i,ar1i,ar2i;
        i = ar1i = ar2i = 0;
        while ( i < totElem) {
            if ((ar1i < array1.length) && (ar2i<array2.length)) {
                if (array1[ar1i] < array2[ar2i]) {
                    array[i] = array1[ar1i];
                    i++;
                    ar1i++;
                }
                else {
                    array[i] = array2[ar2i];
                    i++;
                    ar2i++;
                }
            }
            else {
                if (ar1i >= array1.length) {
                    while (ar2i < array2.length) {
                        array[i] = array2[ar2i];
                        i++;
                        ar2i++;
                    }
                }
                if (ar2i >= array2.length) {
                    while (ar1i < array1.length) {
                        array[i] = array1[ar1i];
                        ar1i++;
                        i++;
                    }
                }
            }
        }

    }

    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        InOut.printArray(array,"V", 5);

        double first = array[0];
        double last = array[array.length-1];

//        Helper.sort(array);
        mergeSort(array);
        System.out.println();

        InOut.printArray(array, "V", 4);

        int indexFirst = binarySearch(array,first);
        System.out.println("Index of first element="+indexFirst);
        int indexLast = binarySearch(array,last);
        System.out.println("Index of last element="+indexLast);


    }
}
