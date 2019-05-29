package by.it.yaskevich.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(Vector vector) {
        this(vector.value);
    }

    Vector(String strVector) {
        Matcher matcher = Pattern.compile("^\\{(((,)?(\\d+(\\.\\d)?))+)\\}$").matcher(strVector);
        if (!matcher.find())
            throw new IllegalArgumentException("Incorrect format: " + strVector);

        String rawData = matcher.group(1);
        String[] numbers = Pattern.compile(",").split(rawData);

        value = new double[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            value[i] = Double.parseDouble(numbers[i]);
        }
    }

    @Override
    public String toString() {
        if (value.length == 0)
            return "{}";
        StringBuilder result = new StringBuilder();
        result.append("{");
        String delimiter = "";
        for (double element : value) {
            result.append(delimiter).append(element);
            delimiter = ", ";
        }
        result.append("}");
        return result.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double s = ((Scalar)other).getValue();
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += s;
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] v = ((Vector)other).value;
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] += v[i];
            }
            return new Vector(res);
        } else
            return super.add(other);
    }
}
