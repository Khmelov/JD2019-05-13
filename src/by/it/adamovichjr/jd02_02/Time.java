package by.it.adamovichjr.jd02_02;

import java.util.Random;

class Time {
    private static Random random = new Random();



    static int fromTo(int from, int to) {
        int delta = to - from + 1;
        return random.nextInt(delta) + from;
    }

    static void sleep(int timeout){
        try {
            Thread.sleep(timeout/ Dispetcher.ALL_MARKET_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
