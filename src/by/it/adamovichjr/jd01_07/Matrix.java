package by.it.adamovichjr.jd01_07;


public class Matrix extends Var{
    private double [][] value;

    Matrix(double[][] value) {
        this.value = value;
    }
    Matrix(Matrix matrix){
        this.value = matrix.value;
    }
    Matrix(String str){
        str = str.replaceAll("[^\\d.]+"," ").trim();
        String[]split = str.split("[ ]+");
        int lenght = (int) Math.sqrt(split.length);
        double[][]mas = new double[lenght][lenght];
        int count = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                mas[i][j] = Double.parseDouble(split[count]);
                count++;
            }
        }
        this.value = mas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String delimetr = "";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[0].length; j++) {
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
