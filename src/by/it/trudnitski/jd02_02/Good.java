package by.it.trudnitski.jd02_02;

public class Good {
    private String name;
    private Double price;


    public Good(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return name + " price " + price + " byn ";
    }
}
