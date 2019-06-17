package by.it.lasotskaya.jd01_10;

public class Bean {
    @Param(a=1, b=5)
    static double max (int one, int two){
        return one>two? one :two;
    }

    @Param(a=2, b=3)
    static double min (int one, int two){
        return one<two? one :two;
    }
    @Param(a=4, b=6)
    double sum (int one, int two){return one+two;}

    double avg (int one, int two){return (one+two)/2.0;}
}
