package by.it.guchek.jd02_03;

public class RandCount {

    static int randFrTo(int max){
        return randFrTo(0,max);
    }

    static int randFrTo(int start, int stop){
        return start+(int)(Math.random()*(stop-start+1));
    }

    static void sleep(int timeout){
        try {
            Thread.sleep(timeout/ Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
