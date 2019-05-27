package by.it.kobrinets.jd01_05;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0; a <= 2; a = a + 0.2) {
            double y = 0;
            for (int x = 1; x <= 6; x++) {
                y = y + (Math.pow(7.0, a)) - Math.cos(x);

            }
            System.out.printf("При a = %.2f Сумма y = %g\n", a, y);

        }

    }


    private static void step2() {

        double a, b;

        for (double x = -5.5; x < 2; x = x + 0.5) {
            if (x / 2 > -2 && x / 2 <= -1) {
                b = Math.sin(Math.pow(x, 2));
            } else if (x / 2 > -1 && x / 2 < 0.2) {
                b = Math.cos(Math.pow(x, 2));
            } else if (x / 2 == 0.2) {
                b = 1 / (Math.tan(Math.pow(x, 2)));
            } else continue;

            a = Math.log10(Math.abs(b + 2.74));

            System.out.printf("%s%-1.2f%s=%-5.10f\n", "При x/2=", x / 2, " a", a);

        }

    }
}

