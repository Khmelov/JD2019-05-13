package by.it.gavrilovec.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

   private static void printMulTable(){
        for (int i = 2; i <10 ; i++) {
            for (int j = 2; j <10 ; j++) {
                System.out.printf("%d*%d=%-3d",i,j,i*j);
            }
            System.out.println();
        }
    }

    private static void buildOneDimArray(String line){
       double[] arr=InOut.getArray(line);
       InOut.printArray(arr,"V",5);
       double first=arr[0];
       double last=arr[arr.length-1];
        Arrays.sort(arr);
        InOut.printArray(arr,"V",4);
        System.out.println("Index of first element="+Arrays.binarySearch(arr,first));
        System.out.println("Index of last element="+Arrays.binarySearch(arr,last));




    }

    public static void main(String[] args) {

       printMulTable();
       Scanner scan=new Scanner(System.in);
       String s=scan.nextLine();
       buildOneDimArray(s);
    }
}
