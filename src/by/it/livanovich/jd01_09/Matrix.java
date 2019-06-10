package by.it.livanovich.jd01_09;

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
        String[] first = strMatrix.substring(0, middle)
                .replace("{{", " ")
                .trim()
                .split(",");
        String[] second = strMatrix.substring(middle + 3, strMatrix.length() - 1)
                .replace("}", "")
                .replace("{","")
                .trim()
                .split(",");
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
            double[][] res =new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Matrix) {
            double[][] res =new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j] +  ((Matrix) other).value[i][j];
                }
            }
                return new Matrix(res);
        }
            else
            return super.add(other);
    }




    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] res =new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Matrix) {
            double[][] res =new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j] -  ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        }
        else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] res =new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Vector){
            double [] res=new double[value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                    res [i]=res [i] + value[i][j]* ((Vector) other).getValue()[j];
                }
            }
            return new Vector(res);
        }
        else if (other instanceof Matrix) {
            double[][] res =new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        res[i][j] = res[i][j] + value[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(res);
        }
        else
           return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else
        return super.div(other);
    }
}

