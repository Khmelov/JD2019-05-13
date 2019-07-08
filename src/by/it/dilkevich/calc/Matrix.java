package by.it.dilkevich.calc;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private double [][] value;

    public double[][] getValue() {
        return value;
    }

    public Matrix(double[ ][ ] value){
        this.value = value;
    }

    public Matrix(Matrix matrix){
        this.value = matrix.value;
    }

    public Matrix(String strMatrix){
        int countStrings = 0;
        int countColumns;
        Pattern pattern = Pattern.compile("\\{\\d");
        Matcher matcher = pattern.matcher(strMatrix);
        while (matcher.find()){
            countStrings++;
        }
        String [] helper = strMatrix.split(",");
        for (int i = 0; i < helper.length; i++) {
            helper[i] = helper[i].replace("{", "").replace("}", "").replace(",", "").trim();
        }
        countColumns = helper.length / countStrings;
        double[][] result = new double[countStrings][countColumns];
        int temp = 0;
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = Double.parseDouble(helper[temp++]);
            }
        }
        this.value = result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        String delimetr = "";
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[0].length; j++) {
                sb.append(delimetr).append(value[i][j]);
                delimetr = ", ";
            }
            if((i + 1) == value.length)
                sb.append("}");
            else
            sb.append("}, ");
            delimetr = "";
        }
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Var add(Var other) throws CalcException, IOException {
        if(other instanceof Scalar){
            double [][] result = new double[value.length][value[1].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[1].length; j++) {
                    result[i][j] = this.value[i][j];
                }
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[1].length; j++) {
                    result[i][j] = result[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        else if(other instanceof Matrix){
            double [][] result = new double[value.length][value[1].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[1].length; j++) {
                    result[i][j] = this.value[i][j];
                }
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[1].length; j++) {
                    result[i][j] = result[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException, IOException {
        if(other instanceof Scalar){
            double [][] result = new double[value.length][value[1].length];

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[1].length; j++) {
                    result[i][j] = this.value[i][j];
                }
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[1].length; j++) {
                    result[i][j] = result[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        else if(other instanceof Matrix){
            double [][] result = new double[value.length][value[1].length];

            if(((Matrix) other).value.length != result.length || ((Matrix) other).value[0].length != result[0].length){
                Logger.setLog(ResManager.getName("error.matrix.sub"));
                throw new CalcException(ResManager.getName("error.matrix.sub"));
            }


            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[1].length; j++) {
                    result[i][j] = this.value[i][j];
                }
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[1].length; j++) {
                    result[i][j] = result[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException, IOException {
        if (other instanceof Scalar){
            double [][] result = new double[value.length][value[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = this.value[i][j];
                }
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    result[i][j] = result[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        if(other instanceof Vector){
            double [] multMasVector = new double[value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                    multMasVector[i] = multMasVector[i] + value[i][j]*((Vector) other).getValue()[j];
                }
            }
            return new Vector(multMasVector);
        }

        else if(other instanceof Matrix){
            double [] [] z = new double[value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        z[i][j] = z[i][j] + value[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(z);

        }
        return super.mul(other);
    }

}