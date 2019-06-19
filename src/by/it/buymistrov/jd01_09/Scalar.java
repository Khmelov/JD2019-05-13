package by.it.buymistrov.jd01_09;

public class Scalar extends Var {

    private double value;

    public double getValue() {
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
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            return new Scalar(this.value + s.value);
        }


        return other.add(this);
    }


    @Override
    public Var sub(Var other) {


        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            return new Scalar(this.value - s.value);
        }


        return other.sub(this).mul(new Scalar(-1));
    }



    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            return new Scalar(this.value * s.value);
        }

        return other.mul(this);

    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            if (s.value != 0) {
                return new Scalar(this.value / s.value);
            } else return super.div(other);
        }


        return other.add(this);

    }


    @Override
    public String toString() {
        return Double.toString(value);
    }
}
