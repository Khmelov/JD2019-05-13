package by.it.maniuk.jd02_01;

class Util {
    private static int count = 0;
    private static int countTheed =0;
    private static int  rnd = 0;

    static int rnd(){
        count++;
        // N >=t+10
        if (count==1) countTheed = countTheed + (rnd=rnd(2));
        if (countTheed >= count+10 && count < 30) countTheed = countTheed + (rnd=rnd(2));
        // N <=40+(30-t)
        else if (countTheed >= 40+(30-count) && count < 60 && count >30) countTheed = countTheed + (rnd=rnd(2));{
       }
        return rnd;
    }

    static int rnd(int max){
        return rnd(0,max);
    }

    private static int rnd(int start, int stop){
        return start+(int)(Math.random()*(stop-start+1));
    }

    static int rnd(int start, int stop, boolean pensioneer ){
        if (pensioneer)  {
            return start+(int)(Math.random()*(stop-start+1)*pensioneerHere());
        }
         else return start+(int)(Math.random()*(stop-start+1));
    }

    static void sleep(int timeout){
        try {
            Thread.sleep(timeout/Dispatcher.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static int pensioneerHere() {
        int koof;
        koof = Util.rnd(1,3);
        return koof;
    }

}
