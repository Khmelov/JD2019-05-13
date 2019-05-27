package by.it.gavrilovec.jd01_05;
import static java.lang.Math.*;
public class TaskB {
    public static void main(String[] args) {
        double y=0;
        for(double a=0;a<=2;a+=0.2){
            for(double x=1;x<7;x++){
                y+=pow(7,a)-cos(x);
                System.out.printf("При a=%f Сумма y =%f\n",a,y);
            }
        }
        double a=0;
        for(double x=-5.5;x<2;x+=0.5){
            if(x/2>-2&& x / 2 <= 0.2){
                if(x/2>-2&&x/2<=-1) a = log10(abs(sin(pow(x, 2)) + 2.74));
                if (x / 2 > -1 && x / 2 < 0.2) a = log10(abs(cos(pow(x, 2)) + 2.74));
                if (x / 2 == 0.2) a = log10(abs(1.0 / tan(pow(x, 2)) + 2.74));
                System.out.printf("При x/2=%.2f a = %f\n", x / 2, a);
        }
            else System.out.printf("При x/2=%.2f вычисления не определены\n", x / 2);
        }


    }
}



