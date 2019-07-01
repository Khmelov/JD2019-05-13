package by.it.akhmelev.calc19;

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
        out.append("}");
        Arrays.toString(value);
        return out.toString();
    }
}
