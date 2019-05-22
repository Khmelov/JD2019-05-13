package by.it.buymistrov.jd01_05;

public class TaskA {
    public static void main(String[] args) {


        double x = 0.3;
        double a = 756.13;
        double z = (Math.cos(Math.pow((Math.pow(x,2)+(Math.PI/6)),5))) - (Math.sqrt(x*Math.pow(a,3))) - Math.log(Math.abs((a-1.12*x)/4)) ;
        System.out.println(z);
        System.out.println();


        double a1 = 1.21;
        double b = 0.371;

        double y = (Math.tan(Math.pow((a1+b),2))) - (Math.cbrt(a1+1.5)) + (a1* Math.pow(b,5)) - (b/(Math.log(Math.pow(a1,2))));
        System.out.println(y);
    }
}
