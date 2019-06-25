package by.it.maniuk.jd02_01;

public class Util {

   static int rnd(int max){
        return rnd(max); //?
    }

   static int rnd (int start, int stop){
        return start+ (int) (Math.random()*(stop-start)+1);
    }

    static void sleep(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
