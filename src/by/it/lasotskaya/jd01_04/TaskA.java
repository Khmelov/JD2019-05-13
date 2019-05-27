package by.it.lasotskaya.jd01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {


            printMulTable();
        Scanner sc = new Scanner(System.in);
        String line=sc.nextLine();
            //String line = " 4 6 2 3 5";
            buildOneDimArray(line);
    }
    private static void printMulTable(){
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j <10 ; j++) {
                System.out.printf("%1d*%1d=%-2d ",i,j,i*j);

            }
            System.out.println();
        }

    }

    private static  void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double firstAr = array[0];
        double last = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        System.out.println();
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        System.out.println();
        for (int i = 0; i < array.length; i++) {
        if(array[i]==firstAr) {
            System.out.printf("Index of first element=" + i);
        }}
        for (int i = 0; i < array.length; i++) {
            if(array[i]==last){
                System.out.printf("Index of last element=" + i);}
        System.out.println();

    }}}


