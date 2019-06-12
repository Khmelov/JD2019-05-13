package by.it.aadamovich.jd01_08;

import java.util.Arrays;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);
        for (int i = 0; i < value.length; i++) {
            this.value[i] = Arrays.copyOf(value[i], value[i].length);
        }
    }

    Matrix(Matrix matrix) {
<<<<<<< HEAD
        this.value = Arrays.copyOf(matrix.value, matrix.value.length);
        for (int i = 0; i < matrix.value.length; i++) {
            this.value[i] = Arrays.copyOf(matrix.value[i], matrix.value.length);
        }
=======
        this.value = matrix.value;
>>>>>>> 3abf1a8c53a58aa3c04bb02acc8bea4f6e0447df
    }

    Matrix(String strMatrix) {

<<<<<<< HEAD
        String[] linesOfMatrix = strMatrix.replaceAll("[({|})].{0,2}[({|})]", "  ")
=======
        String[] linesOfMatrix = strMatrix
                .replaceAll("[({|})].{0,2}[({|})]", "  ")
>>>>>>> 3abf1a8c53a58aa3c04bb02acc8bea4f6e0447df
                .trim().split("[ ]{2,}");

        double[][] buffer = new double[linesOfMatrix.length][];

        for (int i = 0; i < buffer.length; i++) {
            String[] elementsInLine = linesOfMatrix[i].split("[^\\d.]+");
            buffer[i] = new double[elementsInLine.length];

            for (int j = 0; j < buffer[i].length; j++) {
                buffer[i][j] = Double.parseDouble(elementsInLine[j]);
            }
        }
        this.value = buffer;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[][] sum = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[0].length; j++) {
                    sum[i][j] = this.value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(sum);

        } else if (other instanceof Matrix && this.value.length == ((Matrix) other).value.length
                && this.value[0].length == ((Matrix) other).value[0].length) {
            double[][] sum = new double[this.value.length][this.value[0].length];

            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[0].length; j++) {
                    sum[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(sum);

        } else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] sub = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < sub.length; i++) {
                for (int j = 0; j < sub[0].length; j++) {
                    sub[i][j] = this.value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(sub);

        } else if (other instanceof Matrix && this.value.length == ((Matrix) other).value.length
                && this.value[0].length == ((Matrix) other).value[0].length) {
            double[][] sub = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < sub.length; i++) {
                for (int j = 0; j < sub[0].length; j++) {
                    sub[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(sub);

        } else return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] mul = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < mul[0].length; j++) {
                    mul[i][j] = this.value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(mul);

        } else if (other instanceof Vector && this.value[0].length == ((Vector) other).getValue().length) {
            double[] mul = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    mul[i] = mul[i] + this.value[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector(mul);

        } else if (other instanceof Matrix && this.value[0].length == ((Matrix) other).value.length) {
            double[][] mul = new double[this.value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < mul[0].length; j++) {
                    for (int k = 0; k < this.value[0].length; k++) {
                        mul[i][j] = mul[i][j] + this.value[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(mul);

        } else return super.mul(other);


    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar && ((Scalar) other).getValue() != 0) {
            double[][] div = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < div.length; i++) {
                for (int j = 0; j < div[0].length; j++) {
                    div[i][j] = this.value[i][j] / ((Scalar) other).getValue();
                }
            }
            return new Matrix(div);

        } else return super.div(other);


    }

    @Override
    public String toString() {

        StringBuilder strBuilder = new StringBuilder("{{");

        for (int i = 0; i < value.length; i++) {
            String delimiter = "";

            for (int j = 0; j < value[i].length; j++) {
                strBuilder.append(delimiter).append(value[i][j]);
                delimiter = ", ";
            }

            if (i == value.length - 1) {
                strBuilder.append("}}");
            } else {
                strBuilder.append("}, {");
            }
        }
        return strBuilder.toString();
    }
}
