package by.it.adamovichjr.jd01_09_v2;

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
    public Var add(Scalar other) {
        double sum = this.value +  other.value;
        return new Scalar(sum);

    }

    @Override
    public Var add(Vector other) {
        return other.add(this);
    }

    @Override
    public Var add(Matrix other) {
        return other.add(this);
    }

    @Override
    public Var sub(Scalar other) {
        double sum = this.value - other.value;
        return new Scalar(sum);
    }

    @Override
    public Var sub(Vector other) {
        return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var sub(Matrix other) {
        return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Scalar other) {
        double sum = this.value * ((Scalar) other).value;
        return new Scalar(sum);
    }

    @Override
    public Var mul(Vector other) {
        return other.mul(this);
    }

    @Override
    public Var mul(Matrix other) {
        return other.mul(this);
    }

    @Override
    public Var div(Scalar other) {
        double sum = this.value / ((Scalar) other).value;
        return new Scalar(sum);
    }

    @Override
    public Var div(Vector other) {
        return super.div(other);
    }

    @Override
    public Var div(Matrix other) {
        return super.div(other);
    }

    @Override
    public String toString() {

        return Double.toString(value);
    }
}
