package by.it.lasotskaya.jd01_08.oop;

public class Cargo extends CommonShip {
    private int cargoSpeed;
    private String cargoCountry;
    private boolean cargoSwim;
    Cargo (){}
    Cargo (int cargoSpeed){
        this.cargoSpeed=cargoSpeed;
    }
    Cargo (String cargoCountry){
        this.cargoCountry=cargoCountry;
    }
    Cargo(boolean cargoSwim){
        this.cargoSwim=cargoSwim;
    }

    boolean carry (){
        return true;
    }
    @Override
    public String country(String str) {
        return this.cargoCountry;
    }

    @Override
    public String toString() {
        return Integer.toString(cargoSpeed);
    }

    @Override
    public boolean swim() {
        return this.cargoSwim;
    }
}
