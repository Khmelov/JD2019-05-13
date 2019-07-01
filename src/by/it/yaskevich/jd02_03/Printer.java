package by.it.yaskevich.jd02_03;

import java.util.concurrent.Semaphore;

class Printer {
    private static Semaphore block = new Semaphore(1);

    private Printer() {
    }

    static void print(String text) {
        try {
            block.acquire();
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            block.release();
        }
    }
}
