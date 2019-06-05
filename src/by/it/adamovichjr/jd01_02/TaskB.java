package by.it.adamovichjr.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        double a = scanner.nextInt();
        double b = scanner.nextInt();
        double c = scanner.nextInt();
        step1();
        step2(month);
        step3(a,b,c);
    }
    static void step1() {
        for (int i = 1; i <= 25; i++) {
            System.out.print(i + " ");
            if (i % 5 == 0)
                System.out.println();
        }
    }
    static void step2(int mon){
        switch (mon){
            case 1: {
                System.out.println("январь");
                break;
            }
            case 2: {
                System.out.println("февраль");
                break;
            }
            case 3: {
                System.out.println("март");
                break;
            }
            case 4: {
                System.out.println("апрель");
                break;
            }
            case 5: {
                System.out.println("май");
                break;
            }
            case 6: {
                System.out.println("июнь");
                break;
            }
            case 7: {
                System.out.println("июль");
                break;
            }
            case 8: {
                System.out.println("август");
                break;
            }
            case 9: {
                System.out.println("сентябрь");
                break;
            }
            case 10: {
                System.out.println("октябрь");
                break;
            }
            case 11: {
                System.out.println("ноябрь");
                break;
            }
            case 12: {
                System.out.println("декабрь");
                break;
            }
            default: {
                System.out.println("нет такого месяца");
            }

        }
    }
    static void step3 (double a, double b, double c){
        double x;
        double x1;
        double x2;
        if (a == 0)
            System.out.println("корней нет");
        else if (b !=0 && c == 0) {
            x1 = 0;
            x2 = -b / a;
            System.out.println("x1 = " + x1 + " " + "x2 = " + x2);
        }
        else if (c != 0 && b == 0){
            if (-c / a > 0){
                x1 = Math.sqrt(c / a);
                x2 = -(Math.sqrt(c / a));
                System.out.println("x1 = " + x1 + " " + "x2 = " + x2);
            }
            else if (-c / a < 0)
                System.out.println("корней нет");
        }
        else if (b == 0 && c == 0) {
            x = 0;
            System.out.println("x = " + x);
        }
        else if (b != 0 && c !=0){
            double d = b*b - 4*a*c;
            if (d > 0){
                x1 = (-b + Math.sqrt(d))/(2*a);
                x2 = (-b - Math.sqrt(d))/(2*a);
                System.out.println("x1 = " + x1 + " " + "x2 = " + x2);
            }
            else if (d == 0){
                x = -b / (2*a);
                System.out.println("x = " + x);
            }
            else if (d < 0)
                System.out.println("корней нет");
        }

    }
}
