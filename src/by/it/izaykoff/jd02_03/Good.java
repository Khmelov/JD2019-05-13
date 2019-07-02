package by.it.izaykoff.jd02_03;

public class Good {

    private String name;

    private double price;

    public Good() {

    }

    Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " price " + price + " BYN. ";
    }
}
