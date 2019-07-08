package by.it.livanovich.calc;

import by.it.livanovich.calc.Text.Helper;
import by.it.livanovich.calc.Text.Messages;

import java.util.Arrays;

class Vector extends Var {
        private double [] value;

    public Vector() {

    }


    public double[] getValue() {
        return value;
    }
    public int getLength() {
        return value.length;
    }

    Vector(double [] value) {
        this.value = value;
    }

    Vector (Vector vector){
        this.value=vector.value;
    }

    Vector (String strVector){
     String [] str=strVector
             .replace("{","")
             .replace("}","")
             .split(",");
     double [] tempvalue=new double[str.length];
        for (int i = 0; i < str.length; i++) {
            tempvalue[i]=Double.parseDouble(str[i]);
        }
        this.value=tempvalue;
        }


    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{");
        String delimiter="";
        for (double element:value){
            sb.append(delimiter).append(element);
            delimiter=", ";
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) throws CalcException{
        if (other instanceof Scalar){
            double [] res= Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res [i]=res[i]+((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            if (value.length!=((Vector) other).getLength()){
                throw new CalcException(Helper.INSTANCE.getKey(Messages.VECTORSIZE));
            }
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        else
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException{
        if (other instanceof Scalar){
            double [] res= Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res [i]=res[i]-((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector) {
            if (value.length!=((Vector) other).getLength()){
                throw new CalcException(Helper.INSTANCE.getKey(Messages.VECTORSIZE));
            }
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        else
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException{
        if (other instanceof Scalar){
            double [] res= Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res [i]=res[i]*((Scalar) other).getValue();
            }
            return new Vector(res);}
        else if (other instanceof Vector) {
                double[] res = Arrays.copyOf(value, value.length);
                double mul=0;
                for (int i = 0; i < res.length; i++) {
                   mul=mul+res[i]*((Vector) other).value[i];
                }
                return new Scalar(mul);
            }
        else
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar){
            double [] res= Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res [i]=res[i]/((Scalar) other).getValue();
            }
            return new Vector(res);}
        else return super.div(other);
        }

}
