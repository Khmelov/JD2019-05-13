package by.it.guchek.calc2;

import by.it.guchek.jd02_05.names.CalcErrors;

import java.util.Arrays;

import static by.it.guchek.calc2.ConsoleRunner.managerC;

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
    public Var add(Var other) throws CalcException {
        if (other instanceof Matrix){  //будет идти сравнение длин
            double [] [] sumArr= new double[this.value.length][this.value[0].length];

            if ((!(sumArr.length==((Matrix) other).value.length))||(!(sumArr[0].length==((Matrix) other).value[0].length)))
                throw new CalcException(managerC.get(CalcErrors.MATRIX_NOT_EQUAL));

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
    public Var sub(Var other) throws CalcException {
        if (other instanceof Matrix){  //будет идти сравнение длин
            double [] [] subArr= new double[this.value.length][this.value[0].length];

            if ((!(subArr.length==((Matrix) other).value.length))||(!(subArr[0].length==((Matrix) other).value[0].length)))
                throw new CalcException(managerC.get(CalcErrors.MATRIX_NOT_EQUAL));

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
    public Var mul(Var other) {
        if (other instanceof Matrix) {
            double[][] mulMatrRes = new double[this.value.length][((Matrix) other).value[0].length];  //инициирую резельтирующий массив
            for (int i = 0; i < mulMatrRes.length; i++)
                for (int j = 0; j < mulMatrRes[0].length; j++)
                    for (int k = 0; k < ((Matrix) other).value.length; k++)
                        mulMatrRes[i][j] = mulMatrRes[i][j] + this.value[i][k] * ((Matrix) other).value[k][j];
            return new Matrix(mulMatrRes);
        }

        else if (other instanceof Vector){
            double [][] mulMatrVectRes = new double [1][this.value.length];  //инициирую резельтирующий массив
            for (int i = 0; i <this.value.length ; i++)
                for (int j = 0; j <((Vector) other).getValue().length; j++) {
                    mulMatrVectRes [0][i]=mulMatrVectRes[0][i] + this.value[i][j]*((Vector) other).getValue()[j];
                }

            return new Matrix(mulMatrVectRes);
        }
        else {
            double[][] mulMatrScalarRez = new double[this.value.length][this.value[0].length];

            for (int i = 0; i < this.value.length; i++)
                for (int j = 0; j <this.value[0].length ; j++) {
                mulMatrScalarRez[i][j] = this.value[i][j] * ((Scalar) other).getValue();
            }
            return new Matrix(mulMatrScalarRez);
        }
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar){
            if (((Scalar) other).getValue() == 0)
                throw new CalcException(managerC.get(CalcErrors.DIVNULL));
            double[][] divMatrScalarRez = new double[this.value.length][this.value[0].length];

        for (int i = 0; i < this.value.length; i++)
            for (int j = 0; j <this.value[0].length ; j++) {
                divMatrScalarRez[i][j] = this.value[i][j] / ((Scalar) other).getValue();
            }
        return new Matrix(divMatrScalarRez);
    } else return super.div(other);
    }


    @Override
    public String toString() {
        //StringBuilder sb = new StringBuilder();
        if (value.length==1) {
            StringBuilder sb = new StringBuilder("");
           String delimetr = "";
                sb.append("{");
            for (int i = 0; i < value[0].length; i++) {
                double doubles = value[0][i];
                sb.append(delimetr).append(doubles);
                delimetr = ", ";
            }
                sb.append("}");
                return sb.toString();
        }
        else {
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

}
