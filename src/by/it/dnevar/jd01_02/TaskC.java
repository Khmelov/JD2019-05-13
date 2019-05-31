package by.it.dnevar.jd01_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int i = sc.nextInt();

        int[][] array = step1(i);
        for (int j = 0; j < array.length; j++) {
            System.out.print("\n");
            for (int k = 0; k < array[j].length; k++) {
                System.out.print(array[j][k] + " ");
            }

        }
        System.out.println("\n");

        int sum = step2(array);
        System.out.println("Сумма: " + sum);

        int[][] smallArray = step3(array);


    }

    private static int[ ][ ] step1(int n){
        int[][] mas = new int[n][n];
        boolean minNum = false;
        boolean maxNum = false;
        Random rnd = new Random(System.currentTimeMillis());

        while (true) {
            minNum = false;
            maxNum = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = -n + rnd.nextInt(n - (-n) + 1);
                    if (mas[i][j] == -n){
                        minNum = true;
                    }else if(mas[i][j] == n){
                        maxNum = true;
                    }
                }
            }
            if (minNum && maxNum){
                return mas;
            }
        }


    }

    private static int step2(int[ ][ ] mas){
        int sum = 0;

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j]>0){
                    for (int k = j+1; k < mas[i].length; k++) {
                        if(mas[i][k]<=0){
                            sum = sum + mas[i][k];
                        } else{
                            break;
                        }
                        break;
                    }
                }
            }
        }

        return sum;
    }

    public static int[ ][ ] step3(int[ ][ ] mas){

        List<Integer> listStrk = new ArrayList<>();
        List<Integer> listStlb = new ArrayList<>();

        int max = mas[0][0];

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] >max){
                    max=mas[i][j];
                }
            }
        }

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == max){
                    if(!listStrk.contains(i)){
                        listStrk.add(i);

                    }
                    if(!listStlb.contains(j)){
                        listStlb.add(j);

                    }
                }
            }
        }

        int[][] smallMas = new int[mas.length - listStrk.size()][mas.length- listStlb.size()];

        int counter1 = 0;
        for (int i = 0; i < mas.length; i++) {
            if(!listStrk.contains(i)){
                int counter2 = 0;
                for (int j = 0; j < mas[i].length; j++) {
                    if(!listStlb.contains(j)){
                        smallMas[counter1][counter2]=mas[i][j];
                        counter2++;


                    }
                }
                counter1++;
            }


        }
        for (int j = 0; j < smallMas.length; j++) {
            System.out.print("\n");
            for (int k = 0; k < smallMas[j].length; k++) {
                System.out.print(smallMas[j][k] + " ");
            }

        }
        return smallMas;
    }

}
