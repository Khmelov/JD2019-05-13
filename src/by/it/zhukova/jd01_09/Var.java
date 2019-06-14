package by.it.zhukova.jd01_09;

abstract class Var implements Operation {
    static Var createVar(String strVar){
        String strVar2=strVar.replaceAll("\\s+","");
if (strVar2.matches(Patterns.SCALAR)) return new Scalar(strVar2);
    else    if (strVar2.matches(Patterns.VECTOR)) return new Vector(strVar2);
    else    if (strVar2.matches(Patterns.MATRIX)) return new Matrix(strVar2);
    else    return null;
    }
    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения " + this + "+" + other+ " невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания " + this + "-" + other+ " невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " + this + "*" + other+ " невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления " + this + "/" + other+ " невозможна");
        return null;
    }
}
