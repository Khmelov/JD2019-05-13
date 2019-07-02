package by.it.aadamovich.jd02_02;

import java.util.Random;

class Util {

    private static Random random = new Random();

    static int getRandom(int from, int to) {
        return random.nextInt(to - from + 1) + from;
    }

    // get random int number from 0 to given parameter
    static int getRandom(int to) {
        return getRandom(0, to);
    }

    // parameter speed regulates timeout for pensioners and the flow of buyers
    static void sleep(int timeout, int speed) {
        try {
            Thread.sleep(timeout * speed / 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
