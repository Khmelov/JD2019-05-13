package by.it.kobrinets.calc11;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector (Vector vector) {
        this.value = vector.value;
    }

    Vector (String str) {
        String[] strArray = str
                .replace('{', ' ').replace('}', ' ').trim().split(",\\s*");

        value = new double[strArray.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(strArray[i]);
        }

    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar){
            double [] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += ((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            if (this.value.length != ((Vector) other).value.length)
                throw new CalcException("Вектора разной длинн");

            double [] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += ((Vector)other).value[i];
            }
            return new Vector(res);
        }
        else
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar){
            double [] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] -= ((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            if (this.value.length != ((Vector) other).value.length)
                throw new CalcException("Вектора разной длинн");
            double [] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] -= ((Vector)other).value[i];
            }
            return new Vector(res);
        }
        else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar){
            if (this.value.length != ((Vector) other).value.length)
                throw new CalcException("Вектора разной длинн");
            double [] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] *=  ((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double [] res = Arrays.copyOf(value, value.length);
            double result = 0;
            for (int i = 0; i < res.length; i++) {
                    res[i] *= ((Vector)other).value[i];
                    result+= res[i];

            }
            return new Scalar(result);
        }
        else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar){
            if (((Scalar) other).getValue() == 0) throw new CalcException("Деление на ноль");
            if (this.value.length != ((Vector) other).value.length)
                throw new CalcException("Вектора разной длинн");
            double [] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] /= ((Scalar)other).getValue();
            }
            return new Vector(res);
        }
        else
            return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";

        for (double element : value){
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
