package by.it.tbabich.jd02_02;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    private Backet backet;
    private boolean pensioneer;
    private double coefSpeed;

    public boolean isPensioneer() {
        return pensioneer;
    }

    public Backet getBacket() {
        return backet;
    }

    @Override
    public void goToQueue() {
        synchronized (Dispatcher.console) {
            System.out.println(this + " go to Queue");
        }
        if (isPensioneer()) {
            PensionersQueue.add(this);
        } else
            Queue.add(this);
        Dispatcher.checkCashiers();
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setPensioneer(boolean pensioneer) {
        this.pensioneer = pensioneer;
        coefSpeed = Util.rnd(1, 2);
    }

    public Buyer(int number) {
        super("Buyer №" + number);
        coefSpeed = 1;
        Dispatcher.addBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        synchronized (Dispatcher.console) {
            System.out.println(this + " enter to the market");
        }
    }

    @Override
    public void chooseGoods() {
        synchronized (Dispatcher.console) {
            System.out.println(this + " start choose goods");
        }
        int quantityGood = Util.rnd(1, 4);
        for (int i = 0; i < quantityGood; i++) {
            int timeout = Util.rnd(500, 2000);
            Util.sleep((int) (timeout * coefSpeed));
            int id = Goods.getRandomGood();
            Product product = Goods.getProduct(id);
            synchronized (Dispatcher.console) {
                System.out.println(this + " choose " + product);
            }
            putGoodsToBacket(product);
        }
        synchronized (Dispatcher.console) {
            System.out.println(this + " stop choose goods");
        }
    }

    @Override
    public void goOut() {
        synchronized (Dispatcher.console) {
            System.out.println(this + " out from the market");
        }
        Market.deleteBuyer(this);
        Dispatcher.completeBuyer();
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void takeBacket() {
        synchronized (Dispatcher.console) {
            System.out.println(this + " taked backet");
        }
        backet = new Backet();
        int timeout = Util.rnd(100, 200);
        Util.sleep((int) (timeout * coefSpeed));
    }

    @Override
    public void putGoodsToBacket(Product product) {
        synchronized (Dispatcher.console) {
            System.out.printf("%s push %s to backet\n", this, product);
        }
        backet.putToBacket(product);
        int timeout = Util.rnd(100, 200);
        Util.sleep((int) (timeout * coefSpeed));
    }
}
