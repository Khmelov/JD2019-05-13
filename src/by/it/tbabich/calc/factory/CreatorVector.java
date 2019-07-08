package by.it.tbabich.calc.factory;

import by.it.tbabich.calc.Var;
import by.it.tbabich.calc.Vector;

public class CreatorVector extends CreatorVar {
    @Override
    public Var factoryMethod(String strVar) {
        return new Vector(strVar);
    }
}
