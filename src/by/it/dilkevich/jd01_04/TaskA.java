package by.it.dilkevich.jd01_04;

import by.it.dilkevich.jd01_03.Helper;
import java.util.Arrays;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);

    }
    static void printMulTable(){
        int myMas[][] = new int [8][8];
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf(" %1d*%1d=%-2d", i, j, i*j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line){
        double [] mas = InOut.getArray(line);
        InOut.printArray(mas, "V", 5);
        double first = mas[0];
        double last = mas[mas.length-1];
        Helper.sort(mas);
        InOut.printArray(mas, "V", 4);
        int indexFirst = Arrays.binarySearch(mas, first);
        int indexLast = Arrays.binarySearch(mas, last);
        System.out.println();
        System.out.println("Index of first element=" + indexFirst);
        System.out.println("Index of last element=" + indexLast);
    }


}
