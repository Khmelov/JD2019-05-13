package by.it.kobrinets.jd01_08;

abstract class Var implements Operation{

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения " + this + " + "+ other + "невоможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания " + this + " - " + other + "невоможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " + this + " * "+ other + "невоможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления " + this + " / "+ other + "невоможна");
        return null;
    }
}