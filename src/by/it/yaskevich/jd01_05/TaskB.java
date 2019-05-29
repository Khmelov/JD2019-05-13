package by.it.yaskevich.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        task4();
        task5();
    }

    private static void task4() {
        double delta = 0.2;
        for (double a = 0; a < 2; a += delta) {
            double y = 0;
            for (int i = 1; i <= 6; i++) {
                y += (pow(7, a) - cos(i));
            }
            System.out.printf("a=%.2f y=%e\n", a, y);
        }
        System.out.println();
    }

    private static void task5() {
        double delta = 0.5;
        for (double x = -6 + delta; x < 2; x += delta) {

            double beta = 0;
            double half = x / 2;
            if ((half > -2) && (half <= -1)) {
                beta = sin(x * x);
            } else if ((half > -1) && (half < 0.2)) {
                beta = cos(x * x);
            } else if (half == 0.2) {
                beta = 1 / tan(x * x);
            } else {
                System.out.printf("x/2=%.2f вычисления не определены\n", half);
                continue;
            }

            double alpha = log10(abs(beta + 2.74));
            System.out.printf("x/2=%.2f a=%e\n", half, alpha);
        }
        System.out.println();
    }
}
