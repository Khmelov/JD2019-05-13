package by.it.maniuk.jd01_05;


import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double y = 0;

        for (double a = 0.0; a <= 2.0; a = a + 0.2) {
            for (double x = 1; x <= 6; x++) {

                y += (pow(7, a) - cos(x));

            }

            System.out.println(y);
            y = 0;
        }

    }
    private static void step2(){
        double a=0;
        double b;

        for (double x=-5.5; x<2; x=x+0.5) {
            if ((-2 < (x / 2)) && ((x / 2) <= -1)) {
                b = sin((x * x));
                System.out.print(x/2+ " -");
                a += (log10(b + 2.74));
                System.out.println(a);
            } else if ((-1 <( x / 2) )&& ((x / 2) < 0.2)) {
                b = cos(x * x);
                System.out.print(x/2 + " -");
                a += log10(b + 2.74);
                System.out.println(a);
            } else if ((x/2) ==0.2){
                b= (1/tan(x*x));
                System.out.print(x/2+ " -");
                a += log10(b + 2.74);
                System.out.println(a);
            } else {
                System.out.println("Нет значения");
            }
        }

    }


}
//6.275648176029468
// 9.13028714559678