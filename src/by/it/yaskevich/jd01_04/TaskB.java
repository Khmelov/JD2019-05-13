package by.it.yaskevich.jd01_04;

import java.util.Scanner;

public class TaskB {
    private static final int COUTN_QUARTER = 4;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        String[] surnames = enterSurnames(scanner, number);
        int[][] salaries = enterSalaries(scanner, number, surnames);

        printTable(number, surnames, salaries);
    }

    private static String[] enterSurnames(Scanner scanner, int number) {
        String[] surnames = new String[number];
        for (int i = 0; i < surnames.length; i++) {
            surnames[i] = scanner.next();
        }
        return surnames;
    }

    private static int[][] enterSalaries(Scanner scanner, int number, String[] surnames) {
        int[][] salaries = new int[number][COUTN_QUARTER];
        for (int i = 0; i < surnames.length; i++) {
            System.out.println("Введите зарплату для " + surnames[i]);
            for (int j = 0; j < COUTN_QUARTER; j++) {
                salaries[i][j] = scanner.nextInt();
            }
        }
        return salaries;
    }

    private static void printTable(int number, String[] surnames, int[][] salaries) {
        String delimiter = new String(new char[55]).replace("\0", "-");
        System.out.println(delimiter);
        System.out.printf("%-9s %-9s %-9s %-9s %-9s %-5s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println(delimiter);

        int yearSalary, sumTotal = 0;
        for (int i = 0; i < surnames.length; i++) {
            System.out.printf("%7s:  ", surnames[i]);
            yearSalary = 0;
            for (int j = 0; j < COUTN_QUARTER; j++) {
                yearSalary += salaries[i][j];
                System.out.printf("%-9d ", salaries[i][j]);
            }
            sumTotal += yearSalary;
            System.out.printf("%-5d\n", yearSalary);
        }

        System.out.println(delimiter);
        System.out.printf("%-9s %-9d\n", "Итого", sumTotal);
        System.out.printf("%-9s %-9.4f\n", "Средняя", (double)sumTotal / (number * COUTN_QUARTER));
    }
}
