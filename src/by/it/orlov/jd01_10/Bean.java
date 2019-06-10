package by.it.orlov.jd01_10;

public class Bean {
    @Param(a=5, b =70)
    static double sum(int one, int two){
        return one+two;
    }
    @Param(a=5, b =70)
    static double max(int one, int two){
        if(one>two){
        return one;}
        else{
            return two;
        }
    }
    @Param(a=5, b =70)
    double avg(int one, int two){
        return (double) (one+two)/2;
    }

    double min(int one, int two){
        if(one<two){
            return one;
        }else {
            return two;
        }
    }
}
