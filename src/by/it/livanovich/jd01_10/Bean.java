package by.it.livanovich.jd01_10;

public class Bean {
    @Param(a=2,b=5)
    public  static double avg (int a, int b){
        return (a+b)/2.0;
    }
    @Param(a=2,b=5)
    public double sum (int a, int b){
        return a+b;
    }

    public static double min (int a, int b){

        return a>b?b:a;
    }
    @Param(a=2,b=5)
    public double max (int a, int b){
        return a>b?a:b;
    }
}
