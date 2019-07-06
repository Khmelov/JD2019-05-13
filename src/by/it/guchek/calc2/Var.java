package by.it.guchek.calc2;

import by.it.guchek.jd02_05.names.CalcErrors;

import java.util.HashMap;
import java.util.Map;

import static by.it.guchek.calc2.ConsoleRunner.managerC;

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
        operand = operand.trim().replace(" ", "").replace("(","").replace(")","");
        if (operand.matches(Patterns.SCALAR))          //если операнд соответствует рег. выр. СКАЛАР
        return new Scalar(operand);                   //должны вернуть новый скалар в конструктор
                                                                            // которого этот операнд передан
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);

        else if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);

        else if (vars.containsKey(operand))
            return vars.get(operand);

        else if (operand.matches(Patterns.BRACE))
            return new Parser().calc(operand);

        else throw new CalcException(managerC.get(CalcErrors.UNABLE_VARIABLE)+
                    " "+operand);

    }


    @Override
    public Var add(Var other) throws CalcException{
        throw new CalcException(managerC.get(CalcErrors.UNABLE_ADD)+" "+this+"+"+other+" "+managerC.get(CalcErrors.UNABLE));
    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException(managerC.get(CalcErrors.UNABLE_SUB)+" "+this+"-"+other+" "+managerC.get(CalcErrors.UNABLE));
    }

    @Override
    public Var mul(Var other) throws CalcException{
        throw new CalcException(managerC.get(CalcErrors.UNABLE_MUL)+" "+this+"*"+other+" "+managerC.get(CalcErrors.UNABLE));
    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException(managerC.get(CalcErrors.UNABLE_DIV)+" "+this+"/"+other+" "+managerC.get(CalcErrors.UNABLE));
    }

    @Override
    public String toString() {
        return "Abstract Var";
    }
}
