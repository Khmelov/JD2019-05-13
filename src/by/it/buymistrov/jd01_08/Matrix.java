package by.it.buymistrov.jd01_08;

import java.util.Arrays;


public class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = value;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;

    }

    Matrix(String strMatrix) {


        String[] stringMatrix = strMatrix.split("},\\{");
        String[] strLine = new String[stringMatrix.length];
        String[][] splittedStrLine = new String[strLine.length][strLine.length];


        for (int i = 0; i < strLine.length; i++) {
            strLine[i] = (stringMatrix[i].replaceAll("[\\,\\{\\}]", " ").trim());
            splittedStrLine[i] = strLine[i].split(" ");

        }

        double[][] strOut = new double[splittedStrLine.length][splittedStrLine.length];
        for (int i = 0; i < splittedStrLine.length; i++) {
            for (int j = 0; j < splittedStrLine.length; j++) {

                strOut[i][j] = Double.parseDouble(splittedStrLine[i][j]);
            }
        }


        this.value = strOut;

    }


    @Override
    public Var add(Var other) {


        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();

            double[][] result = Arrays.copyOf(value, value.length);

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] += s;
                }

            }
            return new Matrix(result);

        } else if (other instanceof Vector) {

            return super.add(other);

        } else if (other instanceof Matrix && value.length == ((Matrix) other).value.length) {

            double[][] rez = new double[value.length][value.length];

            for (int i = 0; i < rez.length; i++) {
                for (int j = 0; j < rez[i].length; j++) {
                    rez[i][j] = value[i][j] + ((Matrix) other).value[i][j];


                }

            }
            return new Matrix(rez);
        } else

            return super.add(other);
    }


    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();

            double[][] result = Arrays.copyOf(value, value.length);

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] -= s;
                }
            }
            return new Matrix(result);

        } else if (other instanceof Vector) {

            return super.sub(other);

        } else if (other instanceof Matrix && value.length == ((Matrix) other).value.length) {

            double[][] rez = new double[value.length][value.length];

            for (int i = 0; i < rez.length; i++) {
                for (int j = 0; j < rez[i].length; j++) {
                    rez[i][j] = value[i][j] - ((Matrix) other).value[i][j];

                }

            }
            return new Matrix(rez);
        } else


            return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();

            double[][] result = Arrays.copyOf(value, value.length);

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] *= s;
                }
            }
            return new Matrix(result);
        } else if (other instanceof Vector && ((Vector) other).getValue().length == value.length) {

            double[] rez = new double[value.length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < ((Vector) other).getValue().length; j++) {
                    rez[i] = rez[i] + value[i][j] * ((Vector) other).getValue()[j];

                }

            }
            return new Vector(rez);

        } else if (other instanceof Matrix && value.length == ((Matrix) other).value.length) {

            double[][] rez = new double[value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < ((Matrix) other).value[0].length; j++) {
                    for (int k = 0; k < ((Matrix) other).value.length; k++) {
                        rez[i][j] = rez[i][j] + value[i][k] * ((Matrix) other).value[k][j];

                    }

                }

            }

            return new Matrix(rez);
        } else

            return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar && ((Scalar) other).getValue() > 0) {
            double s = ((Scalar) other).getValue();

            double[][] result = Arrays.copyOf(value, value.length);

            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] /= s;
                }
            }
            return new Matrix(result);
        } else
            return super.div(other);
    }


    @Override
    public String toString() {


        String out = Arrays.deepToString(value)
                .replaceAll("\\[", "{")
                .replaceAll("\\]", "}");

        return out;

    }

}
