package by.it.yaskevich.jd02_03;

class Good {
    private String name;
    private int price;

    Good(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return getName() + "(" + getPrice() + " руб.)";
    }

    String getName() {
        return name;
    }

    int getPrice() {
        return price;
    }
}
