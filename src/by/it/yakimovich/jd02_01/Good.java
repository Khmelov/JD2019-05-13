package by.it.yakimovich.jd02_01;

public class Good {

    private String name;

    private  double price;

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

       @Override
    public String toString() {
        return name + " price: " + price + " byn ";
    }
}


