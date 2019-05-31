package by.it.livanovich.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var{
    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }
    Matrix (Matrix matrix){
        this.value=matrix.value;
    }

    Matrix (String strMatrix) {
        StringBuilder sbmatrix = new StringBuilder(strMatrix);
        Pattern p = Pattern.compile("}");
        Matcher m = p.matcher(strMatrix);
        while (m.find()) {
            int middle = m.start();
            String[] first = strMatrix.substring(0, middle).replace("\\D+", " ").trim().split(" ");
            String[] second = strMatrix.substring(middle+3, strMatrix.length() - 1).replace("\\D+", " ").trim().split(" ");
            double[][] temp = new double[first.length][second.length];
            for (int i = 0; i < first.length; i++) {
                for (int j = 0; j < second.length; j++) {
                    temp[j][j] = Double.parseDouble(second[j]);
                }
            }
            this.value = temp;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{");
        String delimiter="";
        for (double []row:value){
            delimiter="";
            if(sb.length() > 1) sb.append(",");
            sb.append("{");
            for (double element:row){
                 sb.append(delimiter).append(element);
            delimiter=", ";}
            sb.append("}");
            }

            sb.append("}");
        return sb.toString();
    }
}


