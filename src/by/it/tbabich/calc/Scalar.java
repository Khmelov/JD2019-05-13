package by.it.tbabich.calc;

class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

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


    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            return new Scalar(this.value + ((Scalar) other).value);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            return new Scalar(this.value - ((Scalar) other).value);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            return new Scalar(this.value * ((Scalar) other).value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            return new Scalar(this.value / ((Scalar) other).value);
        }
        return super.div(this);
    }
}
