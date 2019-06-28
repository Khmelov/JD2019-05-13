package by.it.yaskevich.jd01_11.calc11;

public class Scalar extends Var {

    private double value;

    double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            return new Scalar(this.value + ((Scalar)other).value);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            return new Scalar(this.value - ((Scalar)other).value);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            return new Scalar(this.value * ((Scalar)other).value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            return new Scalar(this.value / ((Scalar)other).value);
        }
        return super.div(other);
    }
}
