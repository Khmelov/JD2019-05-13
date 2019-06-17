package by.it.adamovichjr.jd01_10;

public class Bean {
    @Param(a = 5, b = 7)
    static double sum (int a, int b){
        return a + b;
    }
    @Param(a=10, b=70)
    double avg (int a, int b){
        return (a + b) / 2.0;
    }
    @Param(a=500, b=700)
    double min (int a, int b){
        return a < b ? a:b;
    }
    static double max (int a, int b){
        return a < b ? b:a;
    }

}
