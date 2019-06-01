package by.it.lasotskaya.jd01_07;

public class Matrix extends Var {
    private double[][] mas;

     Matrix(double[][] mas) {
        this.mas = mas;
    }
     Matrix(Matrix matrix){
        this.mas=matrix.mas;
    }
    public  Matrix(String strMas){
String [] matrix1 =strMas.replaceAll("[{}]","").split(",");
        String [] matrix2 =strMas.replaceAll("[{}+]","").split(",");
        double[][] mas = new double[matrix1.length][matrix2.length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int i1 = 0; i1 < matrix2.length; i1++) {
                mas[i][i1]=Double.parseDouble(strMas);
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder("{{");
        String delimeter ="";
        for (int i = 0; i < mas.length; i++) {
           for (int j = 0; j <mas[0].length ; j++) {
                stringBuilder.append(delimeter).append(mas[i][j]);
                if (j<mas.length-1){
                    delimeter = ", ";
                }
                else delimeter= "}, {";
            }
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();

    }
    }
