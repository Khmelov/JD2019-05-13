package by.it.livanovich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String [] name=new String [n];
        for (int i = 0; i < name.length; i++) {
            name[i] = sc.next();}
        int[][] wages = new int[n][4];
        for (int i = 0; i < wages.length; i++) {
            System.out.println("Введите зарплату "+ name[i]);
            for (int j = 0; j < wages[i].length; j++) {
                wages[i][j] = sc.nextInt();
            }
        }
        System.out.printf("%-8s %-8s %-8s %-8s %-8s %-5s", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println();
        System.out.println("--------------------------------------------------");
            int [] sum=new int [n];
            for (int k = 0; k < sum.length; k++) {
                sum[k] = wages[k][0] + wages[k][1] + wages[k][2] + wages[k][3];
                System.out.printf("%7s: %-8d %-8d %-8d %-8d %-5d", name[k], wages[k][0], wages[k][1], wages[k][2], wages[k][3], sum[k]);
                System.out.println();}
                System.out.println("--------------------------------------------------");
            int res;
        res = 0;
        for (int value : sum) {
            res += value;
        }
            System.out.printf("%-8s %-8d", "Итого",res);
            System.out.println();
            double avr = (double) res/(4*n);
        System.out.printf("%-8s %-8.4f", "Средняя", avr);
        System.out.println();
            }
}


