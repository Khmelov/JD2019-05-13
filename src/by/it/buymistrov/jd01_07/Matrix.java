package by.it.buymistrov.jd01_07;

import java.util.Arrays;


public class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;

    }

    Matrix(String strMatrix) {


        String[] stringMatrix = strMatrix.split("},\\{");
        String[] strLine = new String[stringMatrix.length];
        String[][] splittedStrLine = new String[strLine.length][strLine.length];


        for (int i = 0; i < strLine.length; i++) {
            strLine[i] = (stringMatrix[i].replaceAll("[\\,\\{\\}]", " ").trim());
            splittedStrLine[i] = strLine[i].split(" ");

        }

        double[][] strOut = new double[splittedStrLine.length][splittedStrLine.length];
        for (int i = 0; i < splittedStrLine.length; i++) {
            for (int j = 0; j < splittedStrLine.length; j++) {

                strOut[i][j] = Double.parseDouble(splittedStrLine[i][j]);
            }
        }


        this.value = strOut;

    }


    @Override
    public String toString() {
        String out = Arrays.deepToString(value)
                .replaceAll("\\[", "{")
                .replaceAll("\\]", "}");
        return out;

    }

}
