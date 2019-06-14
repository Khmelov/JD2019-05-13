package by.it.zhukova.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private double [] [] value;

    Matrix(double[ ][ ]  value) {
       double  [][] row= new double[value[0].length][value.length];
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < row[0].length; j++) {
            row [i] [j]= value[i][j];
        }
        }
    this.value= row;
    }

    Matrix(Matrix matrix) {
    this.value=matrix.value;
    }

     Matrix(String strMatrix) {
         Pattern p1 = Pattern.compile("\\p{Punct}{3,}");
         Matcher m1 = p1.matcher(strMatrix);
         int posCol = 0;
         int k=0;
         while (m1.find()){
             if (posCol==0) {
                 posCol=m1.start();
             }
             k++;
         }
         Pattern p2 = Pattern.compile("\\d+\\.*\\d*");
         Matcher m2 = p2.matcher(strMatrix);
         int m=0;//счетчик столбцов по элементам
         while (m2.find()){
             if (posCol<m2.start()) {
                 m2.reset();
                 break;
             }
             m++;
         }
         double [ ][] matrixResult = new double[k+1][m];
         int i=0;
         int j=0;
         while (m2.find()){
             matrixResult[i][j]=Double.parseDouble(m2.group());
             j++;
             if (j==m) {
                 i++;
                 j = 0;
             }
         }
        this.value= matrixResult;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("{");

       for (int i = 0; i < value.length; i++) {
           String delimiter = "";
            out.append("{");
            for (int j = 0; j < value[0].length; j++) {
            out.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }
            out.append("}");
           if (i<value.length-1) out.append(",");
        }
         out.append("}");
    return out.toString();
    }
}
