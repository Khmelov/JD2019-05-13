package by.it.trudnitski.calc;

import java.util.Arrays;

public class Matrix extends Var {
    private double[][] value;

    public double[][] getValue() {
        return value;
    }

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll("[^\\d.] ?", " ").trim();
        String[] line = strMatrix.split("[ ]{2,}");
        double[][] res = new double[line.length][];
        for (int i = 0; i < res.length; i++) {
            String[] count = line[i].split(" ");
            res[i] = new double[count.length];
            for (int j = 0; j < res[i].length; j++) {
                res[i][j] = Double.parseDouble(count[j]);
            }
        }
        this.value = res;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("{");
        String delimeter = "{";
        String delimeter1 = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {

                str.append(delimeter).append(value[i][j]).append(delimeter1);
                delimeter = ", ";
            }
            delimeter = "}, {";
        }
        str.append("}}");
        Arrays.toString(value);
        return str.toString();
    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res[i][j] += value[i][j] * s;
                }
            }
            return new Matrix(res);
        } else if (other instanceof Vector) {
            double[] res = new double[value[0].length];
            double[] v = ((Vector) other).getValue();
            if (value[0].length != res.length) {
                throw new CalcExeption("Неверный размер");
            }
            for (int i = 0; i < value.length; i++) {
                res[i] = 0;
                for (int j = 0; j < value[0].length; j++) {
                    res[i] += this.value[i][j] * v[j];
                }
            }
            return new Vector(res);
        } else if (other instanceof Matrix) {
            double[][] m = ((Matrix) other).getValue();
            double res[][] = new double[value[0].length][m[0].length];
            if (res[0].length != m.length) {
                throw new CalcExeption("Неверный размер");
            }
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    for (int k = 0; k < value[0].length; k++) {
                        res[i][j] += value[i][k] * m[k][j];
                    }
                }
            }
            return new Matrix(res);
        } else return super.mul(other);
    }

    @Override
    public Var add(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            double res[][] = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res[i][j] = value[i][j] + s;
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix && value.length == ((Matrix) other).getValue().length) {
            double[][] m = ((Matrix) other).getValue();
            double[][] res = new double[value.length][value[0].length];
            if (res[0].length != m.length) {
                throw new CalcExeption("Неверный размер");
            }
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {

                    res[i][j] = value[i][j] + m[i][j];
                }
            }
            return new Matrix(res);
        }

        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res[i][j] = value[i][j] - s;
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix && value.length == ((Matrix) other).getValue().length) {
            double[][] m = ((Matrix) other).getValue();
            double[][] res = new double[value.length][value[0].length];
            if (res[0].length != m.length)
                throw new CalcExeption("Неверный размер");
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res[i][j] += value[i][j] - m[i][j];
                }
            }
            return new Matrix(res);
        }
        return super.sub(other);
    }

    @Override
    public Var div(Var other) throws CalcExeption {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();
            if (s == 0) throw new CalcExeption("Деление на ноль невозможно");
            double res[][] = new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = value[i][j] / s;
                }
            }
            return new Matrix(res);
        } else return super.div(other);
    }
}
