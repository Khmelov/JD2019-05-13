package by.it.izaykoff.jd01_10;

public class Bean {

    @Param(a=12,b=21)
    static double sum (int first,int second){
        return first + second;
    }

    @Param(a=12,b=21)
    static double max (int first,int second){
        return first > second ? first : second;
    }

    @Param(a=12,b=21)
    double min (int first,int second){
        return first < second ? first : second;
    }

    double avg (int first,int second){
        return (first + second) / 2.0;
    }

}
