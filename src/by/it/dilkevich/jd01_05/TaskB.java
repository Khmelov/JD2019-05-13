package by.it.dilkevich.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double y = 0;
        for (double a = 0; a <= 2; a = a + 0.2) {
            for (int x = 1; x <= 6; x++) {
                 y = y + pow(7,a) - cos(x);
            }
            System.out.printf("%5.2f  %g\n", a, y);
            y = 0;
        }
    }
    private static void step2(){
        double b = 0;
        double a = 0;
        for (double x = -6; x < 2; x = x+0.5) {

            if (x / 2 <= -1 &&  -2 < x/2) {
                b = sin(pow(x,2));
                a = log10(abs(b+2.74));
                System.out.printf("При x/2=%2.2f a = %g\n", x/2,a);
            } else if (x / 2 > -1 && x / 2 < 0.2) {
                b = cos(x * x);
                a = log10(abs(b+2.74));
                System.out.printf("При x/2=%2.2f a = %g\n", x/2,a);
            } else if (x / 2 == 0.2) {
                b = (cos(x) / sin(x))*(cos(x) / sin(x));
                a = log10(abs(b+2.74));
                System.out.printf("При x/2=%2.2f a = %g\n", x/2,a);
            }
            else
                System.out.printf("При x/2=%2.2f вычисления не определены\n", x/2);

        }
    }
}
