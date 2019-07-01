package by.it.dnevar.jd02_01;

public class Util {

    static int rnd(int max){
        return rnd(0,max);
    }

    static int rnd(int min, int max) {
        return  (int)(Math.random()*(max-min+1));
    }

    static void sleep(int timeout){
        try {
            Thread.sleep(timeout/ Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
