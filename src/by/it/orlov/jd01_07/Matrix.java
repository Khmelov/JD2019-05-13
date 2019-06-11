package by.it.orlov.jd01_07;

import java.util.Arrays;

class Matrix extends Var{
    public double[][] matrix;

    public Matrix(double[][] matrix){
        this.matrix = matrix;
    }
    public Matrix(Matrix matrix){
        this.matrix = matrix.matrix;
    }
    public Matrix(String strMatrix){
        String[] str = strMatrix.split("},\\{");
        double[][] m1 = new double[str.length][str[0].replaceAll("[{}]", "").split(",").length];
        for (int i = 0; i < str.length; i++) {
            String[] strM = str[i].replaceAll("[{}]", "").split(",");
            for (int k = 0; k < strM.length; k++) {
                m1[i][k]= Double.valueOf(strM[k]);
            }

        }
        this.matrix = m1;
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{");
        for (int i = 0; i < matrix.length; i++) {
            if (i == matrix[i].length - 1) {
                str.append(Arrays.toString(matrix[i]) + "}");
            } else {
                str.append(Arrays.toString(matrix[i])+",");
            }
        }
        String strS = str.toString();
        strS = strS.replaceAll("[]]","}").replaceAll("[\\[]","{");

        return strS;
    }
}
