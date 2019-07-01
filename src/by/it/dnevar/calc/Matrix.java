package by.it.dnevar.calc;

import java.util.Arrays;

class Matrix extends Var {
    private double[][] value;

    public double[][] getValue() {
        return value;
    }

    Matrix(double[][] value){
        this.value = value;
    }

    Matrix(Matrix matrix){
        this.value = matrix.value;
    }

    Matrix(String strMatrix){
        String str = strMatrix.substring(2,strMatrix.length()-2);
        str = str.replaceAll(" ","");
        String[] split1 = str.split("},\\{");
        String [][] split2 = new String[split1.length][];
        for (int i = 0; i < split1.length; i++) {
            split2[i] = split1[i].split(",");
        }
        value = new double[split1.length][split2[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                value[i][j]=Double.parseDouble(split2[i][j]);
            }
        }
    }

    @Override
    public Var add(Var other) throws CalcException{
        if (other instanceof Scalar){
            double[][] res = new double[this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                res[i] = Arrays.copyOf(this.value[i],this.value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j]+((Scalar)other).getValue();
                }
            }
            Log.setLog(Arrays.deepToString(this.value) +"+"+((Scalar)other).getValue()+"="+ Arrays.deepToString(res));
            return new Matrix(res);
        }else if(other instanceof Matrix){
            double[][] res = new double[this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                res[i] = Arrays.copyOf(this.value[i],this.value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    if(res.length==((Matrix)other).value.length && res[i].length==((Matrix)other).value[i].length){
                        res[i][j] = res[i][j]+((Matrix)other).value[i][j];
                    }else{
                        Log.setLog("Матрицы разной длинны");
                        throw new CalcException("Матрицы разной длинны");
                    }

                }
            }
            Log.setLog(Arrays.deepToString(value) +"+"+ Arrays.deepToString(((Matrix) other).value) +"="+ Arrays.deepToString(res));
            return new Matrix(res);
        }else{
            return super.add(other);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException{
        if (other instanceof Scalar){
            double[][] res = new double[this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                res[i] = Arrays.copyOf(this.value[i],this.value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j]-((Scalar)other).getValue();
                }
            }
            Log.setLog(Arrays.deepToString(value) +"-"+((Scalar)other).getValue()+"="+ Arrays.deepToString(res));
            return new Matrix(res);
        }else if(other instanceof Matrix){
            double[][] res = new double[this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                res[i] = Arrays.copyOf(this.value[i],this.value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res.length; j++) {
                    if(res.length==((Matrix)other).value.length && res[i].length==((Matrix)other).value[i].length){
                        res[i][j] = res[i][j]-((Matrix)other).value[i][j];
                    }else{
                        Log.setLog("Матрицы разной длинны");
                        throw new CalcException("Матрицы разной длинны");
                    }
                }
            }
            Log.setLog(Arrays.deepToString(value) +"-"+ Arrays.deepToString(((Matrix) other).value) +"="+ Arrays.deepToString(res));
            return new Matrix(res);
        }else{
            return super.sub(other);
        }
    }

    @Override
    public Var mul(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double[][] res = new double[this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                res[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    res[i][j] = res[i][j] * ((Scalar) other).getValue();
                }
            }
            Log.setLog(Arrays.deepToString(value) +"*"+((Scalar)other).getValue()+"="+ Arrays.deepToString(res));
            return new Matrix(res);
        }else if(other instanceof Vector){
            double[][] res = new double[this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                res[i] = Arrays.copyOf(this.value[i],this.value[i].length);
            }
            double[] vector = ((Vector)other).getValue();
            double[] sum = new double[vector.length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < vector.length; j++) {
                    if(vector.length==res.length) {
                        sum[i] = sum[i] + res[i][j] * vector[j];
                    }else{
                        Log.setLog("Разная длинна матрицы и вектора");
                        throw new CalcException("Разная длинна матрицы и вектора");
                    }
                }

            }
            Log.setLog(Arrays.deepToString(value) +"*"+((Vector)other).toString()+"="+ Arrays.deepToString(res));
            return new Vector(sum);
        }else if(other instanceof Matrix){
            double[][] res = new double[this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                res[i] = Arrays.copyOf(this.value[i],this.value[i].length);
            }
            double[][] result = new double[res.length][((Matrix)other).value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < ((Matrix)other).value[i].length; j++) {
                    for (int k = 0; k < ((Matrix)other).value.length; k++) {
                        if(res.length==((Matrix)other).value.length && res[j].length==((Matrix)other).value[j].length) {
                            result[i][j] = result[i][j] + res[i][k] * ((Matrix) other).value[k][j];
                        }else{
                            Log.setLog("Матрицы разной длинны");
                            throw new CalcException("Матрицы разной длинны");
                        }
                    }
                }
            }
            Log.setLog(Arrays.deepToString(value) +"*"+ Arrays.deepToString(((Matrix) other).value) +"="+ Arrays.deepToString(res));
            return new Matrix(result);
        } else{
            return super.mul(other);
        }
    }

    @Override
    public Var div(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double[][] res = new double[this.value.length][];
            for (int i = 0; i < this.value.length; i++) {
                res[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    if(((Scalar) other).getValue()!=0) {
                        res[i][j] = res[i][j] / ((Scalar) other).getValue();
                    }else{
                        Log.setLog("Деление на ноль");
                        throw new CalcException("Деление на ноль");
                    }
                }
            }
            Log.setLog(Arrays.deepToString(value) +"/"+((Scalar)other).getValue()+"="+ Arrays.deepToString(res));
            return new Matrix(res);
        }else{
            return super.div(other);
        }

    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("{{");
        String arrDelimiter = "}, {";
        for (int i = 0; i < value.length; i++) {
            String numDelimiter = "";
            for (int j = 0; j < value[i].length; j++) {
                str.append(numDelimiter).append(value[i][j]);
                numDelimiter = ", ";
            }
            if (i !=value.length-1) {
                str.append(arrDelimiter);
            }
        }
        str.append("}}");
        return str.toString();
    }
}
