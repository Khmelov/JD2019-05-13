package by.it.izaykoff.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] mas = step1(n);

        int sum = step2(mas);
        System.out.println(sum);

   //   int[][] minmas = step3(mas);



    }
    private static int[ ][ ] step1(int in) {
        int[][] ar = new int[in][in];
        boolean minNum = false;
        boolean maxNum = false;
        Random random = new Random(System.currentTimeMillis());

        while (true) {
            minNum = false;
            maxNum = false;
            for (int i = 0; i < ar.length; i++) {
                for (int j = 0; j < ar.length; j++) {
                    ar[i][j] = -in + random.nextInt(in - (-in) + 1);
                    if(ar[i][j] == -in){
                        minNum = true;
                    }else if (ar[i][j] == in){
                        maxNum = true;
                    }
                }
            }
            if (minNum && maxNum){
                return ar;
            }

        }
    }

    private static int step2(int[][] mas){
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++){
                if (mas[i][j] > 0) {
                    for (int n = j + 1; n < mas.length; n++) {
                        if (mas[i][n] <= 0) {
                            sum = sum + mas[i][n];
                        } else  break;
                    }
                    break;
                }

            }

        }
        return sum;
    }

  //  private static int[][] step3(int[][] mas){
  //  }

}

