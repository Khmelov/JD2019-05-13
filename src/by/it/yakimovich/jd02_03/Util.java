package by.it.yakimovich.jd02_03;

class Util {


    //max may be not only 2
    @SuppressWarnings("SameParameterValue")
    static int rnd(int max){
        return rnd(0,max);
    }

       static int rnd(int start, int stop){
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
