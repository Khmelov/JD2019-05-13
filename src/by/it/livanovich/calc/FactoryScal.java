package by.it.livanovich.calc;

public class FactoryScal extends Factory {
    @Override
    public Var factoryMethod() {
        return new Scalar();
    }
}
