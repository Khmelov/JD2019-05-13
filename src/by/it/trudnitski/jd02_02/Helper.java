package by.it.trudnitski.jd02_02;

public class Helper {

    static int randomeGet(int start, int stop) {
        return start + ((int) (Math.random() * (stop - start + 1)));
    }

    static int randomeGet(int max) {
        return randomeGet(0, max);
    }

    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout / Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
