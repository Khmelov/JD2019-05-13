package by.it.zhukova.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] mas = step1(n);

        int sum =step2(mas);
        System.out.println(sum);
        int[][] matwithoutmax = step3(mas);
        for (int i = 0; i < matwithoutmax.length; i++) {
            for (int j = 0; j < matwithoutmax.length; j++) {
                                System.out.print(matwithoutmax[i][j]+" ");
            }

            System.out.println();}
    }

    private static int[][] step1(int n) {

        int[][] mas = new int[n][n];
        Random random = new Random();
        int k = 0;
        int m = 0;
        do {
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas[0].length; j++) {
                    mas[i][j] = random.ints(-n, (n + 1)).findFirst().getAsInt();
                    if (mas[i][j] == n ) k++;
                    if (mas[i][j] == n ) m++;
                }
            }
        }
        while (k == 0 || m ==0);
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++)
                System.out.print(mas[i][j] + " ");;
            System.out.print("\n");
        }
return mas;
    }
    private static int step2(int[][] mas) {
        int sum = 0;
            for (int i = 0; i < mas.length; i++) {
                int k = 0;
                int plus1 = 0;
                int plus2 = 0;
                for (int j = 0; j < mas[0].length; j++) {
                    if (mas[i][j] > 0 && k==1){
                        k++;
                        plus2 = j;
                        continue;

                    }else
                    if (mas[i][j] > 0) {
                        k++;
                        plus1 = j;
                    }
                }

               for (int j = plus1+1; j < plus2; j++)
                   sum +=mas[i][j];

        }

        return sum;
    }
    private static int[][] step3(int[ ][ ] mas){
int [] strhelp = new int [mas.length];
        int [] stbhelp = new int [mas[0].length];
        int max = mas[0][0];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                if (mas[i][j] > max)
                    max=mas[i][j];
            }
            }
        System.out.println(max);
        //поиск строк и столбцов для удаления:
        boolean [] delRow = new boolean[mas.length];
        boolean [] delCol = new boolean[mas[0].length];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                if (mas[i][j] == max) {
                    delRow[i]=true;
                    delCol[i]=true;
                    }
            }
            }

int ir = mas.length;


                return mas; //result;
    }
}