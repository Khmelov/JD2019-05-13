package by.it.adamovichjr.jd01_08_v2;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        double[] buffer = Arrays.copyOf(vector.value, vector.value.length);
        this.value = buffer;
    }

    Vector(String str) {
        str = str.replaceAll("[^\\d.]+", " ").trim();
        String[] split = str.split("[ ]+");
        double[] mas = new double[split.length];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = Double.parseDouble(split[i]);
        }
        this.value = mas;
    }

    @Override
    public Var add(Scalar other) {
        double[] res = Arrays.copyOf(value, value.length);
        for (int i = 0; i < res.length; i++) {
            res[i] += other.getValue();
        }
        return new Vector(res);
    }


    @Override
    public Var add(Vector other) {
        if (value.length == other.getValue().length) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += other.value[i];
            }
            return new Vector(res);
        }
        return super.add(other);
    }

    @Override
    public Var add(Matrix other) {
        return super.add(other);
    }

    @Override
    public Var sub(Scalar other) {
        double[] res = Arrays.copyOf(value, value.length);
        for (int i = 0; i < res.length; i++) {
            res[i] -= other.getValue();
        }
        return new Vector(res);
    }

    @Override
    public Var sub(Vector other) {
        if (value.length == other.getValue().length) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] -= other.value[i];
            }
            return new Vector(res);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Matrix other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Scalar other) {

        double[] res = Arrays.copyOf(value, value.length);
        for (int i = 0; i < res.length; i++) {
            res[i] *= other.getValue();
        }
        return new Vector(res);
    }

    @Override
    public Var mul(Vector other) {

        if (value.length == other.getValue().length) {
            double res = 0;
            for (int i = 0; i < value.length; i++) {
                res += value[i] * other.getValue()[i];
            }
            return new Scalar(res);
        }
        return super.mul(other);
    }

    @Override
    public Var mul(Matrix other) {
        return super.mul(other);
    }

    @Override
    public Var div(Scalar other) {
        double[] res = Arrays.copyOf(value, value.length);
        for (int i = 0; i < res.length; i++) {
            res[i] /= other.getValue();
        }
        return new Vector(res);
    }

    @Override
    public Var div(Vector other) {
        return super.div(other);
    }

    @Override
    public Var div(Matrix other) {
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