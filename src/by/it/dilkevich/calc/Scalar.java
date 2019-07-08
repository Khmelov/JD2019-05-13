package by.it.dilkevich.calc;

import java.io.IOException;

public class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    public Scalar(double value){
        this.value = value;
    }
    public Scalar(Scalar scalar){
        this.value = scalar.value;
    }
    public Scalar(String strScalar){
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) throws CalcException, IOException {
        if(other instanceof Scalar){
            double result = this.value + ((Scalar) other).value;
            return new Scalar(result);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException, IOException {
        if(other instanceof Scalar){
            double result = this.value - ((Scalar) other).value;
            return new Scalar(result);
        }
        return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) throws CalcException, IOException {
        if(other instanceof Scalar){
            double result = this.value * ((Scalar) other).value;
            return new Scalar(result);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException, IOException {
        if(other instanceof Vector) {
            Logger.setLog(ResManager.getName("error.divide"));
            throw new CalcException(ResManager.getName("error.divide"));
        }
        if(((Scalar) other).value == 0) {
            Logger.setLog(ResManager.getName("error.divide.zero"));
            throw new CalcException(ResManager.getName("error.divide.zero"));
        }
        if (other instanceof Scalar){
            double result = this.value / ((Scalar) other).value;
            return new Scalar(result);
        }

        return super.div(other);
    }
}
