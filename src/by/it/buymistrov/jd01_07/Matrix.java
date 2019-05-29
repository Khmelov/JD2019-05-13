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


        String[] str = strMatrix.split("},\\{");
        String[] first = str[0].replaceAll("[\\{\\}]", " ").trim().split(",");
        String[] second = str[1].replaceAll("[]\\{\\}]", " ").trim().split(",");

        double[][] strArray = new double[str.length][str.length];


        strArray[0][0] = Double.parseDouble(first[0]);
        strArray[1][0] = Double.parseDouble(second[0]);


        strArray[0][1] = Double.parseDouble(first[1]);
        strArray[1][1] = Double.parseDouble(second[1]);

        this.value = strArray;

    }


    @Override
    public String toString() {
        String out = Arrays.deepToString(value)
                .replaceAll("\\[", "{")
                .replaceAll("\\]", "}");
        return out;

    }

}
