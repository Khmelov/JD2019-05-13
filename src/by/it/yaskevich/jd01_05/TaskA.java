package by.it.yaskevich.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    private static void task1() {
        double a = 756.13;
        double x = 0.3;
        double z = cos(pow(x * x + PI / 6, 5)) - sqrt(x * pow(a, 3)) - log(abs((a - 1.12 * x) / 4));
        System.out.printf("z=%f\n", z);
    }

    private static void task2() {
        double a = 1.21;
        double b = 0.371;
        double y = tan(pow(a + b, 2)) - cbrt(a + 1.5) + a * pow(b, 5) - b / log(a * a);
        System.out.printf("y=%f\n", y);
    }

    private static void task3() {
        double x = 12.1;
        double delta = 3.75;
        for (double a = -5; a <= 12; a += delta) {
            double y = exp(a * x) - 3.45 * a;
            System.out.printf("a=%6.2f y=%g\n", a, y);
        }
    }
}
