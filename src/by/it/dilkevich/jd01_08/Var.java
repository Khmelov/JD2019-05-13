package by.it.dilkevich.jd01_08;

public abstract class Var implements ISigns{
    @Override
    public String toString() {
        return "it's abstract class";
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения " + this + " + " + other + " невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания " + this + " - " + other + " невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " + this + " * " + other + " невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления " + this + " / " + other + " невозможна");
        return null;
    }
}
