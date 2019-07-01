package by.it.adamovichjr.jd02_01;

public class Test {
    public static void main(String[] args) {
        final int limitBuyers = getLimitBuyers(31);
        System.out.println(limitBuyers);
    }
    private static int getLimitBuyers(int time) {
        int limitBuyers;
        if (time % 60 <= 30) {
            limitBuyers = (time % 60) + 10;
        } else {
            limitBuyers = 40 + (30 - (time % 60));
        }
        return limitBuyers;
    }
}
