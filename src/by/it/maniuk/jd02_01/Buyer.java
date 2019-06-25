package by.it.maniuk.jd02_01;

public class Buyer extends Thread implements IBuyer{


    public Buyer(int number){
        super("Buyer №"+number);
    }

    @Override
    public void run() {
       enterToMarket();
       chooseGoods();
       goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" ");
    }

    @Override
    public void chooseGoods() {

    }

    @Override
    public void goOut() {

    }


}
