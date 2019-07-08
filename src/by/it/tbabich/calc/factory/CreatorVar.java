package by.it.tbabich.calc.factory;

import by.it.tbabich.calc.CalcException;
import by.it.tbabich.calc.Var;

abstract class CreatorVar {
    public abstract Var factoryMethod(String strVar) throws CalcException;
}
