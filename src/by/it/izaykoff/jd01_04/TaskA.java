package by.it.izaykoff.jd01_04;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        String str = "1 2 3 4 5 6";
        buildOneDimArray(str);

    }

    static void printMulTable(){
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ",i,j,i*j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        String[] strArray = line.split(" ");
        double[] array = new double[strArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = Double.parseDouble(strArray[i]);
            System.out.printf("V" + "[%2d ]=%-7.3f ", i, array[1] );
            if((i + 1) % i == 0) {
                System.out.println();
            }
        }
    }
}
