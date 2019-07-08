package by.it.tbabich.calc.factory;

import by.it.tbabich.calc.CalcException;
import by.it.tbabich.calc.Matrix;
import by.it.tbabich.calc.Var;

public class CreatorMatrix extends CreatorVar{
    @Override
    public Var factoryMethod(String strVar) throws CalcException {
        return new Matrix(strVar);
    }
}
