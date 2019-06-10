package by.it.orlov.jd01_10;

public class Bean {
    @Param(a=5, b =70)
    double sum(int one, int two){
        return one+two;
    }
    @Param(a=5, b =70)
    double max(int one, int two){
        if(one>two){
        return one;}
        else{
            return two;
        }
    }
    @Param(a=5, b =70)
    double awrg(int one, int two){
        return (one+two)/2;
    }
    
    double min(int one, int two){
        if(one<two){
            return one;
        }else {
            return two;
        }
    }
}
