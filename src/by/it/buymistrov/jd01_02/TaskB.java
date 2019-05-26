package by.it.buymistrov.jd01_02;

import java.util.Scanner;

public class TaskB {
    private static void step1() {
        for (int i = 0; i <= 25; i++) {
            System.out.print(i + " ");
            if (i % 5 == 0) System.out.println();
        }
    }

    private static void step2(int month) {
        String monthString;
        switch (month) {
            case 1:
                monthString = "январь";
                break;
            case 2:
                monthString = "февраль";
                break;
            case 3:
                monthString = "март";
                break;
            case 4:
                monthString = "апрель";
                break;
            case 5:
                monthString = "май";
                break;
            case 6:
                monthString = "июнь";
                break;
            case 7:
                monthString = "июль";
                break;
            case 8:
                monthString = "август";
                break;
            case 9:
                monthString = "сентябрь";
                break;
            case 10:
                monthString = "октябрь";
                break;
            case 11:
                monthString = "ноябрь";
                break;
            case 12:
                monthString = "декабрь";
                break;
            default:
                monthString = "нет такого месяца";
                break;
        }
        System.out.println(monthString);
    }

    private static void step3(double a, double b, double c) {
        double discriminant = (b * b) - 4 * a * c;
        if (discriminant == 0) {
            double x0 = (-b) / (2 * a);
            System.out.println(x0);
        }
        if (discriminant > 0) {
            double x1 = ((-b) + Math.sqrt(discriminant)) / (2 * a);
            double x2 = ((-b) - Math.sqrt(discriminant)) / (2 * a);
            System.out.println(x1 + " " + x2);
        }
        if (discriminant < 0)
            System.out.println("корней нет");
    }

    public static void main(String[] args) {
        step1();
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        step2(month);
        double a = sc.nextInt();
        double b = sc.nextInt();
        double c = sc.nextInt();
        step3(a, b, c);
    }
}
