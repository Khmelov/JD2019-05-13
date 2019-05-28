package by.it.livanovich.jd01_05;
import static java.lang.Math.*;
public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double a;
        int x;
        double y = 0;
        for (a = 0; a <= 2; a = a + 0.2) {
            for (x = 1; x <= 6; x = x + 1) {
                y = y + (7 * a - cos(x));
            }
            System.out.printf("При а=%-6.2f y=%g\b", a, y);
            System.out.println();
        }
    }

    private static void step2() {
        double x;
        double a;
        double b;
        for (x = -5.5; x < 2; x = x + 0.5) {
            if (x/2<=-2 || x/2>0.2){
                System.out.printf("При х/2=%-4.2f вычисления не определены\n", x / 2);
            }
            else if (x / 2 > -2 && x / 2 <= -1) {
                b = sin(pow(x, 2));
                a = log10(abs(b + 2.74));
                System.out.printf("При х/2=%-4.2f a = %g\n", x / 2, a);}
            else if (x / 2 >  -1 && x / 2 < 0.2){
                b = cos(pow(x, 2));
                a = log10(abs(b + 2.74));
                System.out.printf("При х/2=%-4.2f a = %g\n", x / 2, a);}
            else if (x / 2 == 0.2) {
                b = 1 / tan(pow(x, 2));
                a = log10(abs(b + 2.74));
                System.out.printf("При х/2=%-4.2f a = %g\n", x / 2, a);}
        }
    }
    }



