package by.it.kobrinets.jd02_04;

import java.util.Arrays;

public class Matrix extends Var {
    private double[][] mas;


    private Matrix(double[][] mas) {
        this.mas = mas;
    }

    Matrix(Matrix matrix) {
        this.mas = matrix.mas;
    }

    public Matrix(String strMas) {
        strMas = strMas.replaceAll("[{]+", "") + "},";
        String[] matrix1 = strMas.split("[}]+,");
        mas = new double[matrix1.length][];
        String[] line;
        for (int i = 0; i < mas.length; i++) {
            line = matrix1[i].split(",");
            mas[i] = new double[line.length];
            for (int i1 = 0; i1 < line.length; i1++) {
                mas[i][i1] = Double.parseDouble(line[i1]);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{{");
        String delimeter = "";
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                stringBuilder.append(delimeter).append(mas[i][j]);
                if (j < mas.length - 1) {
                    delimeter = ", ";
                } else delimeter = "}, {";
            }
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();

    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).getValue();
            double[][] res = Arrays.copyOf(this.mas, this.mas.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] += scalarValue;
                }
            }
            return new Matrix(res);
        } else if (other instanceof Matrix) {
            double[][] res = new double[this.mas.length][this.mas[0].length];
            for (int i = 0; i < this.mas.length; i++) {
                res[i] = this.mas[i].clone();
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    if (res.length == ((Matrix) other).mas.length && res[i].length == ((Matrix) other).mas[i].length) {
                        res[i][j] = res[i][j] + ((Matrix) other).mas[i][j];
                    } else {
                        throw new CalcException("Неверная длина матрицы");
                    }

                }
            }
            return new Matrix(res);
        } else
            return super.add(other);
    }
}

