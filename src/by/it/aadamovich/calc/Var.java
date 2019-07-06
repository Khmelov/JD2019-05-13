package by.it.aadamovich.calc;

import by.it.aadamovich.calc.names.ResData;

abstract class Var implements Operation {

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
