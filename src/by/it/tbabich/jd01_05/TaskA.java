package by.it.tbabich.jd01_05;

import static java.lang.Math.*;

public class TaskA {

    public static void main(String[] args) {
        System.out.printf("z = %f\n", TaskA.step1a(756.13, 0.3));
        System.out.printf("z = %f\n", TaskA.step1b(756.13, 0.3));
        System.out.printf("y = %f\n", TaskA.step2(1.21, 0.371));
        step3(-5, 12, 3.75, 12.1);
    }

    static double step1a(double a, double x) {
        double part1 = cos(pow(pow(x, 2) + (PI / 6), 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log(abs((a - 1.12 * x) / 4));
        double z = part1 - part2 - part3;
        return z;
    }

    static double step1b(double a, double x) {
        double z = cos(pow(pow(x, 2) + (PI / 6), 5)) - sqrt(x * pow(a, 3)) - log(abs((a - 1.12 * x) / 4));
        return z;
    }

    static double step2(double a, double b) {
        double y = tan(pow(a + b, 2));
        y -= cbrt(a + 1.5);
        y += a * pow(b, 5);
        y -= b / log(pow(a, 2));
        return y;
    }

    static void step3(double left, double right, double step, double x) {
        for (double a = left; a <= right; a += step) {
            System.out.printf("a = %5.2f f = %f\n", a, pow(E, a * x) - 3.45 * a);
        }
    }

}
