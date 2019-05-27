package by.it.yaskevich.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        step1();
        int n = scanner.nextInt();
        step2(n);
        double a = scanner.nextDouble(), b = scanner.nextDouble(), c = scanner.nextDouble();
        step3(a, b, c);
    }

    private static void step3(double a, double b, double c) {
        double d = b * b - 4 * a * c;
        if (d > 0) {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println(x1 + " " + x2);
        } else if (d == 0) {
            double x = -b / (2 * a);
            System.out.println(x);
        } else {
            System.out.println("корней нет");
        }
    }

    private static void step2(int month) {
        String[] months = {"январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
        switch (month) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:{
                System.out.println(months[month - 1]);
                break;
            }
            default:
                System.out.println("нет такого месяца");
        }
    }

    private static void step1() {
        for (int i = 1; i <= 25; i++) {
            System.out.print(i + " ");
            if (i % 5 == 0) {
                System.out.println();
            }
        }
    }
}
