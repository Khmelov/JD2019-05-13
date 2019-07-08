package by.it.zhukova.calc;

import by.it.zhukova.calc.exceptions.Exceptions;
import static by.it.zhukova.calc.ConsoleRunner.*;

class Scalar extends Var {
   private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
       this.value = value;
   }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar){
            Scalar s = (Scalar) other;
            double add=this.value+s.value;
            return new Scalar(add);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar){
            Scalar s = (Scalar) other;
            double sub=this.value-s.value;
            return new Scalar(sub);
        }
        return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar){
            Scalar s = (Scalar) other;
            double mul=this.value*s.value;
            return new Scalar(mul);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar){
            Scalar s = (Scalar) other;
            if (s.value==0)
                throw new CalcException(manager.get(Exceptions.ZERODIV));
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
