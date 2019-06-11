package by.it.yakimovich.jd01_08.oop;

public abstract class CargoShip implements Ship {

    @Override
    public void go() {
        System.out.println("go!");
    }

    public abstract void loading(double cargoAmount);
}
