package by.it.aadamovich.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {

        task1();
        task2();
        task3();
    }

    private static void task1() {

        double x = 0.3, a = 756.13;

        double z1 = cos(pow(pow(x, 2) + PI / 6, 5));
        double z2 = sqrt(x * pow(a, 3));
        double z3 = log(abs((a - 1.12 * x) / 4));

        double z = z1 - z2 - z3;

        System.out.printf("z = %f", z);
    }

    private static void task2() {

        double a = 1.21, b = 0.371;

        double y = tan(pow(a + b, 2)) - cbrt(a + 1.5) + a * pow(b, 5) - b / log(pow(a, 2));

        System.out.printf(" y = %f", y);
    }

    private static void task3() {

        double x = 12.1;

        for (double a = -5; a <= 12; a = a + 3.75) {
            double f = exp(a * x) - 3.45 * a;
            System.out.printf("При а=%-5.2f f=%g%n", a, f);
        }
    }
}
