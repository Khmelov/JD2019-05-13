package by.it.livanovich.calc;

import by.it.livanovich.calc.Text.Helper;
import by.it.livanovich.calc.Text.Messages;

class Matrix extends Var {
    private double[][] value;

    public Matrix() {

    }


    public double[][] getValue() {
        return value;
    }

    Matrix(double[][] value) {
        this.value = value;
    }

    public int getLength() {
        return value[0].length;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix (String strMatrix) {
        String [] part=strMatrix.split("},");
        double [][]temp=new double[part.length][part[0].replaceAll("\\{\\{|}|\\{|\\s","").split(",").length];
        for (int i = 0; i < part.length; i++) {
            String [] col=part[i].replaceAll("\\{\\{|}|\\{|\\s","").split(",");
            for (int j=0; j<col.length; j++){
                temp [i][j]=Double.parseDouble(col[j]);
            }
        }

        this.value = temp;

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double[] row : value) {
            delimiter = "";
            if (sb.length() > 1) sb.append(", ");
            sb.append("{");
            for (double element : row) {
                sb.append(delimiter).append(element);
                delimiter = ", ";
            }
            sb.append("}");
        }

        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double[][] res =new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Matrix) {
            if (value.length!=((Matrix) other).getLength()){
                throw new CalcException(Helper.INSTANCE.getKey(Messages.MATRIXSIZE));
            }
            double[][] res =new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j] +  ((Matrix) other).value[i][j];
                }
            }
                return new Matrix(res);
        }
            else
            return super.add(other);
    }




    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] res =new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Matrix) {
            if (value[0].length!=((Matrix) other).getLength()){
                throw new CalcException(Helper.INSTANCE.getKey(Messages.MATRIXSIZE));
            }
            double[][] res =new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j] -  ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        }
        else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double[][] res =new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Vector){
            double [] res=new double[value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                    res [i]=res [i] + value[i][j]* ((Vector) other).getValue()[j];
                }
            }
            return new Vector(res);
        }
        else if (other instanceof Matrix) {
            double[][] res =new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        res[i][j] = res[i][j] + value[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(res);
        }
        else
           return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else
        return super.div(other);
    }
}

