package by.it.guchek.jd01_08;

import java.util.Arrays;

public class Matrix extends Var {

    private double [][] value;

    public Matrix(double[][] value) {

        this.value= Arrays.copyOf(value, value.length);
    }

    public Matrix(Matrix matrix){
        this.value=matrix.value;
    } //констр. матрицы

    public Matrix(String strMatrix){

        String [] sMatr=strMatrix.split("},\\{|},\\s\\{");
        double [][] matr1 = new double[sMatr.length][ sMatr[0].replaceAll("[{}\\s]","").trim().split(",").length];
        //String[] str = sVect.split(",");
        for (int i = 0; i <sMatr.length ; i++) {
            String[] sMatrFull = sMatr[i].replaceAll("[{}]","").split(",");

            for (int j = 0; j <sMatrFull.length ; j++) {
                matr1[i][j]=Double.parseDouble(sMatrFull[j]);

            }
        }
        this.value=matr1;
    }



    @Override
    public Var add(Var other) {
        if (other instanceof Matrix){  //будет идти сравнение длин
            double [] [] sumArr= new double[this.value.length][this.value[0].length];
            for (int i = 0; i <sumArr.length ; i++) {
                for (int j = 0; j <sumArr[0].length ; j++) {
                    sumArr[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                }
            }
                return new Matrix(sumArr);
            }
        else if (other instanceof Scalar){
            double [] [] sumArr= new double[this.value.length][this.value[0].length];
            for (int i = 0; i <this.value.length ; i++) {
                for (int j = 0; j <sumArr[0].length ; j++) {
                    sumArr[i][j] = this.value[i][j] + ((Scalar) other).getValue();
                }
            }
                return new Matrix(sumArr);}
        return super.add(other);
        }


    @Override
    public Var sub(Var other) {
        if (other instanceof Matrix){  //будет идти сравнение длин
            double [] [] subArr= new double[this.value.length][this.value[0].length];
            for (int i = 0; i <subArr.length ; i++) {
                for (int j = 0; j <subArr[0].length ; j++) {
                    subArr[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(subArr);
        }
        else if (other instanceof Scalar){
            double [] [] subArr= new double[this.value.length][this.value[0].length];
            for (int i = 0; i <this.value.length ; i++) {
                for (int j = 0; j <subArr[0].length ; j++) {
                    subArr[i][j] = this.value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(subArr);}
        return super.add(other);
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
