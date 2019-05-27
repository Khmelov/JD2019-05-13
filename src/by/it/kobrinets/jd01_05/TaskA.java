package by.it.kobrinets.jd01_05;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();

    }

    private static void step1() {
        double a = 756.13;
        double x = 0.3;

        double part1 = Math.cos(Math.pow(x * x + (Math.PI / 6),5));
        double part2 = Math.sqrt(x * Math.pow(a,3));
        double part3 = Math.log(Math.abs((a - 1.12 * x) / 4));
        double z = part1 - part2 - part3;

        System.out.println(z);
    }
    private static void step2() {
        double a = 1.21;
        double b = 0.371;

        double y = Math.tan(Math.pow(a + b,2)) - Math.cbrt(a + 1.5) + a * Math.pow(b, 5) - b / Math.log(Math.pow(a, 2));
        System.out.println(y);
    }

    private static void step3() {
        double x = 12.1;
        for (double i = -5; i <= 12; i = i + 3.75){
double f = Math.exp(i * x)-3.45 * i;
            System.out.printf("При а=%6.2f f=%g\n", i, f);
        }
    }

}
