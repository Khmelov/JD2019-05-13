package by.it.tbabich.jd01_07;

class Scalar extends Var {

    private double value;

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this(scalar.value);
    }

    Scalar(String strScalar) {
        this(Double.parseDouble(strScalar));
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
