package by.it.guchek.jd01_08;

import java.util.Arrays;

public class Matrix extends Var {

    private double [][] value;

    public Matrix(double[][] value) {

        this.value= Arrays.copyOf(value, value.length);
    }

    public Matrix(Matrix matrix){
        this.value=matrix.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimetr1 = "{", delimetr2 = "}";
        for (int i=0; i<value.length; i++) {
            sb.append(delimetr1); //.append(element);
            for (int j = 0; j <value[0].length ; j++) {
                sb.append(value[i][j]);
                if (j==value[0].length-1){
                    sb.append(delimetr2);
                    break;
                }
                sb.append(",").append(" ");
            }
            if (i==value.length-1){
                sb.append(delimetr2);
                break;
            }
            sb.append(", ");
        }
        return sb.toString();
    }

}
