package by.it.tbabich.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1(0, 2, 0.2);
        step2(-6, 2, 0.5);
    }

    static void step1(double left, double right, double step) {
        double y = Double.MIN_VALUE;
        for (double a = left; a <= right; a += step) {
            for (int x = 1; x <= 6; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.printf("a = %5.2f f = %f\n", a, y);
            y = Double.MIN_VALUE;
        }
    }

    static void step2(double left, double right, double step) {
        double beta = Double.MIN_VALUE;
        for (double x = left + step; x < right; x += step) {
            if (x / 2 <= -2) {
                System.out.printf("x/2 = %5.2f %s\n", x / 2, "вычисления не определены");
                continue;
            }
            else if (x / 2 > -2 && x / 2 <= -1) beta = sin(pow(x, 2));
            else if (x / 2 > -1 && x / 2 <= 0.2) beta = cos(pow(x, 2));
            else if (x / 2 == 0.2) beta = tanh(pow(x, 2));

            System.out.printf("x/2 = %5.2f a = %f\n", x / 2, log10(abs(beta + 2.74)));
        }
    }


}
