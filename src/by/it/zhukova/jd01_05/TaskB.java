package by.it.zhukova.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {

        math4();
        math5();
    }

    private static void math5() {
        double α = 0;
        double β = 0;
        for (double x = -5.5; x < 2; x += 0.5) {
            if ((-2 < (x / 2)) && ((x / 2) <= -1)) {
                β = sin(pow(x, 2));
            } else if ((-1 < (x / 2)) && ((x / 2) < 0.2)) {
                β = cos(pow(x, 2));
            } else if ((x / 2) == 0.2) {
                β = 1.0 / tan(pow(x, 2));
            }
            else {System.out.printf("\n при x/2=%1.1f вычислить не удалось", x/2);
            continue;}
            α = log10(abs(β+2.74));
            System.out.printf("\n при x/2=%1.1f α = %1f",x/2, α);
        }
    }

    private static void math4 () {
            for (double a = 0; a <= 2; a += 0.2) {
                double y = 0;
                for (int x = 1; x < 7; x++) {
                    y += pow(7, a) - cos(x);
                }
                System.out.printf("\n при а=%1.1f сумма y= %1f", a, y);
            }
        }


}
