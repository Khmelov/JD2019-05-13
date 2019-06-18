package by.it.yaskevich.calc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);
        for (int i = 0; i < value.length; i++) {
            this.value[i] = Arrays.copyOf(value[i], value[i].length);
        }
    }

    Matrix(Matrix matrix) {
        this(matrix.value);
    }

    Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll("\\s+", "");
        Matcher matcher = Pattern.compile(Patterns.MATRIX).matcher(strMatrix);
        if (!matcher.find())
            throw new IllegalArgumentException("Incorrect format: " + strMatrix);

        String rawData = matcher.group("arrays");
        matcher = Pattern.compile(Patterns.VECTOR).matcher(rawData);

        int counter = 0;
        while (matcher.find()) {
            counter++;
        }

        value = new double[counter][];

        counter = 0;
        matcher.reset();
        while (matcher.find()) {
            String[] numbers = Pattern.compile(",").split(matcher.group("array"));

            value[counter] = new double[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                value[counter][i] = Double.parseDouble(numbers[i]);
            }
            counter++;
        }
    }

    @Override
    public String toString() {
        if (value.length == 0)
            return "{}";
        StringBuilder result = new StringBuilder();
        result.append("{");
        String delimiter = "";
        for (double[] array : value) {
            result.append(delimiter).append("{");
            delimiter = "";
            for (double element : array) {
                result.append(delimiter).append(element);
                delimiter = ", ";
            }
            result.append("}");
        }
        result.append("}");
        return result.toString();
    }

    private double[][] copyOfValue() {
        double[][] result = new double[value.length][];
        for (int i = 0; i < result.length; i++) {
            result[i] = Arrays.copyOf(value[i], value[i].length);
        }
        return result;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double s = ((Scalar)other).getValue();
            double[][] result = copyOfValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] += s;
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix) {
            double[][] m = ((Matrix)other).value;
            double[][] result = copyOfValue();
            if ((result[0].length != m.length)) {
                throw new CalcException("Неверная размерность массивов");
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] += m[i][j];
                }
            }
            return new Matrix(result);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double s = ((Scalar)other).getValue();
            double[][] result = copyOfValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] -= s;
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix) {
            double[][] m = ((Matrix)other).value;
            double[][] result = copyOfValue();
            if ((result[0].length == m.length)) {
                throw new CalcException("Неверная размерность массивов");
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] -= m[i][j];
                }
            }
            return new Matrix(result);
        } else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double s = ((Scalar)other).getValue();
            double[][] result = copyOfValue();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] *= s;
                }
            }
            return new Matrix(result);
        } else if (other instanceof Vector) {
            double[] v = ((Vector)other).getValue();
            double[] result = new double[v.length];
            if ((value[0].length != v.length)) {
                throw new CalcException("Неверная размерность массивов");
            }
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    result[i] += value[i][j] * v[j];
                }
            }
            return new Vector(result);
        } else if (other instanceof Matrix) {
            double[][] m = ((Matrix)other).value;
            double[][] result = new double[value.length][value[0].length];
            if ((result[0].length != m.length)) {
                throw new CalcException("Неверная размерность массивов");
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    for (int k = 0; k < result[i].length; k++) {
                        result[i][j] += value[i][k] * m[k][j];
                    }
                }
            }
            return new Matrix(result);
        } else
            return super.mul(other);
    }
}
