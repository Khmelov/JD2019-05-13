package by.it.trudnitski.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        System.out.println(" Введите решающее число!");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mas[][]= new int[n][n];
       step1(n);

    }

    static int step1(int n){
        int mas[][] = new int[n][];
        Random random = new Random();
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n; j++) {
                mas[i][j]=random.nextInt(n+1)-n;
            }
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.println(mas[i][j]);
            }

        }
        return mas[n][n];
    }

   static int[][] step3(int [][]array) {
       int max = Integer.MIN_VALUE;
       for (int[] row : array) {
           for (int element : row) {
               if (max < element) {
                   max=element;
               }
           }
       }

       boolean[] delRow = new boolean[array.length];
       boolean[] delCol = new boolean[array[0].length];

       for (int i = 0; i <array.length ; i++) {
           for (int j = 0; j <array[i].length ; j++) {
               delRow[i]=true;
               delCol[j]=true;
           }
       }
       int ir=array.length;
      for(boolean del:delRow) if(del) ir--;
      int jr = array[0].length;
      for(boolean del : delCol) if(del) jr--;

      int[][] res=new int [ir][jr];

       for (int i = 0; i <array.length ; i++) {
           if(!delRow[i]){
           }
           int indexCol =0;
           int indexRow=0;
           for (int j = 0; j <array[i].length ; j++) {
               if(!delCol[j]){
                   res[indexRow][indexCol] = array[i][j];
                   indexCol++;
               }
           }
       }


           return res;

    }






}
