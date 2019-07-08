package by.it.kobrinets.jd02_04;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    private Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String str) {
        String[] strArray = str
                .replace('{', ' ')
                .replace('}', ' ')
                .trim()
                .split(",\\s*");

        value = new double[strArray.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(strArray[i]);
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        double[] res = Arrays.copyOf(value, value.length);
        if (other instanceof Scalar) {
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            if (this.value.length < ((Vector) other).value.length
                    || ((Vector) other).value.length < this.value.length) {
                throw new CalcException("Векторы разной длины");
            } else
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] + ((Vector) other).value[i];
                }
            return new Vector(res);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        double[] res = Arrays.copyOf(value, value.length);
        if (other instanceof Scalar) {
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            if (this.value.length < ((Vector) other).value.length
                    || ((Vector) other).value.length < this.value.length) {
                throw new CalcException("Векторы разной длины");
            } else
                for (int i = 0; i < res.length; i++) {
                    res[i] = res[i] - ((Vector) other).value[i];
                }
            return new Vector(res);
        } else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector && this.value.length == ((Vector) other).value.length) {
            double[] res = Arrays.copyOf(value, value.length);
            double sum = 0;
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Vector) other).value[i];
                sum = sum + res[i];
            }
            return new Scalar(sum);
        } else throw new CalcException("Операция невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() == 0) throw new CalcException("Деление на ноль");
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getValue();
            }
            return new Vector(res);
        }
        if (other instanceof Vector) {
            throw new CalcException("Нельзя делить на вектор");
        } else throw new CalcException("Операция невозможна");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";

        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}

