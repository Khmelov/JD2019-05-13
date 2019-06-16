package by.it.zhukova.jd01_08;

import by.it.zhukova.jd01_08.Var;

class Scalar extends Var{
   private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
       this.value = value;
   }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            Scalar s = (Scalar) other;
            double add=this.value+s.value;
            return new Scalar(add);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            Scalar s = (Scalar) other;
            double sub=this.value-s.value;
            return new Scalar(sub);
        }
        return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            Scalar s = (Scalar) other;
            double mul=this.value*s.value;
            return new Scalar(mul);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            Scalar s = (Scalar) other;
            double div=this.value/s.value;
            return new Scalar(div);
        }
        return super.div(other);
    }

    Scalar (Scalar scalar){
       this.value=scalar.value;

}
    Scalar (String strvalue){
       this.value= Double.parseDouble(strvalue);
   }
   @Override
   public String toString() {
       return Double.toString(value);
   }
}
