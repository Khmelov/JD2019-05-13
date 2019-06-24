package by.it.izaykoff.jd01_08;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value){
        this.value = value;
    }

    Vector(Vector vector){
    this.value = vector.value;

    }

    Vector(String strVector){
        String[] items = strVector.replaceAll("\\{","").replaceAll("[.0]","")
                .replaceAll("\\}","").split(",");
        value = new double[items.length];
        for (int i = 0; i < items.length; i++) {
            value[i] = Double.parseDouble(items[i]);
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double[] result = Arrays.copyOf(value,value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + ((Scalar) other).getValue();
            }
            return new Vector(result);
        }else if (other instanceof Vector) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] + ((Vector) other).value[i];
            }
            return new Vector(result);
        }else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double[] result = Arrays.copyOf(value,value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - ((Scalar) other).getValue();
            }
            return new Vector(result);
        }else if (other instanceof Vector) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] - ((Vector) other).value[i];
            }
            return new Vector(result);
        }else
            return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double[] result = Arrays.copyOf(value,value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * ((Scalar) other).getValue();
            }
            return new Vector(result);
        }else if (other instanceof Vector) {
            double[] result = Arrays.copyOf(value, value.length);
            double sum = 0;
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] * ((Vector) other).value[i];
                sum += result[i];
            }
            return new Scalar(sum);
        }else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double[] result = Arrays.copyOf(value,value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i] / ((Scalar) other).getValue();
            }
            return new Vector(result);
        }else
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimetr = "";
        for (double element : value) {
            sb.append(delimetr).append(element);
            delimetr = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
