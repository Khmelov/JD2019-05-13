package by.it.yakovets.jd01_04;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        buildOneDimArray(line);
    }
    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        mergeSort(array);
    }
    static void mergeSort(double[] array){
      int m=array.length/2;



        }

}
