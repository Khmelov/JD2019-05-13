package by.it.orlov.jd02_04;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    void reset() {
        value[0] = 0;
    }

    public Vector(double[] value) {
        super();
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this(vector.value);
    }

    public Vector(String str){
        String[] array = str
                .replace("{", "")
                .replace("}", "")
                .split(",");
        value=new double[array.length];
        for (int i = 0; i < array.length; i++) {
            value[i]=Double.parseDouble(array[i]);
        }
    }
    @Override
    public Var sub(Var other) throws CalcException {
        if(other instanceof Scalar){
            double s= ((Scalar) other).getValue();
            double[] res=Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]-=s;
            }
            return new Vector(res);
        }else if(other instanceof Vector){
            double[] v= ((Vector) other).value;
            double[] res=Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]-=v[i];
            }
            return new Vector(res);
        }else {
            return super.add(other);
        }
    }
    @Override
    public Var mul(Var other) throws CalcException {
        if(other instanceof Scalar){
            double s= ((Scalar) other).getValue();
            double[] res= new double[value.length];
            for (int i = 0; i < value.length; i++) {
                res[i]+=s*value[i];
            }
            return new Vector(res);
        }else if(other instanceof Vector){
            double[] v= ((Vector) other).value;
            double[] res=Arrays.copyOf(value, value.length);
            double result = 0;
            for (int i = 0; i < res.length; i++) {
                result+=res[i]*v[i];
            }
            return new Scalar(result);
        }else {
            return super.add(other);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            double[] res = new double[value.length];
            for (int i = 0; i < value.length; i++) {
                res[i] += value[i] / s;
            }
            return new Vector(res);
        }
        return super.div(other);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += s;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] v = ((Vector) other).value;
            double[] res = Arrays.copyOf(this.value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += v[i];
            }
            return new Vector(res);
        } else
            return super.add(other);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            out.append(delimiter).append(element);
            delimiter = ", ";
        }
        return out.append("}").toString();
    }
}
