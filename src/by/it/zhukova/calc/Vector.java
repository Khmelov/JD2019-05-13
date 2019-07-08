package by.it.zhukova.calc;

import by.it.zhukova.calc.exceptions.Exceptions;
import java.util.Arrays;
import static by.it.zhukova.calc.ConsoleRunner.*;

class Vector extends Var {
     private double [] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[ ] value) {
         this.value= Arrays.copyOf(value,value.length);//создаем новый массив
     }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar){
            double [] add= Arrays.copyOf(value,value.length);
            for (int i = 0; i < add.length; i++) {
                add[i]+=((Scalar) other).getValue();
            }
            return new Vector(add);
        }
        else if (other instanceof Vector){
            if (!(((Vector) other).getValue().length ==value.length))
                throw new CalcException(manager.get(Exceptions.VECTOR));
            double [] add= Arrays.copyOf(value,value.length);
            for (int i = 0; i < add.length; i++) {
                add[i]+=((Vector) other).value[i];
            }
            return new Vector(add);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar){
            double [] sub= Arrays.copyOf(value,value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i]-=((Scalar) other).getValue();
            }
            return new Vector(sub);
        }
        else if (other instanceof Vector){
            if (!(((Vector) other).getValue().length ==value.length))
                throw new CalcException(manager.get(Exceptions.VECTOR));
            double [] sub= Arrays.copyOf(value,value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i]-=((Vector) other).value[i];
            }
            return new Vector(sub);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar){
            double [] mul= Arrays.copyOf(value,value.length);
            for (int i = 0; i < mul.length; i++) {
                mul[i]*=((Scalar) other).getValue();
            }
            return new Vector(mul);
        }
        else if (other instanceof Vector){
            if (!(((Vector) other).getValue().length ==value.length))
                throw new CalcException(manager.get(Exceptions.VECTOR));
            double [] mul= Arrays.copyOf(value,value.length);
           double res = 0;
            for (int i = 0; i < mul.length; i++) {
               res=res+ mul[i]*((Vector) other).value[i];
            }
            return new Scalar(res);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar){
            if (((Scalar) other).getValue()==0)
                throw new CalcException(manager.get(Exceptions.ZERODIV));
            double [] div= Arrays.copyOf(value,value.length);
            for (int i = 0; i < div.length; i++) {
                div[i]/=((Scalar) other).getValue();
            }
            return new Vector(div);
        }

        return super.div(other);
    }

    Vector(Vector vector) {
        this.value=vector.value;
    }
    Vector(String strVector) {
        String [] vector = strVector.replace("{","")
                .replace("}","")
                .split(",");
        double [] vectorResult = new double [vector.length];
        for (int i = 0; i < vector.length; i++) {
            vectorResult[i] =Double.parseDouble(vector[i]);
        }
        this.value= vectorResult;
    }

    @Override
    public String toString() {
          StringBuilder out = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            out.append(delimiter).append(element);
            delimiter = ", ";
        }
        out.append("}");
        return out.toString();
    }
}
