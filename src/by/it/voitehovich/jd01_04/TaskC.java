package by.it.voitehovich.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);

    }
    private static void buildOneDimArray(String line) {
        double [] mas = InOut.getArray(line);




    }
 /*   static void mergeSort(double[ ] array){
        if(array == null) return;
        if(array.length<2) return array;

    }

    private static double[ ] mergeSort(double[ ] array, int left, int right){

    }

    private static double[ ] merge(double[ ] part1, double[ ] part2){

    }*/
}
