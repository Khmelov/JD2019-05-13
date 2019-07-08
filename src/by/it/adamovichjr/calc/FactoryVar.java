package by.it.adamovichjr.calc;

import by.it.adamovichjr.calc.text.All_messages;

public class FactoryVar {
    static Var createVar(String operand) throws CalcException {
        operand = operand.trim().replaceAll("\\s+","");
        if(operand.contains("(")||operand.contains(")")){
            throw new CalcException(ResourceManager.INSTANCE.get(All_messages.WRONG_BRACKETS));
        }
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if(operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if (Var.getVars().containsKey(operand))
            return Var.getVars().get(operand);
        throw new CalcException(ResourceManager.INSTANCE.get(All_messages.UNABLE_CREATE_OPERAND) + operand);
    }
}
