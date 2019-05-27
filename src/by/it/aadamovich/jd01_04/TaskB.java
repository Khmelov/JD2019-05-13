package by.it.aadamovich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] surname = new String[n];
        for (int i = 0; i < surname.length; i++) {
            surname[i] = sc.next();
        }

        int[][] salary = new int[n][4];
        for (int i = 0; i < salary.length; i++) {
            System.out.println("Введите зарплату для " + surname[i]);
            for (int j = 0; j < salary[0].length; j++) {
                salary[i][j] = sc.nextInt();
            }
        }
        System.out.printf("%-15s%-8s %-8s %-8s %-8s %-5s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("-----------------------------------------------------");

        int sumTotal = 0;
        for (int i = 0; i < salary.length; i++) {
            int sumQuarter = salary[i][0] + salary[i][1] + salary[i][2] + salary[i][3];
            sumTotal = sumTotal + sumQuarter;
            System.out.printf("%-15s%-8d %-8d %-8d %-8d %-5d%n", surname[i] + ":", salary[i][0], salary[i][1], salary[i][2], salary[i][3], sumQuarter);
        }
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-15s%-8d%n", "Итого", sumTotal);
        double average = (double) sumTotal / (n * 4);
        System.out.printf("%-15s%-10.5f", "Средняя", average);
    }
}
