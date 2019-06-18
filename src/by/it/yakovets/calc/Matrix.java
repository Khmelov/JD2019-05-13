package by.it.yakovets.calc;

import java.util.Arrays;

public class Matrix extends Var {
    private double[][] value;

    public Matrix(double[][] value) {
        double copy[][] = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; ++i) {
            System.arraycopy(value[i], 0, copy[i], 0, value[i].length);
        }

        this.value = copy;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {

            String[] arrStr = strMatrix.replaceAll("\\s", "")
                    .replaceAll("[{}]{2}", "")
                    .split("},\\{");
            double[][] res = new double[arrStr.length][];
            for (int i = 0; i < arrStr.length; i++) {
                String[] arrDig = arrStr[i].split(",");
                res[i] = new double[arrDig.length];
                for (int j = 0; j < arrDig.length; j++) {
                    res[i][j] = Double.parseDouble(arrDig[j]);
                }
            }
            value = Arrays.copyOf(res, res.length);
    }

    @Override
    public Var add(Var other) {
        double copy[][] = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; ++i) {
            System.arraycopy(value[i], 0, copy[i], 0, value[i].length);
        }
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();

            for (int i = 0; i < copy.length; i++) {
                for (int j = 0; j < copy[0].length; j++) {
                    copy[i][j] = copy[i][j] + s;
                }
            }
            return new Matrix(copy);
        } else if (other instanceof Matrix) {
            double[][] mat = ((Matrix) other).value;

            for (int i = 0; i < copy.length; i++) {
                for (int j = 0; j < copy[0].length; j++) {
                    copy[i][j] = copy[i][j] + mat[i][j];


                }
            }
            return new Matrix(copy);
        } else
            return super.add(other);

    }

    @Override
    public Var sub(Var other) {
        double copy[][] = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; ++i) {
            System.arraycopy(value[i], 0, copy[i], 0, value[i].length);
        }
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();

            for (int i = 0; i < copy.length; i++) {
                for (int j = 0; j < copy[0].length; j++) {
                    copy[i][j] = copy[i][j] - s;
                }
            }
            return new Matrix(copy);
        } else if (other instanceof Matrix) {
            double[][] mat = ((Matrix) other).value;

            for (int i = 0; i < copy.length; i++) {
                for (int j = 0; j < copy[0].length; j++) {
                    copy[i][j] = copy[i][j] - mat[i][j];
                }
            }
            return new Matrix(copy);
        } else
            return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        double copy[][] = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; ++i) {
            System.arraycopy(value[i], 0, copy[i], 0, value[i].length);
        }
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();

            for (int i = 0; i < copy.length; i++) {
                for (int j = 0; j < copy[0].length; j++) {
                    copy[i][j] = copy[i][j] * s;
                }
            }
            return new Matrix(copy);
        } else if (other instanceof Matrix) {
            double[][] mat = ((Matrix) other).value;
            double[][] res = new double[copy.length][mat[0].length];
            for (int i = 0; i < copy.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    for (int k = 0; k < mat.length; k++) {
                        res[i][j] += copy[i][k] * mat[k][j];
                    }
                }
            }
            return new Matrix(res);
        } else {
            double[] mat = ((Vector) other).value;
            double[] res = new double[copy[0].length];
            for (int i = 0; i < copy[0].length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    res[i] += copy[i][j] * mat[j];
                }
            }
            return new Vector(res);

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String del = "";
        for (int i = 0; i < value.length; i++) {
            for (int i1 = 0; i1 < value[0].length; i1++) {
                sb.append(del).append(value[i][i1]);
                del = ", ";
            }
            del = "}, {";
        }
        sb.append("}}");
        return sb.toString();
    }
}
