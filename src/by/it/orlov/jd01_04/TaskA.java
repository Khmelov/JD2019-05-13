package by.it.orlov.jd01_04;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        printMulTable();
        String line = scn.nextLine();
        buildOneDimArray(line);
        //System.arraycopy();
    }
    static void printMulTable(){
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i*j);
            }
            System.out.print("\n");
        }
    }
    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        double first = array[0], last = array[array.length-1];
        InOut.printArray(array, "V", 5);
        InOut.printArray(Helper.sort(array), "V", 4);
        int index_search = Arrays.binarySearch(array, first), index_search_last=Arrays.binarySearch(array, last);
        System.out.println("Index of first element=" + index_search);
        System.out.println("Index of last element=" + index_search_last);
    }

    }

