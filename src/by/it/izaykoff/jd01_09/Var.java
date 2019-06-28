package by.it.izaykoff.jd01_09;

abstract class Var implements Operation {

    static Var creatVar(String operand){
        operand = operand.trim().replaceAll("\\s","");
        if (operand.matches(Var.SCALAR)){
            return new Scalar(operand);
        }
        if (operand.matches(Var.VECTOR)){
            return new Vector(operand);
        }
        if (operand.matches(Var.MATRIX)){
            return new Matrix(operand);
        }
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Операция %s + %s невозможна%n", this,other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Операция %s - %s невозможна%n", this,other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Операция %s * %s невозможна%n", this,other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Операция %s / %s невозможна%n", this,other);
        return null;
    }

    @Override
    public String toString() {
        return "this is class Var";
    }
}
