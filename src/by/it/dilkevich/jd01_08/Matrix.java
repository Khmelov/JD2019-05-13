package by.it.dilkevich.jd01_08;

import java.util.Arrays;

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
        String [] mas = strMatrix.split("},");
        String [] firstMas = mas[0].split(",");
        String [] secondMas = mas[1].split(",");

        for (int i = 0; i < firstMas.length; i++) {
            firstMas[i] = firstMas[i].replace("{", "").replace("}", "");
        }
        for (int j = 0; j < secondMas.length; j++) {
            secondMas[j] = secondMas[j].replace("{", "").replace("}", "");
        }

        double [] tempMasFirst = new double[firstMas.length];
        for (int i = 0; i < firstMas.length; i++) {
            tempMasFirst[i] = Double.parseDouble(firstMas[i]);
        }
        double [] tempMasSecond = new double[secondMas.length];
        for (int j = 0; j < secondMas.length; j++) {
            tempMasSecond[j] = Double.parseDouble(secondMas[j]);
        }

        double[][] tempForMatrixMas = new double[firstMas.length][secondMas.length];


            for (int j = 0; j < secondMas.length; j++) {
            tempForMatrixMas[0][j] = tempMasFirst[j];
        }
            for (int j = 0; j < secondMas.length; j++) {
            tempForMatrixMas[1][j] = tempMasSecond[j];
        }
        this.value = tempForMatrixMas;

    }

    @Override
    public String toString() {
        StringBuilder sb1 = new StringBuilder("{{");
        StringBuilder sb2 = new StringBuilder("{");

        String delimeter = "";
        for (double x :
                this.value[0]) {
            sb1.append(delimeter).append(x);
            delimeter = ", ";
        }
        sb1.append("}, ");

        delimeter = "";
        for (double x :
                this.value[1]) {
            sb2.append(delimeter).append(x);
            delimeter = ", ";
        }
        sb2.append("}}");

        return sb1.append(sb2).toString();
    }

    @Override
    public Var add(Var other) {
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
    public Var sub(Var other) {
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
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double [][] result = new double[value.length][value[1].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[1].length; j++) {
                    result[i][j] = this.value[i][j];
                }
            }
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[1].length; j++) {
                    result[i][j] = result[i][j] * ((Matrix) other).value[i][j];
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
                double [] [] z = new double[value.length][value[0].length];
                for (int i = 0; i < value.length; i++) {
                    for (int j = 0; j < value[0].length; j++) {
                        for (int k = 0; k < value.length; k++) {
                            z[i][j] = z[i][j] + value[i][k] * ((Matrix) other).value[k][j];
                        }
                    }

                return new Matrix(z);
            }
        }
        return super.mul(other);
    }

}