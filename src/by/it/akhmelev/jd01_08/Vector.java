package by.it.akhmelev.jd01_08;

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

    @Override
    public Var add(Var other) {
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
        out.append("}");
        Arrays.toString(value);
        return out.toString();
    }
}
