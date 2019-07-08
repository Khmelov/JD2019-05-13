package by.it.livanovich.calc;

public class FactoryMatr extends Factory {
    @Override
    public Var factoryMethod() {
        return new Matrix();
    }
}
