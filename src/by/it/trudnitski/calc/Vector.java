package by.it.trudnitski.calc;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this(vector.value);
    }

    public Vector(String strVector) {
        strVector = strVector.replaceAll("[^\\d.]+", " ").trim();
        String[] line = strVector.split("[ ]+");
        double[] res = new double[line.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Double.parseDouble(line[i]);
        }
        this.value = res;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");
        String delimeter = "";
        for (double element : value) {
            out.append(delimeter).append(element);
            delimeter = ", ";
        }
        out.append("}");
        return out.toString();
    }


    @Override
    public Var add(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            double[] res = Arrays.copyOf(value, value.length);

            for (int i = 0; i < res.length; i++) {
                res[i] += s;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            if (value.length != ((Vector) other).getValue().length)
                throw new CalcExeption("Длины векторов не равны");
            double[] v = ((Vector) other).value;
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += v[i];
            }
            return new Vector(res);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - s;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] v = ((Vector) other).getValue();
            double[] res = Arrays.copyOf(value, value.length);
            if (value.length != (v.length))
                throw new CalcExeption("Длины векторов не равны");
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - v[i];
            }
            return new Vector(res);
        } else
            return super.sub(other);

    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * s;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] v = ((Vector) other).value;
            double[] res = Arrays.copyOf(value, value.length);

            if (value.length != (v.length))
                throw new CalcExeption("Длины векторов не равны");

            double sum = 0;
            for (int i = 0; i < res.length; i++) {
                sum += res[i] * v[i];
            }

            return new Scalar(sum);
        } else
            return super.add(other);
    }

    @Override
    public Var div(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            double[] sum = Arrays.copyOf(value, value.length);

            if (s == 0) throw new CalcExeption("Деление на ноль невозможно");

            for (int i = 0; i < value.length; i++) {
                sum[i] /= s;
            }
            return new Vector(sum);
        } else
            return super.div(other);

    }
}
