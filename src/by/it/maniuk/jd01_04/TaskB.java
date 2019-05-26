package by.it.maniuk.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = 4;
        int n = scanner.nextInt();
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            name[i] = scanner.next();
        }
        int[] salaryItog = new int[n];
        int[][] salary = new int[n][s];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для " + name[i]);
            for (int j = 0; j < s; j++) {
                salary[i][j] = scanner.nextInt();
            }

            for (int k = 0; k < n; k++) {
                int sum = 0;
                for (int l = 0; l < s; l++) {
                    sum = sum + salary[k][l];
                }
                salaryItog[k] = sum;
            }
        }
        int itogo =0;
        double middle =0;
        for (int j = 0; j <n ; j++) {
            itogo = itogo + salaryItog[j];
        }
        middle =  ((double)(itogo))/(n*s);

        for (int i = 0; i < 59; i++) {
            System.out.print("-");
        }
        System.out.println(" ");
        System.out.printf("%-9s %-10s %-10s %-10s %-10s %-5s", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println(" ");
        for (int i = 0; i < 59; i++) {
            System.out.print("-");
        }
        System.out.println(" ");
        for (int i = 0; i < n; i++) {
            System.out.printf("%8s", name[i]);
            System.out.print(":");
            System.out.printf("%-10d %-10d %-10d %-10d %-5d", salary[i][0], salary[i][1], salary[i][2], salary[i][3], salaryItog[i]);
            System.out.println("");
        }
        for (int i = 0; i < 59; i++) {
            System.out.print("-");
        }
        System.out.println(" ");
            System.out.printf("%-9s %-10d", "Итого" , itogo);
        System.out.println("");
            System.out.printf("%-9s %-10.5f","Средняя", middle);

    }

}


