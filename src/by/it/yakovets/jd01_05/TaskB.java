package by.it.yakovets.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step4();
        System.out.println();
        step5();
    }

    static void step4() {
        for (double a = 0; a <= 2; a = a + 0.2) {
            double y = 0;
            for (int x = 1; x <= 6; x++) {
                y = y + (pow(7, a) - cos(x));
            }
            System.out.printf("При a=%3.2f Сумма x=%g\n", a, y);
        }
    }

    static void step5() {
        for (double x = -5.5; x < 2; x = x + 0.5) {
            double b = 0;
            if (-2<(x / 2)  && ((x / 2) <= -1)) {
                b = sin(pow(x, 2));
            } else if (-1<(x / 2)  && (x / 2) < 0.2) {
                b = cos(pow(x, 2));
            } else if (x/2==0.2) {
                b = cos(pow(x, 2)) / sin(pow(x, 2));}
                double a = log10(abs(b + 2.74));
                System.out.printf("При x/2=%4.2f a=%e\n", x / 2, a);

        }
    }
}
