package by.it.orlov.calculator;

public class Scalar extends Var {

    private double value;

    Scalar(double value){
        this.value = value;
    }
    Scalar(String str){
        this.value = Double.parseDouble(str);
    }

    Scalar(Scalar scalar){
        this.value = scalar.value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if(other instanceof Scalar){
            Scalar s = (Scalar) other;
            return new Scalar(this.value+s.value);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar){
            Scalar s = (Scalar) other;
            return new Scalar(this.value-s.value);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Scalar){
            Scalar s = (Scalar) other;
            return new Scalar(this.value*s.value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar){
            Scalar s = (Scalar) other;
            return new Scalar(this.value/s.value);
        }
        return super.div(this);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

}
