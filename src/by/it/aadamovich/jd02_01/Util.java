package by.it.aadamovich.jd02_01;

import java.util.Random;

class Util {

    private static Random random = new Random();

    static int getRandom(int from, int to) {
        return random.nextInt(to - from + 1) + from;
    }

    static void sleep(int timeout, int speed) {
        try {
            Thread.sleep(timeout * speed / 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
