package by.it.dilkevich.jd02_01;

public class Util {

    static int rnd(int max){
        return rnd(0,max);
    }

    static int rnd(int start, int stop){
        return start+(int)(Math.random()*(stop-start+1));
    }




    static void sleep(int timeout){

        try {
            Thread.sleep((int)(timeout/Dispatcher.K_SPEED));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static void sleep(int timeout, double slowSpeed){

        try {
            Thread.sleep((int)(timeout*slowSpeed/Dispatcher.K_SPEED));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
