package by.it.adamovichjr.jd01_02;

import java.util.*;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        /*Random rand = new Random();

        int[][] mas = new int[n][n];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = rand.nextInt(2 * n + 1) - n;
            }
        }*/


        int[][]test = {{3, 5, 3}, {3, -1, 1}, {1, 3, -3,}};
        printMas(test);
        System.out.println();
        int[][] mas2 = step1(n);

        System.out.println();
        step2(mas2);

        System.out.println();
        step3(test);



    }

    static int[][]step1 (int n){
        Random rand = new Random();
        int[][]massiv = new int[n][n];
        boolean plusN =true;
        boolean minusN =true;
        while (plusN || minusN){
            for (int i = 0; i < massiv.length; i++) {
                for (int j = 0; j < massiv.length; j++) {
                    massiv[i][j] = rand.nextInt(2 * n + 1) - n;
                    if(massiv[i][j] == n){plusN = false;}
                    if(massiv[i][j] == -n){minusN = false;}
                }

            }
        }
        printMas(massiv);

        return massiv;
    }

    static int step2(int[][]mas){
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0;j < mas.length; ){
                if(mas[i][j] <= 0){
                    j++;
                }
                else if (mas[i][j] > 0 && j != mas.length-1){

                    j++;
                    while (mas[i][j] <= 0){
                        sum = sum + mas[i][j];
                        if(j == mas.length-1)
                            break;
                        else
                            j++;
                    }
                    break;
                }

            }
        }
        System.out.println("сумма = " + sum);
        return sum;

    }

    static int[][]step3(int[][]mas){
        int stolbSize = indexStolb(mas).size();
        int strokSize = indexStrok(mas).size();
        int[] stolb = hashsetToM(indexStolb(mas));
        int[] strok = hashsetToM(indexStrok(mas));
        int[][] newMass = new int[mas.length - strokSize][mas.length - stolbSize];
        changeStolb(mas,stolb);
        changeStrok(mas,strok);
        ArrayList<Integer>list = listMas(mas);
        int[][] finaly = finalMas(newMass,list);
        printMas(finaly);
        return finaly;

    }

    static int maxValue(int[][]mas){
        int max = mas[0][0];
        for (int i = 0; i < mas.length; i++) {
            for(int j =0; j < mas.length; j++){
                if (mas[i][j] > max)
                    max = mas[i][j];
            }
        }
        return max;

    }

    static HashSet indexStolb(int[][]mas){
        HashSet<Integer>column = new HashSet<>();
        int max = maxValue(mas);
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if(mas[i][j] == max){
                    column.add(j);
                }
            }

        }
        return column;
    }
    static HashSet indexStrok(int[][]mas){
        HashSet<Integer>row = new HashSet<>();
        int max = maxValue(mas);
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if(mas[i][j] == max){
                    row.add(i);
                }
            }

        }
        return row;
    }

    static int[]hashsetToM(HashSet<Integer>set){
        int size = set.size();
        int []mas = new int[size];
        ArrayList<Integer>list = new ArrayList<>(size);
        for (Integer i : set) {
            list.add(i);
        }

        for (int i = 0; i < mas.length; i++) {
            mas[i] = list.get(i);
        }
        return mas;
    }

    static void changeStolb (int[][]mas, int[] stolb){
        for (int i = 0; i < stolb.length; i++) {

            for (int j = 0; j < mas.length; j++) {
                for (int k = 0; k < mas.length; k++) {
                    if (stolb[i] == k)
                        mas[j][k] = mas.length * 10;
                }
            }
        }

    }

    static void changeStrok (int[][]mas, int[] strok){
        for (int i = 0; i < strok.length; i++) {

            for (int j = 0; j < mas.length; j++) {
                for (int k = 0; k < mas.length; k++) {
                    if (strok[i] == j)
                        mas[j][k] = mas.length * 10;
                }
            }
        }

    }



    static ArrayList<Integer> listMas(int[][]oldMas){
        ArrayList<Integer>list = new ArrayList<>();
        for (int i = 0; i < oldMas.length; i++) {
            for (int j = 0; j < oldMas.length; j++) {
                if(oldMas[i][j] != oldMas.length*10)
                    list.add(oldMas[i][j]);
            }
        }
        return list;
    }


    static int[][]finalMas(int[][]mas, ArrayList<Integer>list){
        int count = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = list.get(count);
                count++;
            }
        }
        return mas;
    }

    public static void printMas(int[][]mas){
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                System.out.print(mas[i][j] + " ");
                if(j == mas[0].length - 1){
                    System.out.println();
                }
            }

        }
    }



    public static void printToM(int[]mas){
        String s = "";
        for (int i = 0; i < mas.length; i++) {

            s += mas[i] + " ";
        }
        System.out.print(s);
    }

}