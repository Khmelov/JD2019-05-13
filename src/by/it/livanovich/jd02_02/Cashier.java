package by.it.livanovich.jd02_02;

public class Cashier {
    private String name;
    int number;

    public Cashier(int number) {
        name = "Кассир №" + number + " ";
    }

    @Override
    public String toString() {
        return name;
    }
}
