package by.it.yaskevich.jd02_01;

class Utilities {
    static int rnd(int max){
        return rnd(0,max);
    }

    static int rnd(int start, int stop){
        return start + (int)(Math.random() * (stop - start + 1));
    }

    static void sleep(int timeout){
        try {
            Thread.sleep(timeout / 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
