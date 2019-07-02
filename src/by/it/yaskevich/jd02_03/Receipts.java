package by.it.yaskevich.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Receipts {
    private static final AtomicInteger proceeds = new AtomicInteger(0);

    private Receipts() {}

    static void add(int value) {
        proceeds.addAndGet(value);
    }

    static int getValue() {
        return proceeds.get();
    }
}
