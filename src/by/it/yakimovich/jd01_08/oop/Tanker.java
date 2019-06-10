package by.it.yakimovich.jd01_08.oop;

public class Tanker extends CargoShip {
    int capacity=10;



    @Override
    public void go() {
        System.out.println("Go!");

    }

    @Override
    public void stop() {
        System.out.println("Stop!");

    }

    @Override
    public void left() {
        System.out.println("Turn left!");

    }

    @Override
    public void right() {
        System.out.println("Turn right!");

    }

    @Override
    public boolean engineOn() {
        return true;
    }

    @Override
    public void signal() {
        System.out.println("Toooo!");

    }

    @Override
    public void alarm() {
        System.out.println("Call 911!");

    }

    @Override
    public void loading(double cargoAmount) {
            if (cargoAmount>=capacity)
                System.out.println("Error!");
    }

    public Tanker() {
        System.out.println("Wow!");
    }

}
