package by.it.kobrinets.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[] name = new String[n];
        for (int i = 0; i < name.length; i++) {
            name[i] = scanner.next();
        }

        int salary[][] = new int[n][4];
        for (int j = 0; j < salary.length; j++) {
            System.out.println("Введите зарплату для " + name[j]);
            for (int i = 0; i < salary[j].length; i++) {
                int s1 = scanner.nextInt();
                salary[j][i] = s1;
            }
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("%-15s%-11s%-11s%-11s%-11s%-11s\n\r", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("----------------------------------------------------------------------");
        int sum = 0;
        for (int j = 0; j < salary.length; j++) {
            int sumStr = salary[j][0] + salary[j][1] + salary[j][2] + salary[j][3];
            System.out.printf("%-15s%-11s%-11s%-11s%-11s%-11s\n\r", name[j] + ":", salary[j][0], salary[j][1], salary[j][2], salary[j][3], sumStr);
            sum = sum + sumStr;
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("%-15s%-11s", "Итого", sum);
        System.out.printf("%-15s%-11.4f", "Средняя", (double)sum / (n * 4));




    }
}
