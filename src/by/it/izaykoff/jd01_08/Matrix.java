package by.it.izaykoff.jd01_08;

import java.util.Arrays;

public class Matrix extends Var{

    private double[][] value;

    public double[][] getValue() {
        return value;
    }

    Matrix(double[][] value){
        this.value = value;
    }

    Matrix(Matrix matrix){
        this.value = matrix.value;
    }

    Matrix(String strMatrix){

        strMatrix = strMatrix.substring(2,strMatrix.length()-2);
        strMatrix=strMatrix.replaceAll(" ","");
        String[] splitElem = strMatrix.split("},\\{");

        String[][] strTwoAr = new String[splitElem.length][];
        for (int i = 0; i < strTwoAr.length; i++) {
            strTwoAr[i] = splitElem[i].split(",");
        }

        value = new double[strTwoAr.length][strTwoAr[0].length];

        for (int i = 0; i < value.length; i++) {
            splitElem[i].split(",");
            for (int j = 0; j < value[i].length; j++) {
                value[i][j] = Double.parseDouble(strTwoAr[i][j]);
            }
        }
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Matrix){

            double[][] result = Arrays.copyOf(value,value.length);
            double[][] sum = new double[result.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    sum[i][j] = result[i][j] + ((Matrix) other).value[i][j];
                }
            }return new Matrix(sum);
        }
        else if(other instanceof Scalar) {
            double[][] result = Arrays.copyOf(value,value.length);
            double[][] sum = new double[result.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    sum[i][j] = result[i][j] + ((Scalar) other).getValue();
                }
            }return new Matrix(sum);
        }
        else
            return super.add(other);
        }

    @Override
    public Var sub(Var other) {
        if (other instanceof Matrix){
            double[][] result = Arrays.copyOf(value,value.length);
            double[][] sum = new double[result.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    sum[i][j] = result[i][j] - ((Matrix) other).getValue()[i][j];
                }
            }
            return new Matrix(sum);
        }else if(other instanceof Scalar){
            double[][] result = Arrays.copyOf(value,value.length);
            double[][] sum = new double[result.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    sum[i][j] = result[i][j] - ((Scalar) other).getValue();
                }
            }return new Matrix(sum);
        }else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Matrix){
            double[][] result = Arrays.copyOf(value,value.length);
            double[][] sum = new double[result.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    for (int g = 0; g < value.length; g++) {
                        sum[i][j] = sum[i][j] + result[i][g] * ((Matrix) other).getValue()[g][j];
                    }
                }
            }
            return new Matrix(sum);
        }else if (other instanceof Scalar){
                double[][] result = Arrays.copyOf(value,value.length);
                double[][] sum = new double[result.length][this.value[0].length];
                for (int i = 0; i < result.length; i++) {
                    for (int j = 0; j < result[i].length; j++) {
                        sum[i][j] = result[i][j] * ((Scalar) other).getValue();
                    }
                }
                return new Matrix(sum);
        }else if(other instanceof Vector){
            double[][] result = Arrays.copyOf(value,value.length);
            double[] resVec = new double[value.length];
            double[] copyVec = Arrays.copyOf(((Vector) other).getValue(),((Vector) other).getValue().length);
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < copyVec.length; j++) {
                    resVec[i] = resVec[i] + result[i][j] * copyVec[j];
                }
            }return new Vector(resVec);
        }else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double[][] result = Arrays.copyOf(value,value.length);
            double[][] sum = new double[result.length][this.value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    sum[i][j] = result[i][j] + ((Scalar) other).getValue();
                }
            }return new Matrix(sum);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String delimetr2 = "}, {";
        for (int i = 0; i < value.length; i++) {
            String delimetr = "";
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimetr).append(value[i][j]);
                delimetr = ", ";
            }
            if(i != value.length-1)
                sb.append(delimetr2);
        }
        sb.append("}}");
        return sb.toString();
    }
}
