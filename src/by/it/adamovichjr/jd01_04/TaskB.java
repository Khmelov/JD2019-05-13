package by.it.adamovichjr.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] lastName = new String[n];
        for (int i = 0; i < lastName.length; i++) {lastName[i] = scanner.next();}

        int[][]zp = new int[n][4];
        int[] itogo = new int[n];
        for (int i = 0; i < zp.length; i++) {
            System.out.println("Введите зарплату для " + lastName[i]);
            for (int j = 0; j < zp[0].length; j++) {
                zp[i][j] = scanner.nextInt();
                itogo[i] += zp[i][j];
            }
        }
        int allItogo = 0;
        for (int i = 0; i < itogo.length; i++) {
            allItogo += itogo[i];
        }

        double averge = (double) allItogo / (n*4);

        System.out.printf("%-10s%-9s%-9s%-9s%-9s%-6s%n","Фамилия","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < zp.length; i++) {
            System.out.printf("%-10s%-9d%-9d%-9d%-9d%-6d%n",lastName[i]+":",zp[i][0],zp[i][1],zp[i][2],zp[i][3],itogo[i]);
        }
        System.out.println("-----------------------------------------------");
        System.out.printf("%-10s%-9d%n","Итого",allItogo);
        System.out.printf("%-10s%-9f%n","Средняя",averge);


    }

}
