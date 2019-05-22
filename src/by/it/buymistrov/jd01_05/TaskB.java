package by.it.buymistrov.jd01_05;

public class TaskB {

    private static void step1() {
        double y;
        double sum = 0;

        for (double i = 0; i <= 2; i += 0.2) {
            for (int j = 0; j <= 6; j++) {
                y = (Math.pow(7, i)) - (Math.cos(j));
                sum += y;
            }
            System.out.println("a = " + i + " сумма = " + sum);
        }


    }

    private static void step2() {

        double a ;
        double b ;


        for (double x = -5.5; x < 2; x += 0.5) {

            if (x / 2 > -2 && x / 2 <= -1)
                b = Math.sin(x * x);
            else if (x / 2 > -1 && x / 2 < 0.2)
                b = Math.cos(x * x);
            else if (x / 2 == 0.2)
                b = 1 / (Math.tan(x * x));
            else continue;

            a = Math.log10(Math.abs(b + 2.74));

            System.out.println("При х/2 = " + x / 2 + " a = " + a);
        }


    }

    public static void main(String[] args) {
        step1();
        System.out.println();
        step2();
    }
}
