package by.it.adamovichjr.jd01_07;


import java.util.Arrays;

public class Matrix extends Var{
    private double [][] value;

    Matrix(double[][] value) {
        this.value = value;
    }
    Matrix(Matrix matrix){
        double [][]buffer = Arrays.copyOf(matrix.value,matrix.value.length);
        this.value = buffer;
    }
    Matrix(String str){
        str = str.replaceAll("[^\\d.] ?"," ").trim();
        String[]line = str.split("[ ]{2,}");
        double[][] mas = new double[line.length][];
        for (int i = 0; i < mas.length; i++) {
            String[] count = line[i].split(" ");
            mas[i] = new double[count.length];
            for (int j = 0; j < mas[i].length; j++) {
                mas[i][j] = Double.parseDouble(count[j]);
            }
        }
        this.value = mas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String delimetr = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimetr).append(value[i][j]);
                delimetr = ", ";
                if(j == value[0].length-1 && i != value.length-1)
                    sb.append("}, {");
            }
            delimetr ="";
        }
        sb.append("}}");
        return sb.toString();
    }
}
