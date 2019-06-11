package by.it.guchek.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] mas1 = TaskC.step1(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mas1[i][j] + " ");
            }
            System.out.println();
        }
        int sum1= TaskC.step2(mas1);
        System.out.println("Cумма элементов между двумя положительными:"+sum1);
        step3(mas1);
    }


    private static int[][] step1(int n) {
        int[][] mas = new int[n][n];
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

    private static int step2(int[ ][ ] mas){
        int sum=0;

        for (int i = 0; i <mas.length ; i++) {
            for (int j = 0; j <mas[i].length ; j++) {
                if (mas[i][j]>0) {
                    for (int k = j+1; k <mas[i].length ; k++) {
                        if (mas[i][k]<=0){
                        sum =sum + mas [i][k];
                        }
                        else {
                        break;
                        }
                    break;
                    }
                }
             }
        }
        return sum;
    }

    static int[ ][ ] step3(int[ ][ ] mas){
        int max=TaskC.getMaxElem(mas);

        boolean[] delRow = new boolean[mas.length];
        boolean[] delCol = new boolean[mas[0].length];

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == max) {
                    delRow[i] = true;
                    delCol[j] = true;
                }
            }
        }

        int ir = mas.length;                          //уменьшаем количество строк результирующей матрицы
        for (boolean del : delRow) if (del) ir--;
        int jr = mas[0].length;
        for (boolean del : delCol) if (del) jr--;     //уменьшаем количество столбцов результирующей матрицы

        int[][] res = new int[ir][jr];                //размер результирующей матрицы

        int indexRow = 0;
        for (int i = 0; i < mas.length; i++) {
            if (!delRow[i]) {
                int indexCol = 0;
                for (int j = 0; j < mas[i].length; j++) {
                    if (!delCol[j]) {
                        res[indexRow][indexCol] = mas[i][j];
                        indexCol++;
                    }
                }
                indexRow++;
            }
        }

        for (int[] row : res) {
            for (int elem : row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }

        return res;
    }

    private static int getMaxElem(int[][] mas) {
        int max = Integer.MIN_VALUE;
        for (int[] row : mas) {
            for (int elem : row) {
                if (max < elem)
                    max = elem;
            }
        }
        return max;
    }
}
