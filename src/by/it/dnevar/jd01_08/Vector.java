package by.it.dnevar.jd01_08;

import java.util.Arrays;

class Vector extends Var{

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector (double[] value){
        this.value = value;
    }

    Vector (Vector vector){
        this.value = vector.value;
    }

    Vector (String strVector){
        String str = strVector.substring(1,strVector.length()-1);
        String[] arrStr = str.split(",");
        value = new double[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            value[i] = Double.parseDouble(arrStr[i]);
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i]+((Scalar)other).getValue();
            }
            return new Vector(res);
        }else if(other instanceof Vector){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector)other).value[i];
            }
            return new Vector(res);
        }else{
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i]-((Scalar)other).getValue();
            }
            return new Vector(res);
        }else if(other instanceof Vector){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector)other).value[i];
            }
            return new Vector(res);
        }else{
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double[] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i]*((Scalar)other).getValue();
            }
            return new Vector(res);
        }else if(other instanceof Vector){
            double[] res = Arrays.copyOf(value,value.length);
            double result = 0;
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Vector)other).value[i];
                result+=res[i];
            }
            return new Scalar(result);
        }else{
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else{
            return super.div(other);
        }
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("{");
        String delimiter = "";
        for (double element: value){
            str.append(delimiter).append(element);
            delimiter = ", ";
        }
        str.append("}");
        return str.toString();
    }
}
