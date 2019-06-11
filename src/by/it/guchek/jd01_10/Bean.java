package by.it.guchek.jd01_10;

public class Bean {

    @Param(a=5,b=4)
    double sum(int a, int b){
        return a+b;
    }

    @Param(a=1,b=9)
    static double max(int a, int b){
        return a>b?a:b;
    }

    double min(int a, int b){
        return a<b?a:b;
    }

    @Param(a=14, b=10)
    static double avg(int a, int b){
        return (a+b)/2.0;
    }
}
