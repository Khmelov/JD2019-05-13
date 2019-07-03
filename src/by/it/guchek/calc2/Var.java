package by.it.guchek.calc2;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {                 //реализовывает интерфейс Operation

    private static Map<String, Var> vars= new HashMap<>();

    public static Map<String, Var> getVars() {
        return vars;
    }

    static Var saveVar (String name, Var var){

        vars.put(name, var);  //метод сохраняет переменные во внутреннюю карту vars
        return var;
    }

    static Var createVar(String operand) throws CalcException{
        operand = operand.trim().replace("\\s", "");
        if (operand.matches(Patterns.SCALAR))          //если операнд соответствует рег. выр. СКАЛАР
        return new Scalar(operand);                   //должны вернуть новый скалар в конструктор
                                                                            // которого этот операнд передан
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);

        else if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);

        else if (vars.containsKey(operand))
            return vars.get(operand);

        else throw new CalcException("Невозможно создать переменную: " +operand);

    }


    @Override
    public Var add(Var other) throws CalcException{
        throw new CalcException("Операция сложения "+this+"+"+other+" невозможна!");
    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException("Операция вычитания "+this+"-"+other+" невозможна!");
    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException("Операция умножения "+this+"*"+other+" невозможна!");
    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException("Операция деления "+this+"/"+other+" невозможна!");
    }

    @Override
    public String toString() {
        return "Это абстрактный класс Var";
    }
}
