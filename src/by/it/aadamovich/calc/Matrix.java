package by.it.aadamovich.calc;

import by.it.aadamovich.calc.names.ResData;

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
        this.value = matrix.value;
    }

    Matrix(String strMatrix) throws CalcException{

        String[] linesOfMatrix = strMatrix.replaceAll("[{}].*?[{}]", "  ")
                .trim().split("[ ]{2,}");

        double[][] buffer = new double[linesOfMatrix.length][];

        for (int i = 0; i < buffer.length; i++) {
            String[] elementsInLine = linesOfMatrix[i].split("[^\\d.-]+");
            buffer[i] = new double[elementsInLine.length];
            if (i > 0 && buffer[i].length != buffer[i-1].length) {
                throw new CalcException (String.format
                        (ResourceManager.INSTANCE.getString
                                (ResData.VARIABLE_NOT_MATRIX), strMatrix));
            }

            for (int j = 0; j < buffer[i].length; j++) {
                buffer[i][j] = Double.parseDouble(elementsInLine[j]);
            }
        }
        this.value = buffer;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] sum = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum[0].length; j++) {
                    sum[i][j] = this.value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(sum);

        } else if (other instanceof Matrix) {

            if (this.value.length != ((Matrix) other).value.length
                    || this.value[0].length != ((Matrix) other).value[0].length)
                throw new CalcException(String.format(
                        ResourceManager.INSTANCE.getString
                                (ResData.SUM_MATRIX_MATRIX_SIZE), this, other));

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
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] sub = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < sub.length; i++) {
                for (int j = 0; j < sub[0].length; j++) {
                    sub[i][j] = this.value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(sub);

        } else if (other instanceof Matrix) {

            if (this.value.length != ((Matrix) other).value.length
                    || this.value[0].length != ((Matrix) other).value[0].length)
                throw new CalcException(String.format(
                        ResourceManager.INSTANCE.getString
                                (ResData.SUB_MATRIX_MATRIX_SIZE), this, other));

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
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[][] mul = new double[this.value.length][this.value[0].length];
            for (int i = 0; i < mul.length; i++) {
                for (int j = 0; j < mul[0].length; j++) {
                    mul[i][j] = this.value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(mul);

        } else if (other instanceof Vector) {

            if (this.value[0].length != ((Vector) other).getValue().length)
                throw new CalcException(String.format(
                        ResourceManager.INSTANCE.getString
                                (ResData.MUL_MATRIX_VECTOR_SIZE), this, other));

            double[] mul = new double[this.value.length];
            for (int i = 0; i < this.value.length; i++) {
                for (int j = 0; j < this.value[0].length; j++) {
                    mul[i] = mul[i] + this.value[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector(mul);

        } else if (other instanceof Matrix) {

            if (this.value[0].length != ((Matrix) other).value.length)
                throw new CalcException(String.format(
                        ResourceManager.INSTANCE.getString
                                (ResData.MUL_MATRIX_MATRIX_SIZE), this, other));

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
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {

            if (((Scalar) other).getValue() == 0) throw new CalcException
                    (ResourceManager.INSTANCE.getString(ResData.DIVISION_TO_ZERO));
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
