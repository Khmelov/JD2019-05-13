package by.it.maniuk.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {

    private double[][] value;

    public Matrix(double[][] value) {
        value = Arrays.copyOf(value, value.length);
        this.value = value;
    }
    public Matrix(Matrix matrix) {

        this.value = matrix.value;
    }
    public Matrix(String matrix) {
        String matrix1 = matrix;
        matrix1 = matrix1.replaceAll("\\{","").replaceAll("\\}","");
        matrix1 = matrix1.replaceAll("\\,"," ");
        String[] s = matrix1.trim().split(" ");
        int count =0;
        double[] d = new double[s.length];
        double[][] a = new double[d.length/2][d.length/2];
        for (int i = 0; i < s.length ; i++) {
            d[i] = Double.parseDouble(s[i]);
        }
        for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                a[i][j] = d[count++];
       }
        }
        this.value = a;

}

    @Override
    public String toString() {
       StringBuilder b = new StringBuilder();

        b.append("{{") ;
          for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                if (j == value[0].length-1) b.append(value[i][j]).append("}");
                if ( i==value.length-1 && j ==0)b.append(", {");
                if ((j != value[0].length-1)){b.append(value[i][j]).append(","); }

            }


        }
        b.append("}");
        return b.toString();
    }

}

