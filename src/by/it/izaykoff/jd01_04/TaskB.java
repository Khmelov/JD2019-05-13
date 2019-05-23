package by.it.izaykoff.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите число людей: ");
        int n = sc.nextInt();

        System.out.print("Введите фамилии: ");
        String[] lastName = new String[n];
        for (int i = 0; i < lastName.length; i++) {
            lastName[i] = sc.next();
        }

        int[] totalPay = new int[n];
        int[][] pay = new int[n][4];

        for (int i = 0; i < pay.length; i++) {
            System.out.println("Введите зарплату для " + lastName[i]);
            for (int j = 0; j < pay[i].length; j++) {
                pay[i][j] = sc.nextInt();
                totalPay[i] += pay[i][j];
            }
        }

        System.out.println("-------------------------------------------------------");
        System.out.printf("%-9s %-9s %-9s %-9s %-9s %-9s","Фамилия","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        System.out.println();
        System.out.println("-------------------------------------------------------");

        for (int i = 0; i < pay.length; i++) {
            System.out.printf("%-9s ",lastName[i]);

            for (int j = 0; j < pay[i].length; j++) {
                System.out.printf("%-9d ",pay[i][j]);;
            }
            System.out.printf("%-9d ",totalPay[i]);
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");
        int total = 0;
        for (int i = 0; i < totalPay.length; i++) {
            total+=totalPay[i];
        }
        System.out.printf("%-9s %-9d","Итого",total);
        double totalMid = Math.round(((double)total/(n*4))*10000.0)/10000.0 ;
        System.out.println();
        System.out.printf("%-9s %-9f","Средняя",totalMid);
    }
}
