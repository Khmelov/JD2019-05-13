package by.it.livanovich.calc;

public class FactoryVec extends Factory {
    @Override
    public Var factoryMethod() {
        return new Vector();
    }
}
