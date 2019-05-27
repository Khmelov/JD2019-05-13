package by.it.buymistrov.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] lastnames = new String[n];                 // массив фамилий
        System.out.println(lastnames.length);
        for (int i = 0; i < lastnames.length; i++) {
            lastnames[i] = sc.next();

        }

        int[][] profit = new int[n][4];

        for (int i = 0; i < profit.length; i++) {
            System.out.println("Введите зарплату для " + lastnames[i]);                     //зарплата для фамилий
            for (int j = 0; j < profit[i].length; j++) {

                profit[i][j] = sc.nextInt();

            }
        }

        int[] itog = new int[n];

        for (int i = 0; i < profit.length; i++) {
            for (int j = 0; j < profit[i].length; j++) {         //сумма выплат для каждого
                itog[i] = itog[i] + profit[i][j];
            }
        }

        int itogo = 0;
        for (int i : itog) {
            itogo += i;
        }
        System.out.println(itogo + " Сумма!");             // итого

        double avg;

        avg = (double) itogo / (4 * lastnames.length);
        double avg1 = (double) Math.round(avg * 10000d) / 10000d;         //средння выплата
        System.out.println(avg1);

        for (int[] ints : profit) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-15s%-11s%-11s%-11s%-11s%-11s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал 4", "Итого");
        System.out.println("----------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-15s%-11s%-11s%-11s%-11s%-11s%n", lastnames[i], profit[i][0], profit[i][1], profit[i][2], profit[i][3], itog[i]);

        }
        System.out.println("----------------------------------------------------------------");
        System.out.printf("%-10s%-11d%n", "Итого", itogo);
        System.out.printf("%-10s%-11f%n", "Средняя", avg1);


    }
}
