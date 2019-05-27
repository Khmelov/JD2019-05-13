package by.it.kobrinets.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);
        int x = str.nextInt();

        int[][] a =step1(x);
        int s = step2(a);
        System.out.println(s);

    }

    private static int[][] step1(int x) {
        int[][] a = new int[x][x];
        boolean b1 = false, b2 = false;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = rnd(x);
                if (a[i][j] == x){
                    b1 = true;
                }
                if (a[i][j] == -x){
                    b2 = true;
                }
                if (b1 && b2)
                {
                    printArray(a);
                    return a;
                }
            }
        }
        return a;
    }

    public static int rnd(int x){
        Random random = new Random();
        return (random.nextInt(x*2 +1) - x);
    }



    public  static  void printArray(int[][] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.printf("%4d", a[i][j]);
            }
            System.out.println();
        }
    }


    public static int step2 (int[][] a){
        int sum = 0;


        for (int j = 0; j < a.length; j++) {
            int index1 = -1;
            int index2 = -1;

            for (int i = 0; i < a.length; i++) {
                if (a[j][i] > 0) {
                    if (index1 == -1) {
                        index1 = i;
                    }
                    else {
                        index2 = i;
                        break;
                    }
                }
            }
            for (int i = index1+1; i < index2; i++) {
                sum = sum + a[j][i];
            }
        }
        return sum;
    }

    /*public static int step3(int [] [] array{
        int max = Integer.MIN_VALUE;
        for (int[] row : array) {
            for(int e: row){
                if (max<e)
                    max = e;
            }
        }
        boolean [] delRow = new boolean(array.length);
        boolean [] delCol = new boolean[array[0].length];

        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == max){
                    delRow[i] = true;
                    delCol[j] = true;
                }
            }

        }
        int ir = array.length;
        for (boolean del : delRow) if (del) ir--;
        int jr = array[0].length;
        for (boolean del : delCol) if (del) jr--;

        int [][] res = new int [ir][jr];

        int indexRow = 0;
        for (int i = 0; i < array.length; i++){
            if (!delRow[i]){
                int indexCol;
                for (int j = 0; j < array[i].length; j++){
                    if (!delCol[j]){
                        res[indexRow],[indexCol] = a;
                    }

                }
                indexRow++;
            }
        }
    }
    */
    }
