package by.it.voitehovich.jd01_02;

import java.util.Scanner;

public class TaskC {

   static Scanner sc=new Scanner(System.in);
     static int  n = sc.nextInt();

    /*private static int [][] step1(int n){*/

      /*  boolean bmin = true;
        boolean bmax = true;
        int [][]mas1 = new int[n][n];
        // заполняем рандомными числами  массив
        do {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas1[i][j] = (int) ((Math.random() * (n + n + 1)) - n);
                }
            }
                for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mas1[i][j] == n) bmax = false;
                    if (mas1[i][j] == -n) bmin = false;
                }
            }

        } while (bmin || bmax);



        // Выводим матрицу на экран
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                System.out.print(mas1[i][j] + " ");
            }
            System.out.println();
        }
        return mas1;
    }

    public static void main(String[] args) {
        int [][] mas = step1(n);
    }
*/
}
