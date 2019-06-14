package by.it.guchek.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {                 //реализовывает интерфейс Operation

    static Map<String, Var> vars= new HashMap<>();

    static Var saveVar (String name, Var var){

        vars.put(name, var);  //метод сохраняет переменные во внутреннюю карту vars
        return var;
    }

    static Var createVar(String operand) {
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

        else return null;

    }

    //public static void readVar() {

    //}


    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения "+this+"+"+other+" невозможна!");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания "+this+"-"+other+" невозможна!");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения "+this+"*"+other+" невозможна!");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления "+this+"/"+other+" невозможна!");
        return null;
    }

    @Override
    public String toString() {
        return "Это абстрактный класс Var";
    }
}
