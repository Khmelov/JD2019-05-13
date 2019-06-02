package by.it.yakimovich.jd01_08.oop;

public class Runner {
    public static void main(String[] args) {


        CargoShip ship = new Tanker();
        ship.alarm();
        ship.engineOn();
        ship.go();
        ship.left();
        ship.right();
        ship.stop();
        ship.signal();
        ship.loading(27);

    }


}
