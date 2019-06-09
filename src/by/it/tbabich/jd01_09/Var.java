package by.it.tbabich.jd01_09;

abstract class Var implements Operation {
    @Override
    public Var add(Var other) {
        System.out.printf("Операция %s + %s невозможна%n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Операция %s - %s невозможна%n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Операция %s * %s невозможна%n", this, other);

        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Операция %s / %s невозможна%n", this, other);
        return null;
    }

    static Var createVar(String s){
        if (s.matches(Patterns.MATRIX)) return new Matrix(s);
        else if (s.matches(Patterns.VECTOR)) return new Vector(s);
        else return new Scalar(s);
    }
}
