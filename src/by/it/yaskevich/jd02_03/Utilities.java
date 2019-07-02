package by.it.yaskevich.jd02_03;

class Utilities {
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
