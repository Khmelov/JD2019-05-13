package by.it.gavrilovec.jd01_02;
import java.util.Scanner;
public class TaskB {

    private static void step1(){
        for (int i = 1; i <=25; i++) {
            System.out.print(i+" ");
            if(i%5==0) System.out.println();
        }
    }

    private static void step2(int month){
        String s;
        switch(month){
            case 1: s="январь";
            break;
            case 2: s="февраль";
                break;
            case 3: s="март";
                break;
            case 4: s="апрель";
                break;
            case 5: s="май";
                break;
            case 6: s="июнь";
                break;
            case 7: s="июль";
                break;
            case 8: s="август";
                break;
            case 9: s="сентябрь";
                break;
            case 10: s="октябрь";
                break;
            case 11: s="ноябрь";
                break;
            case 12: s="декабрь";
                break;
            default: s="нет такого месяца";
        }
        System.out.println(s);

    }

   private static void step3(double a, double b, double c){
        double d=b*b-4*a*c;
        double x1=(-b+Math.sqrt(d))/(2*a);
        double x2=(-b-Math.sqrt(d))/(2*a);
       if(d>0) System.out.println(x1+" "+x2);
        if(d==0) System.out.println(x1);
        if(d<0) System.out.println("корней нет");

    }

    public static void main(String[] args) {
     step1();
        Scanner scan=new Scanner(System.in);
      int month=scan.nextInt();
      step2(month);
        double a=scan.nextDouble();
        double b=scan.nextDouble();
        double c=scan.nextDouble();
        step3(a, b, c);
    }

}
