package by.it.voitehovich.jd01_02;

import java.util.Scanner;

public class TaskB {
    static Scanner sc = new Scanner(System.in);

    private static void step1() {
        int[] mas = new int[25];
        int n = 5;
        for (int i = 0; i < mas.length; i++) {
            mas[i] = i + 1;
            System.out.print(mas[i] + " ");
            if ((i + 1) % n == 0) System.out.println();
        }
    }

    private static void step2(int month) {
        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
                default:
                    System.out.println("нет такого месяца");
        }
    }

    private static void step3(double a, double b, double c){
        double discriminant = b * b - 4 * a * c;
        if(discriminant > 0){
            double x1, x2;
            x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println(x1);
            System.out.println(x2);
        }else
        if(discriminant == 0) {
            double x = -(b / (2*a));
            System.out.println(x);
        }
        else System.out.println("корней нет");
    }


    public static void main(String[] args) {
        step1();
        int month = sc.nextInt();
        step2(month);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        step3(a,b,c);

    }
}
