package by.it.guchek.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int mas1[][] = TaskC.step1(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mas1[i][j] + " ");
            }
            System.out.println();
        }
        //int sum= TaskC.step2(mas1);
    }

    private static int[][] step1(int n) {
        int mas[][] = new int[n][n];
        int mina = -n;
        int maxa = n;
        boolean mark1 = true;
        boolean mark2 = true;
        while (mark1 | mark2)  {
            mark1 = true;
            mark2 = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = (int) (Math.random() * (maxa - mina+1)) + mina;//рандом от n  до -n
                    if (mina == mas[i][j])
                        mark1 = false;
                    if (maxa == mas[i][j])
                        mark2 = false;
                }
            }
        }
        return mas;
    }

    /*private static int step2(int[ ][ ] mas1){
        for (int i = 0; i <mas1.length ; i++) {
            for (int j = 0; j <mas1.length ; j++) {
                if mas1[i][j]>0 {
                    if a=0 {
                    firsti=i;
                    firstj=j;
                    a=a+1} else {secondi=i;
                    secondj=j}
            }

        }

        }

     //   return sum;}
    */
}
