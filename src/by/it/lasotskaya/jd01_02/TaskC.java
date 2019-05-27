package by.it.lasotskaya.jd01_02;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int n=sc.nextInt();
    int[][]mas=step1(n);
        for (int i = 0; i <mas.length ; i++) {
            System.out.println(Arrays.toString(mas[i]));
        }
        System.out.println(step2(mas));

    }

    private static int[][] step1(int n){
        int mas[][] = new int[n][n];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
               int random = (int) (Math.random() * (2*n +1)) - n ;
                mas[i][j] = random;
                //System.out.print(mas[i][j] + "\t");

            }
        }
        return mas;
    }
    private  static  int step2(int[][]mas){
        int sum=0;
        for (int i=0; i<mas.length; i++) {
            for (int j=0;j<mas[i].length;j++) {
                if ( mas[i][j]>0 ) {
                    sum+=mas[i][j];
                }
                else {break;}
            }}
        return sum;
        }

    }

