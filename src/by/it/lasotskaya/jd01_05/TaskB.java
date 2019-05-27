package by.it.lasotskaya.jd01_05;
import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }
    private static void step1(){
        double sum;
        double x;
        double a;
        for ( a = 0.0; a <= 2.0; a = a + 0.2 ) {
            sum = 0;
            for ( x = 1.0; x <= 6.0; x++ ) {
                sum = sum + (pow(7, a) - cos(x));
            }
            System.out.println("sum=" + sum);
        }

    }

    private static void  step2(){
        double b=0;
        double a;
        double x;
       // a=log10(abs(b+2.74));
        for (x = -6.0; x < 2.0; x=x+0.5 ) {
            if(x/2> -2.0 && x/2<=-1.0 ){
                b=sin(pow(x,2));
            }
            else if (x/2> -1.0 && x/2<=-0.2 ){
               b=cos(pow(x,2));
            }
            else if(x/2==2.0){
                b=1/tan(pow(x,2));
            }
            a=log10(abs(b+2.74));

            System.out.println("Result is " +a + " when x = " + x);
            System.out.println();

        }

    }
}
