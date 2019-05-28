package by.it.aadamovich.jd01_07;

import java.util.Arrays;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = Arrays.copyOf(matrix.value, matrix.value.length);
    }

    Matrix(String strMatrix) {

        String matrixProcessed = strMatrix.replaceAll("[({|})].?[({|})]", "  ").trim();
        String[] linesOfMatrix = matrixProcessed.split("[ ]{2,}");

        double[][] buffer = new double[linesOfMatrix.length][];

        for (int i = 0; i < buffer.length; i++) {
            String[] elementsInLine = linesOfMatrix[i].split("[^\\d.]+");
            buffer[i] = new double[elementsInLine.length];

            for (int j = 0; j < buffer[i].length; j++) {
                buffer[i][j] = Double.parseDouble(elementsInLine[j]);
            }
        }
        this.value = buffer;

    }

    @Override
    public String toString() {

        StringBuilder strBuilder = new StringBuilder("{{");

        for (int i = 0; i < value.length; i++) {
            String delimiter = "";

            for (int j = 0; j < value[i].length; j++) {
                strBuilder.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }

            if (i == value.length - 1) {
                strBuilder.append("}}");
            } else {
                strBuilder.append("}, {");
            }
        }
        return strBuilder.toString();
    }
}
