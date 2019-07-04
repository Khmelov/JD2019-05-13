package by.it.aadamovich.calc;

import by.it.aadamovich.calc.names.ResData;

abstract class Var implements Operation {

    static Var createVar(String operand) throws CalcException{
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

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format
                (ResourceManager.INSTANCE.getString(ResData.SUM_NOT_POSSIBLE), this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format
                (ResourceManager.INSTANCE.getString(ResData.SUB_NOT_POSSIBLE), this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format
                (ResourceManager.INSTANCE.getString(ResData.MUL_NOT_POSSIBLE), this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format
                (ResourceManager.INSTANCE.getString(ResData.DIV_NOT_POSSIBLE), this, other));
    }
}
