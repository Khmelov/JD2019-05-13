package by.it.tbabich.jd01_07;

import java.util.Arrays;

class Matrix extends Var {

    private double[][] value;

    public Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Matrix(Matrix matrix) {
        this(matrix.value);
    }

    public Matrix(String strMatrix) {
        String[] arrayString = strMatrix.replace("{","").replace("},"," ").replace("}", "").split(" ");
        double[][] arrayDouble = new double[arrayString.length][arrayString[0].length()];
        for (int i = 0; i < arrayString.length; i++) {
            String[] arrayStringElement = arrayString[i].split(",");
            double[] arrayDoubleElement = new double[arrayStringElement.length];
            for (int j = 0; j < arrayDoubleElement.length; j++) {
                arrayDoubleElement[j] = Double.parseDouble(arrayStringElement[j]);
            }
            arrayDouble[i] = Arrays.copyOf(arrayDoubleElement, arrayDouble.length);
        }
        this.value = Arrays.copyOf(arrayDouble, arrayDouble.length);
    }

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
                sb.append(",");
            }
            if (i == value.length - 1){
                sb.append("}");
                break;
            }
            sb.append(",");
        }
        return sb.toString();
    }
}
