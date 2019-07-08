package by.it.trudnitski.calc;

public class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            return new Scalar(this.value + s.value);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            return new Scalar(this.value - s.value);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            return new Scalar(this.value * s.value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            if (s.value == 0)
                throw new CalcExeption("Деление на ноль");
            return new Scalar(this.value / s.value);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }
}
