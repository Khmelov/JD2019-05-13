package by.it.livanovich.calc;

import by.it.livanovich.calc.Text.Helper;
import by.it.livanovich.calc.Text.Messages;

class Scalar extends Var {

       private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    @Override
    public Var add(Var other) throws CalcException{
        if (other instanceof Scalar){
            double sum=this.value+((Scalar) other).value;
            return new Scalar(sum);
        }
        else return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException{
        if (other instanceof Scalar){
            double sub=this.value-((Scalar) other).value;
            return new Scalar(sub);
        }
        else return other.sub(this).mul(new Scalar(value-1));
    }

    @Override
    public Var mul(Var other)throws CalcException {
        if (other instanceof Scalar){
            double mul=this.value*((Scalar) other).value;
            return new Scalar(mul);
        }
        else return other.add(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar){
            if (((Scalar) other).value==0){
                throw new CalcException(Helper.INSTANCE.getKey(Messages.ZERO));
            }
            double div=this.value/((Scalar) other).value;
            return new Scalar(div);
        }
        return super.div(other);
    }

    Scalar (Scalar scalar){
        this.value=scalar.value;
    }

    Scalar (String strScalar){
        this.value=Double.parseDouble(strScalar);
    }


    @Override
    public String toString() {
        return Double.toString(value);
    }
}
