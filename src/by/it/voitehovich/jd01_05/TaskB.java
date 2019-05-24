package by.it.voitehovich.jd01_05;
import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double y = 0;
        for (double a = 0; a <=2 ; a +=0.2) {
            for ( int x =1 ;x<=6;x++){
                y+= pow(7,a) - cos(x);
            }
            System.out.println("Sum  y=" + y);
        }
    }

    private static void step2() {
        double a,b;
        for (double x = -5.5; x < 2; x+=0.5) {
            if( x/2<=-1 && x/2>-2) b = sin(x*x);
            else if( x/2 < 0.2 && x/2 >-1) b=cos(x*x);
            else if ( x/2 == 0.2) b= (double)1/tan(x*x);
            else {
                System.out.printf("При x/2=%-3.2f Вычисления не определены%n", x/2);
                continue;
            }
            a = log10(abs(b+2.74));
            System.out.printf("При x/2 =%-3.2f a=%-10.7f%n", x/2.0,a);

        }
    }

}
