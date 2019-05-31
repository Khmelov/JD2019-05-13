package by.it.lasotskaya.jd01_08.oop;

public class Yacht extends CommonShip{
    @Override
    public boolean swim() {
        return false;
    }

    @Override
    public int speed() {
        return 0;
    }

    @Override
    public int year() {
        return super.year();
    }

    @Override
    public String country() {
        return super.country();
    }
}
