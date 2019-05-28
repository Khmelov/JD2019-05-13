package by.it.livanovich.jd01_02;

import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mas = new int[n][n];

        step1(n);
        step2 (mas);


    }

    private static void step1(int n) {
        int[][] mas = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int element = (int) (Math.random() * (2 * n + 1)) - n;
                mas[i][j] = element;}}
            boolean mat;
            for (int[] row : mas)
                    for (int s : row) {
                        if (s == -n || s==n) mat=true;}
            if ( mat=true){
                    System.out.print(mas);
        System.out.println();}
            else
                System.out.println("No");

        }

    private static void step2(int [][] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                int element = (int) (Math.random() * (2 * mas.length + 1)) - mas.length;
                mas[i][j] = element;

                    }

                                 }

                    }
            }






