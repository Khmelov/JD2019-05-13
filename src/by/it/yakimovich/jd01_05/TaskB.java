package by.it.yakimovich.jd01_05;
import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {
        step1();
                step2();
    }

    private static void step1(){


             for (double a = 0; a <=2 ; a=a+0.2) {
             double sum=0;
              for (int x = 1; x <=6 ; x++) {
             sum=sum+pow(7,a)-cos(x);
            }
                 double s=sum;
                 System.out.printf("%-6s%-4.2f %-9s %10e","При a=",a,"Сумма y =",s);
                 System.out.println();
        }}

        private static void step2(){
            double b;
            for (double x = -5.5; x <2 ; x=x+0.5) {
                double a=x/2;
               if ((a)>-2 && (a)<=1)
                     b = sin(x * x);
                else if ((a)>-1 && (a)<0.2) {
                     b=cos(x*x);}

                else if ((a)==0.2) {
                   b=1/tan(x*x);}
                else {
                   System.out.printf("%10s %5s%3s%5s","При x/2=",x/2,"l=","нет решения");
                   System.out.println();
                   continue;}



                double l = log10(abs(b+2.74));
                System.out.printf("%10s %5s%3s%5e","При x/2=",x/2,"l=",l);
                System.out.println();
            }


    }
}
