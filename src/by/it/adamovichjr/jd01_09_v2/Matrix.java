package by.it.adamovichjr.jd01_08_v2;


import java.util.Arrays;

public class Matrix extends Var {
    private double [][] value;

    public double[][] getValue() {
        return value;
    }



    Matrix(double[][] value) {
        this.value = value;
    }
    Matrix(Matrix matrix){
        double [][]buffer = Arrays.copyOf(matrix.value,matrix.value.length);
        this.value = buffer;
    }
    Matrix(String str){
        str = str.replaceAll("[^\\d.] ?"," ").trim();
        String[]line = str.split("[ ]{2,}");
        double[][] mas = new double[line.length][];
        for (int i = 0; i < mas.length; i++) {
            String[] count = line[i].split(" ");
            mas[i] = new double[count.length];
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = Double.parseDouble(count[j]);
            }
        }
        this.value = mas;
    }

    @Override
    public Var add(Scalar other) {
        double[][]res = new double[value.length][value[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = value[i][j] + other.getValue();
            }
        }
        return new Matrix(res);
    }

    @Override
    public Var add(Matrix other) {

        if(this.value.length == other.value[0].length && this.value[0].length == other.value[0].length){
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = this.value[i][j] + other.value[i][j];
                }
            }
            return new Matrix(res);
        }
        return super.add(other);
    }

    @Override
    public Var add(Vector other) {
        return super.add(other);
    }

    @Override
    public Var sub(Scalar other) {

        double[][]res = new double[value.length][value[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = value[i][j] - other.getValue();
            }
        }
        return new Matrix(res);
    }

    @Override
    public Var sub(Matrix other) {

    if(this.value.length == other.value.length && this.value[0].length == other.value[0].length){
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = this.value[i][j] - other.value[i][j];
                }
            }
            return new Matrix(res);
        }
        return super.sub(other);
    }

    @Override
    public Var sub(Vector other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Scalar other) {
        double[][] res = new double[value.length][value[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = value[i][j] * other.getValue();
            }
        }
        return new Matrix(res);
    }

    @Override
    public Var mul(Vector other) {

        if (this.value[0].length == other.getValue().length) {
            double[] res = new double[value[0].length];
            for (int i = 0; i < value.length; i++) {
                res[i] = 0;
                for (int j = 0; j < value[0].length; j++) {
                    res[i] += this.value[i][j] * other.getValue()[j];
                }
            }
            return new Vector(res);
        }
        return super.mul(other);
    }

    @Override
    public Var mul(Matrix other) {

        if(this.value.length == other.value[0].length && this.value[0].length == other.value[0].length){
            double[][] res = new double[value.length][other.value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < other.value[0].length; j++) {
                    for (int k = 0; k < value[0].length; k++) {
                        res[i][j] += value[i][k]*other.value[k][j];
                    }
                }
            }
            return new Matrix(res);
        }
        else return super.mul(other);
    }

    @Override
    public Var div(Scalar other) {
        double[][] res = new double[value.length][value[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = value[i][j] / ((Scalar) other).getValue();
            }
        }
        return new Matrix(res);
    }

    @Override
    public Var div(Vector other) {
        return super.div(other);
    }

    @Override
    public Var div(Matrix other) {
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String delimetr = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimetr).append(value[i][j]);
                delimetr = ", ";
                if(j == value[0].length-1 && i != value.length-1)
                    sb.append("}, {");
            }
            delimetr ="";
        }
        sb.append("}}");
        return sb.toString();
    }
}
