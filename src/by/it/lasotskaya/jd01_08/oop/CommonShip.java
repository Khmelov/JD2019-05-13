package by.it.lasotskaya.jd01_08.oop;

abstract class CommonShip implements Ship {
    public int year() {
        return 0;
    }

    public String country() {
        return null;
    }

    @Override
    public boolean swim() {
        return false;
    }

    @Override
    public int speed() {
        return 0;
    }
}
