package by.it.yaskevich.jd02_01;

public class Helper {

    static int rnd(int max) {
        return rnd(0, max);
    }

    static int rnd(int start, int stop) {
        return start + (int)(Math.random() * (stop + start -1));
    }

}
