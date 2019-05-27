package by.it.dilkevich.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //step1(n);
        step2(step1(n));
        }

    public static int[ ][ ] step1(int n){
        int[][] mas = new int [n][n];
        Random random = new Random();
        boolean plus = false;
        boolean minus = false;
        do {

            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas[i].length; j++) {
                    mas[i][j] = random.nextInt(n * 2 + 1) - (n);
                    if (mas[i][j] == n)
                        plus = true;
                    if (mas[i][j] == -n)
                        minus = true;
                    System.out.print(mas[i][j] + " ");
                }
                System.out.println();
            }
        }
        while (plus != true || minus != true);

        return mas;
    }
    static int step2(int[ ][ ] mas){

        int sum = 0;
        int firstPositive = -1;
        int secondPositive  = -1;

        for (int i = 0; i < mas.length; i++) {

            for (int j = 0; j < mas[0].length; j++) {
                if(mas[i][j] < 0)
                    continue;
                else {
                    if(firstPositive < 0)
                        firstPositive = j;
                    else {
                        secondPositive =j;
                    }
                }
            }
            if(firstPositive > -1 || secondPositive > -1){
                for (int k = firstPositive+1; k < secondPositive; k++) {
                    sum = sum + mas[i][k];
                }
            }
            firstPositive = -1;
            secondPositive = -1;
        }
        return sum;
    }

    static int[ ][ ] step3(int[ ][ ] mas){

        int [] lineValue = new int [mas[0].length];
        int maxNumber = findMaxValue(mas);

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                if(mas[i][j] == maxNumber){
                    lineValue[j] = j;

                    for (int k = 0; k < mas[0].length; k++) {
                        mas[i][k] = 1000;
                    }
                }
            }
        }

        for (int i = 0; i < mas.length; i++) {
            for (int m:lineValue) {
                if(m>0)
                mas[i][m] = 1000;
            }
        }

        int countHorizontal = 0;
        int countVertical = 0;

        for (int i = 0; i < mas.length; i++) {
            if(mas[i][0] != 1000)
                countVertical++;
            for (int j = 0; j < mas[0].length; j++) {
               if(mas[i][j] != 1000)
                   countHorizontal++;
            }
        }

        countHorizontal /= countVertical;

        int [][] masResult = new int[countVertical][countHorizontal];
        int [] tempMas = new int[countHorizontal*countVertical];
        int tempForTempMas = 0;

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                if(mas[i][j] !=1000){
                    tempMas[tempForTempMas] = mas[i][j];
                    tempForTempMas++;
                }
            }
        }
        tempForTempMas = 0;
        for (int i = 0; i < masResult.length; i++) {
            for (int j = 0; j < masResult[0].length; j++) {
                masResult[i][j] = tempMas[tempForTempMas];
                tempForTempMas++;
            }
        }

        return masResult;
    }

    static int findMaxValue(int [][]massive) {

        int max = 0;
        for (int i = 0; i < massive.length; i++) {
            for (int j = 0; j < massive[0].length; j++) {
                if(massive[i][j] > max){
                    max  = massive[i][j];
                }
            }
        }
        return max;
    }
}






















