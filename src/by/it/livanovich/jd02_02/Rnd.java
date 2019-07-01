package by.it.livanovich.jd02_02;

public class Rnd {
    static int Rnd(int max) {
        return Rnd(0, max);
    }

    static int Rnd(int start, int stop) {
        return (start + ((int) (Math.random() * (stop - start + 1))));
    }

    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
