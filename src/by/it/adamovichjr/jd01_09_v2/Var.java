package by.it.adamovichjr.jd01_09_v2;

public class Var implements Operation {

    static Var createVar(String operand){
        operand = operand.trim().replaceAll("\\s+","");
        if (operand.matches(Patterns.SCALAR)) {
            Scalar sc = new Scalar(operand);
            return sc;
        }

        if(operand.matches(Patterns.VECTOR)) {
            Vector vector = new Vector(operand);
            return vector;
        }
        if (operand.matches(Patterns.MATRIX)) {
            Matrix matrix = new Matrix(operand);
            return matrix;
        }
        return null; // NEED create error
    }
    @Override
    public String toString() {
        return "Var";
    }

    @Override
    public Var add(Scalar other) {
        System.out.println("Оперция + невозможна");
        return null;
    }

    @Override
    public Var add(Vector other) {
        System.out.println("Оперция + невозможна");
        return null;
    }

    @Override
    public Var add(Matrix other) {
        System.out.println("Оперция + невозможна");
        return null;
    }

    @Override
    public Var sub(Scalar other) {
        System.out.println("Оперция - невозможна");
        return null;
    }

    @Override
    public Var sub(Vector other) {
        System.out.println("Оперция - невозможна");
        return null;
    }

    @Override
    public Var sub(Matrix other) {
        System.out.println("Оперция - невозможна");
        return null;
    }

    @Override
    public Var mul(Scalar other) {
        System.out.println("Оперция * невозможна");
        return null;
    }

    @Override
    public Var mul(Vector other) {
        System.out.println("Оперция * невозможна");
        return null;
    }

    @Override
    public Var mul(Matrix other) {
        System.out.println("Оперция * невозможна");
        return null;
    }

    @Override
    public Var div(Scalar other) {
        System.out.println("Оперция / невозможна");
        return null;
    }

    @Override
    public Var div(Vector other) {
        System.out.println("Оперция / невозможна");
        return null;
    }

    @Override
    public Var div(Matrix other) {
        System.out.println("Оперция / невозможна");
        return null;
    }
}
