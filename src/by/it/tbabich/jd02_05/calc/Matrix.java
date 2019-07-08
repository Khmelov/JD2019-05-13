package by.it.tbabich.jd02_05.calc;

import java.util.Arrays;

class Matrix extends Var {

    private double[][] value;

    public double[][] getValue() {
        return value;
    }

    Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Matrix(Matrix matrix) {
        this(matrix.value);
    }

    Matrix(String strMatrix) {
        String[] arrayString = strMatrix
                .replaceAll("\\{", "")
                .replaceAll(" ", "")
                .replace("}}", "")
                .split("},");
        double[][] arrayDouble = new double[arrayString.length][(arrayString[0].length() + 1) / 2];
        for (int i = 0; i < arrayString.length; i++) {
            String[] arrayStringElement = arrayString[i].split(",");
            double[] arrayDoubleElement = new double[arrayStringElement.length];
            for (int j = 0; j < arrayDoubleElement.length; j++) {
                arrayDoubleElement[j] = Double.parseDouble(arrayStringElement[j]);
            }
            arrayDouble[i] = Arrays.copyOf(arrayDoubleElement, arrayDoubleElement.length);
        }
        this.value = Arrays.copyOf(arrayDouble, arrayDouble.length);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Double s = ((Scalar) other).getValue();
            double[][] res = copyArray(value);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] += s;
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            double[][] array = copyArray(((Matrix) other).getValue());
            double[][] res = copyArray(value);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] += array[i][j];
                }
            }
            return new Matrix(res);
        } else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            double[][] res = copyArray(value);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] -= s.getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            Matrix matrix = (Matrix) other;
            double[][] array = copyArray(matrix.getValue());
            double[][] res = copyArray(value);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] -= array[i][j];
                }
            }
            return new Matrix(res);
        } else
            return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            double[][] res = copyArray(value);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] *= s.getValue();
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            Matrix matrix = (Matrix) other;
            double[][] array = copyArray(matrix.getValue());
            double[][] array2 = copyArray(value);
            double[][] res = new double[array.length][array[0].length];
            for (int i = 0; i < array2.length; i++) {
                for (int j = 0; j < array2[0].length; j++) {
                    for (int k = 0; k < array2.length; k++) {
                        res[i][j] += array2[i][k] * array[k][j];
                    }
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Vector) {
            Vector vector = (Vector) other;
            double[] v = Arrays.copyOf(vector.getValue(), vector.getValue().length);
            double[][] m = copyArray(value);
            double res[] = new double[v.length];
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[0].length; j++) {
                    res[i] += m[i][j] * v[j];
                }
            }
            return new Vector(res);
        }else
            return super.add(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            Scalar s = (Scalar) other;
            double[][] res = copyArray(value);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] /= s.getValue();
                }
            }
            return new Matrix(res);
        }
        return super.div(other);
    }

    private double[][] copyArray(double[][] array){
        double[][] result = new double[array.length][array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                result[i][j] = array[i][j];
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[0].length; j++) {
                sb.append(value[i][j]);
                if (j == value[0].length - 1) {
                    sb.append("}");
                    break;
                }
                sb.append(", ");
            }
            if (i == value.length - 1) {
                sb.append("}");
                break;
            }
            sb.append(", ");
        }
        return sb.toString();
    }
}
