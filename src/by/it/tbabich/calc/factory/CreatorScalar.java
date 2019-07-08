package by.it.tbabich.calc.factory;

import by.it.tbabich.calc.Scalar;
import by.it.tbabich.calc.Var;

public class CreatorScalar extends CreatorVar {
    @Override
    public Var factoryMethod(String strVar) {
        return new Scalar(strVar);
    }
}
