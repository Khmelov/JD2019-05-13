package by.it.yakovets.jd01_10;

public class Bean {
@Param(a=4,b=6)
    static double sum(int one, int two) {
        return one + two;
    }
    @Param(a=4,b=6)
    static double max(int one, int two) {
        return one > two ? one : two;
    }
    @Param(a=4,b=6)
    double min(int one, int two) {
        return one < two ? one : two;
    }
    @Param(a=4,b=6)
    double avg(int one, int two) {
        return (one + two)/2;
    }

}
