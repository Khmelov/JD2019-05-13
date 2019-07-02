package by.it.adamovichjr.jd02_03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class Backet {

    private Backet(ArrayList<String> arrayList){
        backed = arrayList;
    }

    private ArrayList<String>backed;

    ArrayList<String> getBacked() {
        return backed;
    }

    void addGoodInBacked(String good){
        backed.add(good);
    }

    void clearBacked(){
        Iterator<String> iterator = backed.iterator();
        while (iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
    }

    private static final int MAX_BACKED_IN_MARKET = 50;

    private static BlockingDeque<Backet> queueOfBacket = new LinkedBlockingDeque<>(MAX_BACKED_IN_MARKET);
    static {
        for (int i = 0; i < MAX_BACKED_IN_MARKET; i++) {
            queueOfBacket.addLast(new Backet(new ArrayList<>()));
        }
    }

    static Backet takeBackedOfQueue() throws InterruptedException {
        return queueOfBacket.take();
    }

    static void returnBacked(Backet backet){
        try {
            queueOfBacket.put(backet);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
