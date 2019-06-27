package by.it.maniuk.jd02_02;

class Dispatcher {

    static final int K_SPEED=1;
    static final int PLAN=100;
    static int buyerInMAarket=0;
    static int buyerCounter =0;

     static boolean planComplete() {
        return (buyerCounter==PLAN )
                    && (buyerInMAarket==0);
    }
   synchronized static void addBuyer(){
        buyerInMAarket++;

    }
    synchronized static void completeBuyer(){
        buyerInMAarket--;
        buyerCounter++;

    }
   synchronized  static boolean marketIsOpend(){
        return buyerInMAarket+buyerCounter <PLAN;
    }
}
