package by.it.lasotskaya.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        int tableSize=4;
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        String[] crew = new String[a];
        for (int i = 0; i < a; i++) {
            crew[i] = sc.next();
        }

        int[][] salaryTable = new int[a][tableSize];
        // int[][] res ;
        for (int i = 0; i < salaryTable.length; i++) {
            System.out.println("Введите зарплату для " + crew[i]);
            for (int j = 0; j < salaryTable[i].length; j++) {
                salaryTable[i][j] = sc.nextInt();
            }
        }

        printResults(crew,salaryTable,a);


    }


    private static void printResults(String[] mas, int[][] salary, int a) {
        System.out.printf("%-10s%-7s%-7s%-7s%-7s%-11s%n", "Фамилия ", "Квартал1 ", "Квартал2 ", "Квартал3 ", "Квартал4 ", "Итого ");
        System.out.println("-----------------------------------------------------");

        int sumResults=0;

        for (int i = 0; i < mas.length; i++) {
            int sum=0;
            System.out.printf("%-10s", mas[i]);
            for (int j = 0; j < 4; j++) {
                    System.out.printf("%-10d",salary[i][j]);
                sum += salary[i][j];
                sumResults+=salary[i][j];
                }
            System.out.printf("%-8d",sum);
            System.out.println();

        }
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-10s%-10d", "Итого",sumResults );
        System.out.println();
        double sumofSum = (double) sumResults;
        double avg = sumofSum / (4*a);
        System.out.printf("%-10s%-10.4f", "Средняя", avg);
            }

        }












