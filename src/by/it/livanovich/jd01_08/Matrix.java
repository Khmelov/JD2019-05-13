package by.it.livanovich.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {
    private double[][] value;


    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix (String strMatrix) {
        StringBuilder sbmatrix = new StringBuilder(strMatrix);
        Pattern p = Pattern.compile("}");
        Matcher m = p.matcher(strMatrix);
        m.find();
        int middle = m.start();
        String[] first = strMatrix.substring(0, middle).replace("{{", " ").trim().split(",");
        String[] second = strMatrix.substring(middle + 3, strMatrix.length() - 1).replace("}", "").replace("{","").trim().split(",");
        double[][] temp = new double[first.length][second.length];
        for (int i = 0; i < first.length; i++) {
            temp[0][i] = Double.parseDouble(first[i]);
        }
        for (int i = 0; i < second.length; i++) {
            temp[1][i] = Double.parseDouble(second[i]);
        }
        this.value = temp;

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double[] row : value) {
            delimiter = "";
            if (sb.length() > 1) sb.append(", ");
            sb.append("{");
            for (double element : row) {
                sb.append(delimiter).append(element);
                delimiter = ", ";
            }
            sb.append("}");
        }

        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Matrix) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] +  ((Matrix) other).value[i][j];
                }
            }
                return new Matrix(res);
        }
            else
            return super.add(other);
    }




    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }
}

