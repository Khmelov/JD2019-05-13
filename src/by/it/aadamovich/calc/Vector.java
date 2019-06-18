package by.it.aadamovich.calc;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        String[] elements = strVector
                .replaceAll("[^\\d.]+", " ")
                .trim().split(" ");

        double[] buffer = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            buffer[i] = Double.parseDouble(elements[i]);
        }
        this.value = buffer;
    }

    public double[] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] sum = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] += ((Scalar) other).getValue();
            }
            return new Vector(sum);

        } else if (other instanceof Vector && this.value.length == ((Vector) other).value.length) {
            double[] sum = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < sum.length; i++) {
                sum[i] += ((Vector) other).value[i];
            }
            return new Vector(sum);

        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] sub = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] -= ((Scalar) other).getValue();
            }
            return new Vector(sub);

        } else if (other instanceof Vector && this.value.length == ((Vector) other).value.length) {
            double[] sub = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i] -= ((Vector) other).value[i];
            }
            return new Vector(sub);

        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] mul = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < mul.length; i++) {
                mul[i] *= ((Scalar) other).getValue();
            }
            return new Vector(mul);

        } else if (other instanceof Vector && this.value.length == ((Vector) other).value.length) {
            double mul = 0;
            for (int i = 0; i < this.value.length; i++) {
                mul += this.value[i] * ((Vector) other).value[i];
            }
            return new Scalar(mul);

        } else return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar && ((Scalar) other).getValue() != 0) {
            double[] div = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < div.length; i++) {
                div[i] /= ((Scalar) other).getValue();
            }
            return new Vector(div);

        } else
            return super.div(other);
    }


    @Override
    public String toString() {

        StringBuilder strBuilder = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            strBuilder.append(delimiter).append(element);
            delimiter = ", ";
        }

        return strBuilder.append("}").toString();
    }
}
