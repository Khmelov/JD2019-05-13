package by.it.orlov.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[] mas = new int [12];
        for (int i = 0; i < mas.length-1; i++){
            mas[i] = scn.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);

    }
    private static void step1(int[ ] mas){
        int min = mas[0], max = mas[0];
        for(int i = 0;i < mas.length; i++){
            if(min > mas[i]){
                min = mas[i];
            }
            if(max < mas[i]){
                max = mas[i];
            }
        }
        System.out.println(min + " " + max);
    }
    private static void step2(int[ ] mas){
        int sum = 0;
        for (int element : mas){
            sum += element;
        }
        double avg = (double)sum / mas.length;
        for (int element : mas){
            if (element<avg){
                System.out.print(element + " ");
            }
        }
        System.out.print("\n");
    }



    private static void step3(int[ ] mas){
        int min = mas[0];
        for(int element : mas){
            if(element<min){
                element = min;
            }
        }
        for(int i = mas.length-1; i >= 0; i --){
            if(min==mas[i]){
                System.out.print(i + " ");

            }        }






    }

}
