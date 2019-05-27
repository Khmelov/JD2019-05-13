package by.it.dilkevich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String []surnameMas = new String[n];
        for (int i = 0; i < n; i++) {
            surnameMas[i] = scanner.next();
        }
        int[][] salary = new int[n][4];
        int[] tempMasForInt = new int[4];
        for (int k = 0; k < salary.length; k++) {

            System.out.println("Введите зарплату для " + surnameMas[k]);
            Scanner scanner1 = new Scanner(System.in);

            int tempMas[] = new int[4];
            for (int i = 0; i < 4; i++) {
                tempMas[i] =scanner.nextInt();
            }
            for (int i = k; i < salary.length; i++) {
               for (int j = 0; j < salary[0].length; j++) {
                   salary[i][j] = tempMas[j];
             }
            }
        }
        for (int i = 0; i < salary.length; i++) {
            for (int j = 0; j < salary[0].length; j++) {
            }
        }
        int total = 0;
        double average = 0;
        System.out.println("-----------------------------------------------------------------------");
        System.out.printf("%-10s%-13s%-13s%-13s%-13s%-7s", "Фамилия","Квартал 1","Квартал 2","Квартал 3","Квартал 4", "Итого");
        System.out.println();
        for (int i = 0; i < salary.length; i++) {

            int sum = salary[i][0] + salary[i][1] + salary[i][2] + salary[i][3];
                System.out.printf("%-10s%-13d%-13d%-13d%-13d%-7d", surnameMas[i],salary[i][0],salary[i][1],salary[i][2],salary[i][3], sum);
            System.out.println();
            total+=sum;
        }
        System.out.println("-----------------------------------------------------------------------");
        average=(double) total/(n*4);
        System.out.printf("%-10s%-13d","Итого", total );
        System.out.println();
        System.out.printf("%-10s%-13.4f","Средняя", average );
    }

}
