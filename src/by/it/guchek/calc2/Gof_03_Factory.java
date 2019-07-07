package by.it.guchek.calc2;

public class Gof_03_Factory {

   public static void main(String[] args) {
        // an array of creators
        Creator[] creators = {new CreatorScalar(), new CreatorVec(), new CreatorMatrix()};
        // iterate over creators and create products
        for (Creator creator : creators) {
            Var product = creator.factoryMethod();
            System.out.printf("Created {%s}\n", product.getClass());
        }
    }
}

    abstract class Creator {
        public abstract Var factoryMethod();
    }

    class CreatorScalar extends Creator {
        @Override
        public Var factoryMethod() { return new Scalar(); }
    }

    class CreatorVec extends Creator {
        @Override
        public Var factoryMethod() { return new Vector(); }
    }

    class CreatorMatrix extends Creator {
        @Override
        public Var factoryMethod() { return new Matrix(); }
    }
