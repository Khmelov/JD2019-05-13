package by.it.aadamovich.calc;

import by.it.aadamovich.calc.names.Patterns;
import by.it.aadamovich.calc.names.ResData;

public enum VarFactory {

    CREATOR;

    Var createVar(String operand) throws CalcException{
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        } else if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        } else if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand);
        } else if (VarList.containVariable(operand)) {
            return VarList.getVariable(operand);
        }
        throw new CalcException (String.format
                (ResourceManager.INSTANCE.getString(ResData.UNABLE_TO_CREATE_VAR), operand));
    }
}
