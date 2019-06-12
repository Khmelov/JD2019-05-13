package by.it.lasotskaya.jd01_08.oop;

public class Yacht extends CommonShip{
private int yachtSpeed;
private String yachtCountry;

private boolean yachtSwim;

    Yacht(int speed) {
     this.yachtSpeed=speed;
    }
     Yacht (String country){
        this.yachtCountry=country;
    }
    Yacht (boolean swim){
        this.yachtSwim=swim;
    }

    boolean canGoToTrip(){
        return true;
    }

    @Override
    public String country(String country) {
    return this.yachtCountry;
    }

    @Override
    public String toString() {
        return Integer.toString(yachtSpeed);
    }

    @Override
    public boolean swim() { return this.yachtSwim; }
}
