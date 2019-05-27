package by.it.orlov.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] mas = step1(n);
        step2(mas);
        step3(mas);

    }
    static int[][] step1(int n){

        int max = n*2+1, min = -n, f = 0;
        int[][] mas = new int[n][n];
        for (;f == 0;) {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mas[i][j]==(-n)) { //проверочка на n
                        for (int i_if = 0; i_if < n; i_if++) {
                            for (int j_if = 0; j_if < n; j_if++) {
                                if (mas[i_if][j_if] == n) { //проверочка на -n
                                    f = 1;
                                }
                            }
                        }
                    }
                }
            }
            //оновляет числа
            if (f == 0) {
                for (int i_if1 = 0; i_if1 < n; i_if1++) {
                    for (int j_if1 = 0; j_if1 < n; j_if1++) {
                        mas[i_if1][j_if1] = min + (int) (Math.random() * max);
                    }
                }
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mas[i][j]+" ");
            }
            System.out.print("\n");
        } //вывод


        return mas;
    }

    static int step2(int[][] mas) {
        int n = mas.length;
        int sum = 0;
        for(int i = 0; i < n; i++) //перебор массива 1
        {
            for(int j = 0; j < n; j++) //перебор массива 2
            {
                if(mas[i][j] > 0)  //если число во 2 массиве > 0
                {
                    for(int k  = j+1; k < mas[i].length; k++) // перебор
                    {
                        if(mas[i][k] > 0)
                        {
                            for(int t = j+1; t < k; t++)
                            {
                                sum+=mas[i][t];
                            }
                            j = n;
                        }
                    }
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    static int[][] step3(int[][] mas) {
        {
            System.out.println();
            int n = mas.length;
            int k = 0;
            for(int i = 0; i < n;i++) {
                for(int j = 0; j < n; j++) {
                    if (mas[i][j] == n || mas[i][j] == -n) {
                        for(int p = 0; p < n; p++) {
                            mas[i][p] = 10;
                        }
                        for(int p = 0; p < n; p++) {
                            mas[p][j] = 10;
                        }
                    }
                }
            }

            System.out.println();
            int l = 0;
            int[] line = new int[n];
            int[] colomn = new int[n];
            int[] qwer = new int[n*n];
            int p = 0;
            for(int i = 0; i < n; i++) {
                l = 0;
                for(int j = 0; j < n; j++) {
                    if(mas[i][j] != 10)
                    {
                        l++;
                        qwer[p] = mas[i][j];
                        p++;
                    }
                }
                line[i] = l;
            }
            for(int i = 0; i < n; i++) {
                l = 0;
                for(int j = 0; j < n; j++)
                {
                    if(mas[j][i] != 10)
                    {
                        l++;
                    }
                }
                colomn[i] = l;
            }
            int maxi = 0, maxj = 0;
            for(int i = 0; i < n; i++) {
                if(colomn[i] > maxj)
                {
                    maxj = colomn[i];
                }
            }
            for(int i = 0; i < n; i++) {
                if(line[i] > maxi)
                {
                    maxi = line[i];
                }
            }
            System.out.println();
            int[][] mas1 = new int[maxi][maxj];
            int u = 0;
            for(int i = 0; i < maxi; i++) {
                for(int j = 0; j < maxj; j++)
                {
                    mas1[i][j] = qwer[u];
                    u++;
                }
            }
            for(int i = 0; i < maxi; i++) {
                for(int j = 0; j < maxj; j++)
                {
                    if(mas1[i][j] >= 0)
                    {
                        System.out.print(" ");
                    }
                    System.out.print(mas1[i][j] + " ");
                }
                System.out.println();
            }
            return mas1;
        }
    }
}