package by.it.dilkevich.jd01_07;

import java.util.Arrays;

public class Matrix extends Var{

    private double [][] value;

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
}