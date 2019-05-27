package by.it.gavrilovec.jd01_02;
import java.util.Scanner;
import java.util.Random;
public class TaskC {

   private static int[ ][ ] step1(int n){
        int[][] arr=new int[n][n];
        Random rand=new Random();
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                arr[i][j]=rand.nextInt(2*n+1)-n;
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }

        return arr;
    }

    private static int step2(int[ ][ ] mas){
        int sumMatrix=0;
        for (int [] i:mas) {
            int sumRow=0;
            int counter=0;
            for (int j:i) {
                if(j>0) counter++;
                if(counter==2) break;
                if(j<=0&&counter==1) sumRow+=j;
            }
            if(counter==2) sumMatrix+=sumRow;

        }
        System.out.println(sumMatrix);
        return sumMatrix;
    }

    private static int[ ][ ] step3(int[ ][ ] mas){
        int max=0;
        for (int [] i:mas) {
            for (int j: i) {
                if(max<j) max=j;
            }
        }
        boolean[] rows=new boolean[mas.length];
        int newRows=rows.length;
        boolean[] colons=new boolean[mas.length];
        int newColons=colons.length;
        for (int i = 0; i <mas.length; i++) {
            for (int j = 0; j <mas.length ; j++) {
                if(max==mas[i][j]) {
                    if(!rows[i]) {
                        rows[i] = true;
                        newRows--;
                    }
                    if(!colons[j]) {
                        colons[j] = true;
                        newColons--;
                    }
                }
            }
        }

        int[][] newMatrix=new int[newRows][newColons];
        newRows=0;

        for (int i = 0; i<mas.length ; i++) {
            if(rows[i]) continue;
            newColons=0;
            for (int j = 0; j < mas.length; j++) {
                if(colons[j]) continue;
                newMatrix[newRows][newColons]=mas[i][j];
                System.out.print(newMatrix[newRows][newColons]+"\t");
                newColons++;
            }
            System.out.println();
            newRows++;
        }

        return newMatrix;
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int[][] arr=step1(n);
      int sumSpecial=step2(arr);

        int[][] newMatrix=step3(arr);





    }
}
