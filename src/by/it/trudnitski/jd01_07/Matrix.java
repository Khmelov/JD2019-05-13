package by.it.trudnitski.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {
    private double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }
    public Matrix(Matrix matrix){
        this.value=matrix.value;
    }
    public Matrix(String strMatrix){
        strMatrix=strMatrix.replaceAll("[^\\d.]+"," ").trim();
        String []line=strMatrix.split("[ ]+");
        double [][] res=new double[line.length/2][line.length/2];
        int k=0;
        for (int i = 0; i <res.length ; i++) {
            for (int j = 0; j <res[0].length ; j++) {
                res[i][j]=Double.parseDouble(line[k]);
                k++;
            }
            this.value=res;
        }
    }
    @Override
    public String toString() {
        StringBuilder str=new StringBuilder("{");
        String delimeter="{";
        String delimeter1="";
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j <value[0].length ; j++) {

                str.append(delimeter).append(value[i][j]).append(delimeter1);
                delimeter=", ";
            }
            delimeter="},{";
        }
        str.append("}}");
        Arrays.toString(value);
        return str.toString();
    }
}
