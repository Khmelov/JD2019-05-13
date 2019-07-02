package by.it.guchek.jd02_01;

public class RandCount {

    static int randFrTo(int max){
        return randFrTo(0,max);
    }

    static int randFrTo(int start, int stop){
        return start+(int)(Math.random()*(stop-start+1));
    }

    static void sleep(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
