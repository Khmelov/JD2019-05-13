package by.it.zhukova.jd01_10;

public class Bean {

    @Param(a = 2, b = 4)
   public static double sum(int one, int two) {
        return one + two;
    }

    @Param(a = 1, b = 5)
    public static double max(int one, int two) {
        return one > two ? one : two;
    }

    public double min(int one, int two) {
        return one < two ? one : two;
    }

    @Param(a = 6, b = 7)
    public double avg(int one, int two) {
        return (one + two) / 2.0;
    }
}
