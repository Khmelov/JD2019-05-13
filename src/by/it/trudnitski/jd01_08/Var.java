package by.it.trudnitski.jd01_08;

abstract class Var implements Operation {

public String toString(){

    return "abstract Var";
}

    @Override
    public Var add(Var other) {
        System.out.printf(" Операция %s+%s Невозможна%n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf(" Операция %s-%s Невозможна%n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf(" Операция %s*%s Невозможна%n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf(" Операция %s/%s Невозможна%n", this, other);
        return null;
    }
}
