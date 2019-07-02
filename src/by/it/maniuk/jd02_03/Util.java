package by.it.maniuk.jd02_03;

class Util {
    private static int count = 0;
    private static int countTheed =0;

    static int rnd(){ // Не работает/ Does not work
        count++;
        int rnd = rnd(2);
        // N >=t+10
        if (countTheed >= count+10 && count < 30) { countTheed = countTheed + rnd; return rnd;}
        // N <=40+(30-t)
        else if (countTheed >= 40+(30-count) && count < 60 && count >30) {
            countTheed = countTheed + rnd;
            return rnd;
        }

        return 0;
    }

    static int rnd(int max){
        return rnd(0,max);
    }

    static int rnd(int start, int stop){
        return start+(int)(Math.random()*(stop-start+1));
    }

    static int rnd(int start, int stop, boolean pensioneer ){
        if (pensioneer)  {
            return start+(int)(Math.random()*(stop-start+1)*pensioneer());
        }
         else return start+(int)(Math.random()*(stop-start+1));
    }

    static void sleep(int timeout){
        try {
            Thread.sleep(timeout/ Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static int pensioneer() {
        int rendomKoof;
        rendomKoof = Util.rnd(1,3);
        return rendomKoof;
    }

}
