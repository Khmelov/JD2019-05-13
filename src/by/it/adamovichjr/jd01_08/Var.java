package by.it.adamovichjr.jd01_08;

public class Var implements Operation{
    @Override
    public String toString() {
        return "Var";
    }

    @Override
    public Var add(Var other) {
        System.out.println("Оперция + невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Оперция - невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Оперция * невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Оперция / невозможна");
        return null;
    }
}
