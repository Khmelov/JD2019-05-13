package by.it.tbabich.jd01_07;

import java.util.Arrays;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Matrix(Matrix matrix) {
        this(matrix.value);
    }

    Matrix(String strMatrix) {
        String[] arrayString = strMatrix.replace("{","").replace("},"," ").replace("}", "").split(" ");
        double[][] arrayDouble = new double[arrayString.length][(arrayString[0].length() + 1) / 2];
        for (int i = 0; i < arrayString.length; i++) {
            String[] arrayStringElement = arrayString[i].split(",");
            double[] arrayDoubleElement = new double[arrayStringElement.length];
            for (int j = 0; j < arrayDoubleElement.length; j++) {
                arrayDoubleElement[j] = Double.parseDouble(arrayStringElement[j]);
            }
            arrayDouble[i] = Arrays.copyOf(arrayDoubleElement, arrayDoubleElement.length);
        }
        this.value = Arrays.copyOf(arrayDouble, arrayDouble.length);
    }

<<<<<<< HEAD
=======


>>>>>>> 3abf1a8c53a58aa3c04bb02acc8bea4f6e0447df
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < value.length; i++) {
            sb.append("{");
            for (int j = 0; j < value[0].length; j++) {
                sb.append(value[i][j]);
                if (j == value[0].length - 1){
                    sb.append("}");
                    break;
                }
                sb.append(", ");
            }
            if (i == value.length - 1){
                sb.append("}");
                break;
            }
            sb.append(", ");
        }
        return sb.toString();
    }
}
