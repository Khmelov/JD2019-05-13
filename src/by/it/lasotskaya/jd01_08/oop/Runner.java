package by.it.lasotskaya.jd01_08.oop;

public class Runner {
    public static void main(String[] args) {
            //Yacht
        Yacht ship = new Yacht(160);
        CommonShip ship1 = new Yacht("Spain");
        CommonShip ship2 = new Yacht(true);
        System.out.println("Country of yacht is "+ship1.country("Spain"));
        System.out.println("Can it swim? "+ship2.swim());
        System.out.println("Speed is "+ship);
        System.out.println("Can i rest on the yacht ? "+ship.canGoToTrip());
        System.out.println("-----------------------------------------------------");
            //Cargo ship
        CommonShip cargo = new Cargo("Italy");
        CommonShip cargo1 = new Cargo(200);
        CommonShip cargo2 = new Cargo(true);
        Cargo cargo3 = new Cargo();
        System.out.println("Country of cargo ship is "+cargo.country("Italy"));
        System.out.println("Cargo speed is "+cargo1);
        System.out.println("Can it swim? "+cargo2.swim());
        System.out.println("Can cargo ship carry an elephant ? "+cargo3.carry());

        }
    }





