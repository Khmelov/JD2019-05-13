package by.it.izaykoff.jd01_07;

import java.util.Arrays;

public class Matrix extends Var{

    private double[][] value;

    Matrix(double[][] value){
        this.value = value;
    }

    Matrix(Matrix matrix){
        this.value = matrix.value;
    }

    Matrix(String strMatrix){

        strMatrix = strMatrix.substring(2,strMatrix.length()-2);
        String[] splitElem = strMatrix.split("},\\{");

        String[][] strTwoAr = new String[splitElem.length][];
        for (int i = 0; i < strTwoAr.length; i++) {
            strTwoAr[i] = splitElem[i].split(",");
        }

        value = new double[strTwoAr.length][strTwoAr[0].length];

        for (int i = 0; i < value.length; i++) {
            splitElem[i].split(",");
            for (int j = 0; j < value[i].length; j++) {
                value[i][j] = Double.parseDouble(strTwoAr[i][j]);
            }
        }

//        String[] items = strMatrix.replaceAll("\\{","").replaceAll("[.0]","")
//                .replaceAll("\\}","").split(",");
//        value = new double[items.length];
//        for (int i = 0; i < items.length; i++) {
//            value[i] = Double.parseDouble(items[i]);


    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String delimetr2 = "},{";
        for (int i = 0; i < value.length; i++) {
            String delimetr = "";
            for (int j = 0; j < value[i].length; j++) {
                sb.append(delimetr).append(value[i][j]);
                delimetr = ", ";
            }
            if(i != value.length-1)
                sb.append(delimetr2);
        }
        sb.append("}}");
        return sb.toString();
    }
}
