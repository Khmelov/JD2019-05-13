package by.it.adamovichjr.calc;

class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar (String str){
        this.value = Double.parseDouble(str);
    }

    Scalar (Scalar scalar){
        double buffer = scalar.value;
        this.value = buffer;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if(other instanceof Scalar){
            double sum = this.value + ((Scalar) other).value;
            return new Scalar(sum);
        }
        else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if(other instanceof Scalar){
            double sum = this.value - ((Scalar) other).value;
            return new Scalar(sum);
        }
        else
            return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if(other instanceof Scalar){
            double sum = this.value * ((Scalar) other).value;
            return new Scalar(sum);
        }
        else
            return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if(other instanceof Scalar){
            if (((Scalar) other).value == 0) throw new CalcException("Деление на ноль");
            double sum = this.value / ((Scalar) other).value;
            return new Scalar(sum);
        }
        else
            return super.div(other);
    }

    @Override
    public String toString() {

        return Double.toString(value);
    }
}
