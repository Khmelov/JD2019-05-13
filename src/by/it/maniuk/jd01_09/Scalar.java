package by.it.maniuk.jd01_09;


public class Scalar extends Var {

    private double  value;

    Scalar(double value) {
        this.value = value;
    }
    Scalar(Scalar scalar){
        this.value = scalar.value;
    }
    Scalar(String strValue){
        this.value = Double.parseDouble(strValue);
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            Scalar s = (Scalar) other;
            double res = this.value+s.value;
            return new Scalar(res);
        }
        else
            return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            Scalar s = (Scalar) other;
            double res = this.value-s.value;
            return new Scalar(res);}
        else  return super.sub(other).mul(new Scalar(-1)).add(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            double mul = this.value * s.value;
            return new Scalar(mul);
        }
       else return other.mul(this);
    }

    @Override
    public Var div(Var other) {
            if (other instanceof Scalar){
                Scalar s = (Scalar) other;
                double div = this.value/s.value;
                return new Scalar(div);
        }

        return super.div(other);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
