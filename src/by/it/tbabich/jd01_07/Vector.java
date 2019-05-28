package by.it.tbabich.jd01_07;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(Vector vector) {
        this(vector.value);
    }

    Vector(String strVector) {
        String[] arrayString = strVector.replace("{","").replace("}","").split(",");
        double[] arrayDouble = new double[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            arrayDouble[i] = Double.parseDouble(arrayString[i]);
        }
        this.value = Arrays.copyOf(arrayDouble, arrayDouble.length);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < value.length; i++) {
            sb.append(value[i]);
            if (i == value.length - 1) {
                sb.append("}");
                break;
            }
            sb.append(", ");
        }
        return sb.toString();
    }
}
