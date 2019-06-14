package by.it.trudnitski.jd01_10;

public class Bean {

    @Param(a=4,b=70)
    double sum(int a,int b){
        return a+b;
    }
    @Param(a=5,b=63)
    static double max(int a,int b){
        return a>b?a:b;
    }
     double min(int a,int b){
        return a<b?a:b;
    }
    @Param(a=34,b=95)
    static double avg(int a,int b){
        return (a+b)/2.0;
    }



}
