package by.it.trudnitski.jd02_02;

import java.util.Random;

public class Helper {
    private static Random random=new Random();
   static int randomeGet(int start,int stop){
        return random.nextInt(stop-start+1);
    }
    static int randomeGet(int max){
        return randomeGet(0,max);
    }

    static void sleep(int timeout){
        try {
            Thread.sleep(timeout/ Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
