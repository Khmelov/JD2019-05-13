package by.it.yakovets.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private double[][] value;

    public Matrix(double[][] value) {
        double copy[][] = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; ++i) {
            System.arraycopy(value[i], 0, copy[i], 0, value[i].length);
        }

        this.value = copy;
    }

    public Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    public Matrix(String strMatrix) {
        String line = strMatrix.replaceAll("\\s", "");
        line = line.replaceAll("[\\{}]{2}", "");

        String[] masNstr = line.split("},\\{");
        int count = 0;

        for (int i = 0; i < masNstr.length; i++) {
            String arr[] = masNstr[i].split(",");
            count = arr.length;
        }
        double[][] mass = new double[masNstr.length][count];
        for (int i = 0; i < masNstr.length; i++) {
            String arr[] = masNstr[i].split(",");

            for (int i1 = 0; i1 < arr.length; i1++) {
                mass[i][i1] = Double.parseDouble(arr[i1]);
            }
        }
        this.value = Arrays.copyOf(mass, mass.length);
    }

    @Override
    public Var add(Var other) {
        double copy[][] = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; ++i) {
            System.arraycopy(value[i], 0, copy[i], 0, value[i].length);
        }
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();

            for (int i = 0; i < copy.length; i++) {
                for (int j = 0; j < copy[0].length; j++) {
                    copy[i][j] = copy[i][j] + s;
                }
            }
            return new Matrix(copy);
        } else if (other instanceof Matrix) {
            double[][] mat = ((Matrix) other).value;

            for (int i = 0; i < copy.length; i++) {
                for (int j = 0; j < copy[0].length; j++) {
                    copy[i][j] = copy[i][j] + mat[i][j];


                }
            }
            return new Matrix(copy);
        } else
            return super.add(other);

    }

    @Override
    public Var sub(Var other) {
        double copy[][] = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; ++i) {
            System.arraycopy(value[i], 0, copy[i], 0, value[i].length);
        }
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();

            for (int i = 0; i < copy.length; i++) {
                for (int j = 0; j < copy[0].length; j++) {
                    copy[i][j] = copy[i][j] - s;
                }
            }
            return new Matrix(copy);
        } else if (other instanceof Matrix) {
            double[][] mat = ((Matrix) other).value;

            for (int i = 0; i < copy.length; i++) {
                for (int j = 0; j < copy[0].length; j++) {
                    copy[i][j] = copy[i][j] - mat[i][j];
                }
            }
            return new Matrix(copy);
        } else
            return super.add(other);
    }

    @Override
    public Var mul(Var other) {
        double copy[][] = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; ++i) {
            System.arraycopy(value[i], 0, copy[i], 0, value[i].length);
        }
        if (other instanceof Scalar) {
            double s = ((Scalar) other).getValue();

            for (int i = 0; i < copy.length; i++) {
                for (int j = 0; j < copy[0].length; j++) {
                    copy[i][j] = copy[i][j] * s;
                }
            }
            return new Matrix(copy);
        } else if (other instanceof Matrix) {
            double[][] mat = ((Matrix) other).value;

            for (int i = 0; i < copy.length; i++) {
                for (int j = 0; j < copy[0].length; j++) {
                    copy[i][j] = copy[i][j] - mat[i][j];
                }
            }
            return new Matrix(copy);
        } else {
            double[] mat = ((Vector) other).value;
            double[][]res=new double[copy.length][mat.length];
            int icount=0;
            int jcount=0;
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res [0].length; j++) {
                    res[i][j] = copy[i][j]*mat[j];
                }
            }
            return new Vector(mat);

        }
    }
        @Override
        public String toString () {
            StringBuilder sb = new StringBuilder("{{");
            String del = "";
            for (int i = 0; i < value.length; i++) {
                for (int i1 = 0; i1 < value[0].length; i1++) {
                    sb.append(del).append(value[i][i1]);
                    del = ", ";
                }
                del = "}, {";
            }
            sb.append("}}");
            return sb.toString();
        }
    }
