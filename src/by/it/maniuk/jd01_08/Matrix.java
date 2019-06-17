package by.it.maniuk.jd01_08;

import java.util.Arrays;

public class Matrix extends Var {

    private double[][] value;

    public Matrix(double[][] value) {
        value = Arrays.copyOf(value, value.length);
        this.value = value;
    }
    public Matrix(Matrix matrix) {
        double [][] val = Arrays.copyOf(matrix.value,matrix.value.length);
        this.value = val;
    }
    public Matrix(String matrix) {
            matrix = matrix.replaceAll("[^\\d.] ?", " ").trim();
            String[] line = matrix.split("[ ]{2,}");
            double[][] mas = new double[line.length][];
            for (int i = 0; i < mas.length; i++) {
                String[] count = line[i].split(" ");
                mas[i] = new double[count.length];
                for (int j = 0; j < mas[i].length; j++) {
                    mas[i][j] = Double.parseDouble(count[j]);
                }
            }
            this.value = mas;
        }



    public double[][] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double[][] res =Arrays.copyOf(value, value.length) ;
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j <res[0].length ; j++) {
                    res[i][j] = res[i][j]+((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
            }
        else if (other instanceof Matrix){
            double[][] res =Arrays.copyOf(value, value.length) ;
            int matrixLeight = ((Matrix) other).getValue().length;
            double[][] z = new double[res.length][matrixLeight];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j <res[0].length ; j++) {
                    z[i][j] = res[i][j]+((Matrix) other).getValue()[i][j];
                }
            }
            return new Matrix(z);
        }


        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = res[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Matrix){
            double[][] res =Arrays.copyOf(value, value.length) ;
            int matrixLeight = ((Matrix) other).getValue().length;
            double[][] z = new double[res.length][matrixLeight];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j <res[0].length ; j++) {
                    z[i][j] = res[i][j]-((Matrix) other).getValue()[i][j];
                }
            }
            return new Matrix(z);
        }

        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = res[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }

       else if (other instanceof Vector) {
            double[][] res = Arrays.copyOf(value, value.length);
            double[] z = new double[res.length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    z[i] = z[i] + res[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector(z);
        }
       else if (other instanceof Matrix) {
            double[][] res = Arrays.copyOf(value, value.length);
            int matrixLeight = ((Matrix) other).getValue().length;
            double[][] z = new double[res.length][matrixLeight];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < matrixLeight; j++)
                    for (int k = 0; k < matrixLeight; k++) {
                        z[i][j] = z[i][j] + res[i][k] * ((Matrix) other).getValue()[k][j];

                    }
            }
            return new Matrix(z);
        }

        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = res[i][j] / ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        else if (other instanceof Vector) {
            double[][] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = res[i][j] / ((Vector) other).getValue()[j];
                }
            }
            return new Matrix(res);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{{");
        String delimetr = "";
        for (int i = 0; i < value.length; i++) {
            for (int s = 0; s < value[i].length; s++) {
                stringBuilder.append(delimetr).append(value[i][s]);
                delimetr = ", ";
                if(s == value[0].length-1 && i != value.length-1)
                    stringBuilder.append("}, {");
            }
            delimetr ="";
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

}

