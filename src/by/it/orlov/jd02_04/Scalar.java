package by.it.orlov.jd02_04;

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

    Scalar(String strValue) {
        this(Double.parseDouble(strValue));
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            double res = this.value + s.value;
            return new Scalar(res);
        }
        return other.add(this);
    }


    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            double res = this.value - s.value;
            return new Scalar(res);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            double res = this.value * s.value;
            return new Scalar(res);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            if (s.value==0)
                throw new CalcException(" деление на ноль");
            double res = this.value / s.value;
            return new Scalar(res);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

}
