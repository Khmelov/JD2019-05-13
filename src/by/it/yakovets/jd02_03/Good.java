package by.it.yakovets.jd02_03;

public class Good {
    private String name;
    private Integer price;

    public Good(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}