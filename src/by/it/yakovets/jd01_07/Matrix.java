package by.it.yakovets.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private double[][] value;

    public Matrix(double[][] value) {
        double copy[][] = new double[value.length][value[0].length];
        for ( int i = 0 ; i < value.length; ++i)
        {
            System.arraycopy(value[i], 0, copy[i], 0, value[i].length);
        }

        this.value = copy;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        String line = strMatrix.replaceAll("\\s", "");
        line = line.replaceAll("[\\{}]{2}", "");
        Pattern pat=Pattern.compile("},\\{");
        Matcher matcher=pat.matcher(line);
        int count=0;
        while (matcher.find()){
            count++;
        }
        String[] masNstr = line.split("},\\{");
        double[][] mass = new double[masNstr.length][count+1];
        for (int i = 0; i < masNstr.length; i++) {
            String arr[] = masNstr[i].split(",");
            for (int i1 = 0; i1 < arr.length; i1++) {
                mass[i][i1] = Double.parseDouble(arr[i1]);
            }
        }
        this.value = mass;
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
