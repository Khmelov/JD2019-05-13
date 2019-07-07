package by.it.adamovichjr.calc;


import by.it.adamovichjr.calc.text.All_messages;

import java.util.Arrays;

public class Matrix extends Var {

    private double [][] value;

    public double[][] getValue() {
        return value;
    }



    Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);
        for (int i = 0; i < value.length; i++) {
            this.value[i] = Arrays.copyOf(value[i], value[i].length);
        }
    }
    Matrix(Matrix matrix){
        double [][]buffer = Arrays.copyOf(matrix.value,matrix.value.length);
        for (int i = 0; i < matrix.value.length; i++) {
            buffer[i] = Arrays.copyOf(matrix.value[i],matrix.value.length);
        }
        this.value = buffer;
    }

    Matrix(String str) throws CalcException {
        str = str.replaceAll("[^-\\d.] ?"," ").trim();
        String[]line = str.split("[ ]{2,}");

        double[][] mas = new double[line.length][];

        for (int i = 0; i < mas.length; i++) {
            String[] count = line[i].split(" ");
            mas[i] = new double[count.length];
            if (i > 0 && mas[i].length != mas[i-1].length) {
                throw new CalcException (ResourceManager.INSTANCE.get(All_messages.WRONG_CREATE_MATRIX));
            }
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = Double.parseDouble(count[j]);
            }
        }
        this.value = mas;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if(other instanceof Scalar){
            double[][]res = new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = value[i][j] + ((Scalar)other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if(other instanceof Matrix){
            if (this.value.length != ((Matrix) other).value.length|| this.value[0].length != ((Matrix) other).value[0].length) {
                throw new CalcException(String.format(ResourceManager.INSTANCE.get(All_messages.ADD_MATRIX), this, other));
            }
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = this.value[i][j] + ((Matrix)other).value[i][j];
                }
            }
            return new Matrix(res);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if(other instanceof Scalar){
            double[][]res = new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = value[i][j] - ((Scalar)other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if(other instanceof Matrix ){
            if (this.value.length != ((Matrix) other).value.length|| this.value[0].length != ((Matrix) other).value[0].length) {
                throw new CalcException(String.format(ResourceManager.INSTANCE.get(All_messages.SUB_MATRIX), this, other));
            }
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = this.value[i][j] - ((Matrix)other).value[i][j];
                }
            }
            return new Matrix(res);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if(other instanceof Scalar) {
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Vector){
            if (this.value[0].length != ((Vector) other).getValue().length) {
                throw new CalcException(String.format(ResourceManager.INSTANCE.get(All_messages.MUL_MAT_AND_VECTOR), this, other));
            }
            double[] res = new double[value[0].length];
            for (int i = 0; i < value.length; i++) {
                res[i] = 0;
                for (int j = 0; j < value[0].length; j++) {
                    res[i] += this.value[i][j]*((Vector)other).getValue()[j];
                }
            }
            return new Vector(res);
        }
        else if(other instanceof Matrix){
            if (this.value[0].length != ((Matrix) other).value.length) {
                throw new CalcException(String.format(ResourceManager.INSTANCE.get(All_messages.MUL_MATRIX), this, other));
            }
            double[][] res = new double[value.length][((Matrix)other).value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < ((Matrix)other).value[0].length; j++) {
                    for (int k = 0; k < value[0].length; k++) {
                        res[i][j] += value[i][k]*((Matrix)other).value[k][j];
                    }
                }
            }
            return new Matrix(res);
        }
        else return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if(other instanceof Scalar) {
            if (((Scalar) other).getValue() == 0) throw new CalcException(ResourceManager.INSTANCE.get(All_messages.ZERO_DIV));
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = value[i][j] / ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
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
