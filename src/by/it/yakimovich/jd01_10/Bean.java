package by.it.yakimovich.jd01_10;

public class Bean {
    @Param(a=1,b=6)
    double sum(int one, int two){
        return one+two;
    }
    static double max(int one, int two){
          return one>two? one: two;
    }
    @Param(a=3,b=4)
    static double min(int one, int two){
        return one<two? one: two;
    }
    @Param(a=6,b=2)
    double avg(int one, int two){
        return (one+two)/2.0;
    }

}
