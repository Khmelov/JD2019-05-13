package by.it.maniuk.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {

    double[][] value;

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
        matrix1 = matrix1.replaceAll("\\,","");
        String[] s = matrix1.trim().split(" ");
        double[] d = new double[s.length];
        for (int i = 0; i <s.length ; i++) {
            d[i] = Double.parseDouble(s[i]);
            double[][] a = new double[d.length / 2][d.length / 2];
            for (int f = 0; f < a.length; f++) {
                for (int j = 0; j < a[0].length; j++)

                    if (j <= a.length / 2) a[0][j] = d[j];
                    else a[f][0] = d[j];
            }

        }

       this.value =new  double[][] {{1.0, 2.0},{3.0, 4.0}};
}

    @Override
    public String toString() {
       StringBuilder b = new StringBuilder();

        b.append("{{") ;
          for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
                if (j == value[0].length-1) b.append(value[i][j]).append("}");
                if ( i==value.length-1 && j ==0)b.append(",{");
                if ((j != value[0].length-1)){b.append(value[i][j]).append(","); }

            }


        }
        b.append("}");
        return b.toString();
    }

}

