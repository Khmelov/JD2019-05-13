package by.it.tbabich.calc;

public class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this(scalar.value);
    }

    public Scalar(String strScalar) {
        this(Double.parseDouble(strScalar));
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }


    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            return new Scalar(this.value + ((Scalar) other).value);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            return new Scalar(this.value - ((Scalar) other).value);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            return new Scalar(this.value * ((Scalar) other).value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws  CalcException{
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            return new Scalar(this.value / ((Scalar) other).value);
        }
        return super.div(this);
    }
}
