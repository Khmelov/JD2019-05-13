package by.it.lasotskaya.jd01_08;

public class Matrix extends Var {
    private double[][] mas;


     Matrix(double[][] mas) {
        this.mas = mas;
    }
     Matrix(Matrix matrix){
        this.mas=matrix.mas;
    }
    public  Matrix(String strMas){
        strMas=strMas.replaceAll("[{]+", "") + "},";
        String [] matrix1=strMas.split("[}]+,");
        mas = new double [matrix1.length][];
        String [] line;
        for (int i = 0; i < mas.length; i++) {
            line=matrix1[i].split(",");
            mas[i]=new double[line.length];
            for (int i1 = 0; i1 < line.length; i1++) {
                mas[i][i1]=Double.parseDouble(line[i1]);
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
