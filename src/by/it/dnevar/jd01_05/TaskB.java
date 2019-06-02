package by.it.dnevar.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1(){
        for (double a = 0; a <=2 ; a+=0.2) {
            double y = 0;
            for (double x = 1; x <= 6; x++) {
                y += pow(7,a)-cos(x);
            }
            System.out.printf("При a = %3.1f Сумма y = %g \n",a,y);
        }
    }

    private static void step2(){
        for (double x = -5.5; x < 2; x+=0.5) {
            if(x/2>-2 && x/2<=-1){
                double alfa = log10(abs(sin(pow(x,2)) + 2.74));
                System.out.printf("При x/2=%4.2f a = %g \n",x/2,alfa);
            }else if(x/2>-1 && x/2<0.2){
                double alfa = log10(abs(cos(pow(x,2)) + 2.74));
                System.out.printf("При x/2=%4.2f a = %g \n",x/2,alfa);
            }else if(x==0.2){
                double alfa = log10(abs(1.0/tan(pow(x,2)) + 2.74));
                System.out.printf("При x/2=%4.2f a = %g \n",x/2,alfa);
            }else{
                System.out.printf("При x/2=%4.2f вычисления не определены \n",x/2);
            }
        }

    }
}
