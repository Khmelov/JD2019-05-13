package by.it.yakimovich.jd01_07;

public class Matrix extends Var {

    double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }


    Matrix(String strMatrix){
        strMatrix=strMatrix.replaceAll("\\{","");
        strMatrix=strMatrix.replaceAll("\\}","");
        String[] stre=strMatrix.split(",");
        double[][] strM=new double[stre.length][1];
        for (int i = 0; i <stre.length ; i++) {
            for (int j = 0; j <stre[i].length() ; j++) {
                strM[i][j]=Double.parseDouble(stre[i]);


            }

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
