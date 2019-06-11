package by.it.yaskevich.jd01_10;

class Bean {
    @Param(a = 5, b = 70)
    static double sum(int one, int two) {
        return one + two;
    }

    @Param(a = 5, b = 70)
    static double max(int one, int two) {
        return one > two ? one : two;
    }

    @Param(a = 5, b = 70)
    double min(int one, int two) {
        return one < two ? one : two;
    }

    double avg(int one, int two) {
        return (one + two) / 2.0;
    }
}
