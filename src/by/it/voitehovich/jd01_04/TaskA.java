package by.it.voitehovich.jd01_04;

import java.util.Scanner;


public class TaskA {

    public static void main(String[] args) {
        printMulTable();
        Scanner sc=new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);

    }



    private static void printMulTable(){
        int res;
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10 ; j++) {
                res = i * j;
                System.out.printf("%1d*%1d=%-2d ", i, j ,res);
            }
            System.out.println();
        }
    }
    private static void buildOneDimArray(String line){
        double [] mas = InOut.getArray(line);
        double start = mas [0];
        double end = mas [mas.length-1];
        InOut.printArray(mas, "V", 5);
        Helper.sort(mas);
        InOut.printArray(mas, "V", 4);
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == start) {
                System.out.println("Index of first element=" + i);
                break;
            }
        }

            for (int i = 0; i < mas.length; i++) {
                if(mas[i] == end) {
                    System.out.println("Index of last element=" + i);
                break;}
            }

        }
    }

