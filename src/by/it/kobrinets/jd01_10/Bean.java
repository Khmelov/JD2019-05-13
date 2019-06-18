package by.it.kobrinets.jd01_10;

public class Bean {
    @Param(a = 2, b = 5)
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 7, b = 5)
    static double avg(int a, int b) {
        return (a + b) / 2.0;
    }

    @Param(a = 10, b = 5)
    double min(int a, int b) {
        if (a < b)
            return a;
        else return b;
    }

    double max(int a, int b) {
        if (a > b)
            return a;
        else return b;
    }

}
