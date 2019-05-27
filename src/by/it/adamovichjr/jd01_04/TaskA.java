package by.it.adamovichjr.jd01_04;

import by.it.adamovichjr.jd01_03.Helper;
import by.it.adamovichjr.jd01_03.InOut;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        //String test = "123 99 88 77 66 5 4 3 1 0 2";

        printMulTable();
        System.out.println();
        buildOneDimArray(line);
    }
    static void printMulTable(){
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ",i,j,i*j);
            }
            System.out.println();
        }
    }
    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        InOut.printArray(array,"V",5);
        double first = array[0];
        double last = array[array.length-1];
        Helper.sort(array);
        System.out.println();
        InOut.printArray(array,"V",4);
        System.out.println();
        InOut.printArray(array);
        int fir = -1;
        int las = -1;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == first){
                fir = i;
                break;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if(array[i] == last){
                las = i;
                break;
            }
        }

        System.out.println("Index of first element=" + fir);
        System.out.println("Index of last element=" + las);
    }
}
