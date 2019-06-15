package by.it.aadamovich.jd01_10;

class Bean {

    @Param(a = 3, b = 5)
    static double sum(int a, int b) {
        return a + b;
    }

    @Param(a = 7, b = -2)
    static double max(int a, int b) {
        return (a > b) ? a : b;
    }

    @Param(a = 11, b = 4)
    double min(int a, int b) {
        return (a < b) ? a : b;
    }

    double avg(int a, int b) {
        return (a + b) / 2.0;
    }
}
