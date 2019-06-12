package by.it.adamovichjr.jd01_09;

import java.util.Arrays;

public class Vector extends Var {

    private double []value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        double[] buffer = Arrays.copyOf(vector.value,vector.value.length);
        this.value = buffer;
    }

    Vector(String str){
        str = str.replaceAll("[^\\d.]+"," ").trim();
        String[] split = str.split("[ ]+");
        double[]mas = new double[split.length];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = Double.parseDouble(split[i]);
        }
        this.value = mas;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector && value.length == ((Vector)other).getValue().length) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] -= ((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector && value.length == ((Vector)other).getValue().length) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] -= ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        else return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] *= ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector && value.length == ((Vector)other).getValue().length) {
            double res = 0;
            for (int i = 0; i < value.length; i++) {
                res += value[i]*((Vector)other).getValue()[i];
            }
            return new Scalar(res);
        }
        else return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] /= ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder("{");
       String delimiter = "";
        for (double el : value) {
            sb.append(delimiter).append(el);
            delimiter = ", ";
        }
        sb.append("}");

        return sb.toString();
    }
}
