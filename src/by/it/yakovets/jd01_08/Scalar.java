package by.it.yakovets.jd01_08;

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
       if (other instanceof Scalar){
           Scalar s=(Scalar) other;
           double result=this.value+s.value;
           return new Scalar(result);
       }
       return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            Scalar s=(Scalar) other;
            double result=this.value-s.value;
            return new Scalar(result);
        }
        return other.sub(this).mul(new Scalar(-1));
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            Scalar s=(Scalar) other;
            double result=this.value*s.value;
            return new Scalar(result);
        }
        return other.mul(this);
    }
    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            Scalar s=(Scalar) other;
            double result=this.value/s.value;
            return new Scalar(result);
        }
        return super.div(this);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
