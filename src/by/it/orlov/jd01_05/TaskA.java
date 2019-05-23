package by.it.orlov.jd01_05;


public class TaskA {
    public static void main(String[] args) {
        System.out.println(task1(0.3, 756.13));
        System.out.println(task1_2(0.3, 756.13));
        System.out.println(task2(1.21, 0.371));
        task3(12.1);
    }
    static double task1(double x, double a){
        double first = Math.cos((Math.pow((Math.pow(x, 2)+(Math.PI/ 6)), 5)));
        double second = Math.sqrt(x*Math.pow(a, 3));
        double third = Math.log(Math.abs((a-(1.12*x))/4));
        double z = first - second - third;
        return z;

    }
    static double task1_2(double x, double a){
        double z = Math.cos((Math.pow((Math.pow(x, 2)+(Math.PI/ 6)), 5))) - Math.sqrt(x*Math.pow(a, 3)) - Math.log10(Math.abs((a-1.12*x)/4));
        return z;
    }
    static double task2(double a, double b){
        return (Math.tan(Math.pow(a, 2) + (2*a*b) + Math.pow(b, 2))) - Math.cbrt(a+1.5)+(a*Math.pow(b, 5)) - (b/(Math.log(Math.pow(a, 2))));
    }
    static void task3(double x){
        for (double a = -5; a <= 12 ; a+=3.75) {
            double f = Math.exp(a*x)-3.45*a;
            System.out.printf("При а=%4.2f f=%g\n", a,f);
        }
    }
}
