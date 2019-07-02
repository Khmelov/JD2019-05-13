package by.it.tbabich.jd02_03;

class Util {

    static int rnd(int max) {
        return rnd(0, max);
    }

    static int rnd(int start, int stop) {
        return start + (int) (Math.random() * (stop - start + 1));
    }

    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
