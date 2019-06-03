package by.it.orlov.jd01_09;

abstract class Var implements Operation {
    static Var createVar(String oper) {
        if((oper.trim()).matches(Patterns.SCALAR)) {
            return new Scalar(oper);
        }
        if((oper.trim()).matches(Patterns.VECTOR)) {
            return new Vector(oper);
        }
        if((oper.trim()).matches(Patterns.MATRIX)) {
            return new Matrix(oper);
        }
        return null;
    }
    @Override
    public Var add(Var other) {
        System.out.println("Невозможно"+other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Невозможно"+other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Невозможно"+other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Невозможно"+other);
        return null;
    }

    @Override
    public String toString() {
        return "abstract Var";
    }

}
