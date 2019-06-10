package by.it.aadamovich.jd01_09;

abstract class Var implements Operation {

    static Var createVar(String operand) {
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        } else if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        } else if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand);
        }
        return null;
    }

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
}
