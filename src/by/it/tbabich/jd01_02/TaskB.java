package by.it.tbabich.jd01_02;

import java.util.Scanner;

public class TaskB {

    private static int[] mas = new int[10];
    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        step1();
        step2(sc.nextInt());
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        step3(a, b, c);
    }

    static void step1() {
        for (int i = 1; i <= 25; i++) {
            System.out.print(i + " ");
            if (i % 5 == 0) System.out.println();
        }
    }


    static void step2(int month) {

        String nameMonth;

        switch (month) {
            case 1:
                nameMonth = "январь";
                break;
            case 2:
                nameMonth = "февраль";
                break;
            case 3:
                nameMonth = "март";
                break;
            case 4:
                nameMonth = "апрель";
                break;
            case 5:
                nameMonth = "май";
                break;
            case 6:
                nameMonth = "июнь";
                break;
            case 7:
                nameMonth = "июль";
                break;
            case 8:
                nameMonth = "август";
                break;
            case 9:
                nameMonth = "сентябрь";
                break;
            case 10:
                nameMonth = "октябрь";
                break;
            case 11:
                nameMonth = "ноябрь";
                break;
            case 12:
                nameMonth = "декабрь";
                break;
            default:
                nameMonth = "нет такого месяца";
        }
        System.out.println(nameMonth);

    }


    static void step3(double a, double b, double c) {

        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) System.out.println((-b + Math.sqrt(discriminant)) / (2 * a) + " " + (-b - Math.sqrt(discriminant)) / (2 * a));
        else if (discriminant == 0) System.out.println(-b / (2 * a));
        else if (discriminant < 0) System.out.println("корней нет");

    }
}
