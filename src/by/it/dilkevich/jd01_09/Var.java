package by.it.dilkevich.jd01_09;

public abstract class Var implements Operation {
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

    static Var createVar(String statement){

        statement = statement.replaceAll(" ", "");
        Parser parser = new Parser();
        if (statement.matches(parser.SCALAR)){
            Var var = new Scalar(statement);
            return var;
        }
        else if (statement.matches(parser.VECTOR)){
            Var var = new Vector(statement);
            return var;
        }
        else if (statement.matches(parser.MATRIX)){
            Var var = new Matrix(statement);
            return var;
        }

        return null;
    }

}
