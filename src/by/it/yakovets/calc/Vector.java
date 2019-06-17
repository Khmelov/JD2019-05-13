package by.it.yakovets.calc;

import java.util.Arrays;

public class Vector extends Var {
    public double[] value;

    public double[] getValue() {
        return value;
    }

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String strVector) {
        String line = strVector.replaceAll("[{},\\s]", " ");
        line = line.trim();
        String[] arr = line.split(" ");
        double[] mas = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            mas[i] = Double.parseDouble(arr[i]);
        }
        this.value = mas;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            double[] res = Arrays.copyOf(this.value, value.length);
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
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            double[] res = Arrays.copyOf(this.value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] -= s;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] v = ((Vector) other).value;
            double[] res = Arrays.copyOf(this.value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] -= v[i];
            }
            return new Vector(res);
        } else
            return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            double[] res = Arrays.copyOf(this.value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] *= s;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] v = ((Vector) other).value;
            double[] res = Arrays.copyOf(this.value, value.length);
            double mult = 0;
            for (int i = 0; i < v.length; i++) {
                mult = mult + res[i] * v[i];
            }
            return new Scalar(mult);
        } else
            return super.add(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            double[] res = Arrays.copyOf(this.value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] /= s;
            }
            return new Vector(res);
        } else

            return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String del = "";
        for (int i = 0; i < value.length; i++) {

            sb.append(del).append(value[i]);
            del = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
