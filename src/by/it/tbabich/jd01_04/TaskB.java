package by.it.tbabich.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        String[] employees = new String[n];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = sc.nextLine();
        }

        int[][] salary = new int[n][4];

        int count = 0;
        for (int[] e : salary) {
            System.out.println("Введите зарплату для " + employees[count]);
            String line = sc.nextLine();
            convertStringToIntArray(line, e);
            count++;
        }

        printSalary(employees, salary);
    }

    static void convertStringToIntArray(String line, int[] salary) {
        line.trim();
        String[] stringArray = line.split(" ");
        for (int i = 0; i < stringArray.length; i++) {
            salary[i] = Integer.parseInt(stringArray[i]);
        }
    }

    static void printSalary(String[] employees, int[][] salary) {
        System.out.println("------------------------------------------------------------");
        System.out.printf("%10s%10s%10s%10s%10s%10s", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println();
        System.out.println("------------------------------------------------------------");
        int globalSumm = 0;
        for (int i = 0; i < salary.length; i++) {
            System.out.printf("%10s:", employees[i]);
            int summ = 0;
            for (int j = 0; j < salary[0].length; j++) {
                System.out.printf("%10d", salary[i][j]);
                summ += salary[i][j];
            }
            globalSumm += summ;
            System.out.printf("%10d", summ);
            System.out.println();
        }
        System.out.println("------------------------------------------------------------");
        System.out.printf("%10s%10d", "Итого", globalSumm);
        System.out.println();
        System.out.printf("%10s%10f", "Средняя", ((double)globalSumm / employees.length / 4));

    }
}
