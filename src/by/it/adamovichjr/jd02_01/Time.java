package by.it.adamovichjr.jd02_01;

import java.util.Random;

class Time {
    private static Random random = new Random();
    private static final int ALL_MARKET_SPEED = 10;
    static final int BUYERS_SPEED = 2;


    static int fromTo(int from, int to) {
        int delta = to - from + 1;
        return random.nextInt(delta) + from;
    }

    static void sleep(int timeout){
        try {
            Thread.sleep(timeout/ ALL_MARKET_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
