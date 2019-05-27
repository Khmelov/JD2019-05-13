package by.it.zhukova.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    static void printMulTable(){
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-3d", i , j, i*j);
            }
            System.out.println();
        }
    }
    static void buildOneDimArray(String line){

        double[] arr = InOut.getArray(line);
        InOut.printArray(arr,"V",5);
        double first = arr[0];
        double last = arr[arr.length-1];
        Sort(arr);
        int infirst = Arrays.binarySearch(arr,first);
        int inlast = Arrays.binarySearch(arr,last);
        //for (int i = 0; i < arr.length; i++) { if (arr[i] == first ) {infirst=i; break;} }
        //for (int i = 0; i < arr.length; i++) { if (arr[i] == last ) {inlast=i; break;} }
        System.out.println("Index of first element="+infirst);
        System.out.println("Index of last element="+inlast);
    }

    private static double[] Sort(double[] arr) {
        double m=0;
        boolean swap;
        int last = arr.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    m = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = m;
                    swap = true;
                }
            }
            last--;
        } while (swap);
        //Arrays.sort(arr);
        System.out.println("Отсортированный массив:");
        InOut.printArray(arr,"V",4);
        return arr;

    }

    public static void main(String[] args) {

        printMulTable();
        Scanner sc = new Scanner (System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }
}
