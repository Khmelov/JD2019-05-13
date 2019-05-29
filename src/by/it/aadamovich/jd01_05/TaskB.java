package by.it.aadamovich.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        task4();
        task5();


    }

    private static void task4() {

        for (double a = 0; a < 2; a += 0.2) {
            double y = 0;
            for (int x = 1; x <= 6; x++) {

                y += pow(7, a) - cos(x);
            }
            System.out.printf("При а=%-3.1f y=%g%n", a, y);
        }
        System.out.println();
    }

    private static void task5() {

        for (double x = -5.5; x < 2; x += 0.5) {
            double b = 0;
            if ((-2 < x / 2) && (x / 2 <= -1)) {
                b = sin(pow(x, 2));
            } else if ((-1 < x / 2) && (x / 2 < 0.2)) {
                b = cos(pow(x, 2));
            } else if (x / 2 == 2) {
                b = pow(atan(x), 2);
            } else {
                System.out.printf("При x/2=%.2f вычисление функции невозможно%n", x / 2);
                continue;
            }

            double a = log10(abs(b + 2.74));
            System.out.printf("При x/2=%.2f \u03B1=%g%n", x / 2, a);
        }
    }
}


