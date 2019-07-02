package by.it.yaskevich.jd02_02;

class Receipts {
    private static int value = 0;

    private Receipts() {}

    synchronized static void add(int value) {
        Receipts.value += value;
    }

    synchronized static int getValue() {
        return value;
    }
}
