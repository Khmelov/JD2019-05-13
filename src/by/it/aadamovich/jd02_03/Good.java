package by.it.aadamovich.jd02_03;

public class Good {

    private String name;

    private double price;

    Good() {
    }

    Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " price: " + price + " BYN";
    }
}
