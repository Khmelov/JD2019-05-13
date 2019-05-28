package by.it.yakovets.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {
    private double[][] value;

    public Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        String line = strMatrix.replaceAll("\\s", "");
        line = line.replaceAll("[\\{}]{2}", "");
        String[] masNstr = line.split("},\\{");
        double[][] mass=new double[2][2];
        for (int i = 0; i < masNstr.length; i++) {
            String arr[] = masNstr[i].split(",");
            for (int i1 = 0; i1 < arr.length; i1++) {

                mass[i][i1] = Double.parseDouble(arr[i1]);
            }
        }
        this.value=mass;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String del = "";
        for (int i = 0; i < value.length; i++) {
            for (int i1 = 0; i1 < value[0].length; i1++) {
                sb.append(del).append(value[i][i1]);
                del = ", ";
            }
            del = "},{";
        }
        sb.append("}}");
        return sb.toString();
    }
}
