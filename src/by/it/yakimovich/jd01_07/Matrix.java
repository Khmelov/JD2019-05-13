package by.it.yakimovich.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {

    double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }


    Matrix(String strMatrix){
        strMatrix=strMatrix.replace("{","");
        strMatrix=strMatrix.replace("},"," ");
        strMatrix=strMatrix.replace("}","");
        String[] stre=strMatrix.split(" ");
        double[][] strM=new double[stre.length][stre[0].length()/2];
        for (int i = 0; i <stre.length ; i++) {
        String[]  elemString=stre[i].split(",");
        double[] elemDouble= new double[elemString.length];
            for (int j = 0; j < elemDouble.length; j++) {
                elemDouble[j] = Double.parseDouble(elemString[j]);
            }
            strM[i]=Arrays.copyOf(elemDouble,elemDouble.length);
       }
        this.value= strM;
    }



    @Override
    public String toString() {

            StringBuilder sb=new StringBuilder("{{");
            String delimeter="";

            for (double[] element:value) {
                for (double em:element) {


                    sb.append(delimeter).append(em);
                    delimeter = ",";
                }
                delimeter = "},{";
            }

            sb.append("}}");
            return sb.toString();
    }
}
