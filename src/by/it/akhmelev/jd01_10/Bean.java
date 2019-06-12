package by.it.akhmelev.jd01_10;

public class Bean {

    @Override
    public String toString() {
        return "Bean{}";
    }

    @Param(a = 4, b = 70)
    static double sum(int one, int two) {
        return one + two;
    }

    @Param(a = 4, b = 70)
    static double max(int one, int two) {
        return one > two ? one : two;
    }

    double min(int one, int two) {
        return one < two ? one : two;
    }

    @Param(a = 4, b = 70)
    double avg(int one, int two) {
        return (one + two) / 2.0;
    }


}
