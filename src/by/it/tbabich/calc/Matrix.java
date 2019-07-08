package by.it.tbabich.calc;

import java.util.Arrays;

public class Matrix extends Var {

    private double[][] value;

    public double[][] getValue() {
        return value;
    }

    public Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Matrix(Matrix matrix) {
        this(matrix.value);
    }

    public Matrix(String strMatrix) throws CalcException {
        try {
            String[] arrayString = strMatrix
                    .replaceAll("\\{", "")
                    .replaceAll(" ", "")
                    .replace("}}", "")
                    .split("},");
            double[][] arrayDouble = new double[arrayString.length][(arrayString[0].length() + 1) / 2];
            for (int i = 0; i < arrayString.length; i++) {
                String[] arrayStringElement = arrayString[i].split(",");
                double[] arrayDoubleElement = new double[arrayStringElement.length];
//            arrayDouble[i] = new double[arrayStringElement.length];
//            if (i > 0 && arrayDouble[i].lenght != arrayDoubleElement[i-1].length) {
//                throw new CalcException (String.format("Переменная %s не является матрицей", strMatrix));
//            }
                for (int j = 0; j < arrayDoubleElement.length; j++) {
                    arrayDoubleElement[j] = Double.parseDouble(arrayStringElement[j]);
                }
                arrayDouble[i] = Arrays.copyOf(arrayDoubleElement, arrayDoubleElement.length);
            }
            this.value = Arrays.copyOf(arrayDouble, arrayDouble.length);
        } catch (Exception e) {
            throw new CalcException(String.format("Переменная %s не является матрицей", strMatrix));
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
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
            if (this.value.length != ((Matrix) other).value.length || this.value[0].length != ((Matrix) other).value[0].length)
                throw new CalcException(String.format("Сложение невозможно: матрицы %s и %s имеют разные размеры", this, other));
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
    public Var sub(Var other) throws CalcException {
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
            if (this.value.length != ((Matrix) other).value.length || this.value[0].length != ((Matrix) other).value[0].length)
                throw new CalcException(String.format("Вычитание невозможно: матрицы %s и %s имеют разные размеры", this, other));
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
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
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
            if (this.value[0].length != ((Matrix) other).value.length)
                throw new CalcException(String.format("Умножение невозможно: разное количество столбцов матрицы %s и строк матрицы %s", this, other));
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
        } else if (other instanceof Vector) {
            if (this.value[0].length != ((Vector) other).getValue().length)
                throw new CalcException(String.format("Умножение невозможно: разное количество столбцов матрицы %s и длина вектора %s", this, other));
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
        } else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if (((Scalar) other).getValue() == 0) throw new CalcException("Деление на ноль невозможно");
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

    private double[][] copyArray(double[][] array) {
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
