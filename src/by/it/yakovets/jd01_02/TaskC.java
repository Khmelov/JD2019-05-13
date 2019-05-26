package by.it.yakovets.jd01_02;

import by.it.yakovets.jd01_04.InOut;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mas = step1(n);
        step2(mas);


    }

    private static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mas[i][j] = (int) (Math.random() * (n * 2 + 1)) - n;

                System.out.print(mas[i][j] + " ");
            }
            System.out.print("\n");
        }
        return mas;
    }

    static int step2(int[][] mas) {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] > 0) {// находим первый положительный элемент
                    for (int k = j + 1; k < mas.length; k++) {
                        if (mas[i][k] > 0) {//второй положительный элемент
                            for (int l = j+1; l < k; l++) {
                                sum = sum + mas[i][l];
                            }
                            break;
                        }
                    }
                    break;
                }
            }
        }
        System.out.println(sum);
        return sum;
    }
}




