package by.it.aadamovich.jd01_07;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value,vector.value.length);
    }

    Vector(String strVector) {
        String strVectorProcessed = strVector.replaceAll("[^\\d.]+", " ");

        String[] elements = strVectorProcessed.trim().split(" ");
        double[] buffer = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            buffer[i] = Double.parseDouble(elements[i]);
        }
        this.value = buffer;
    }

    @Override
    public String toString() {

        StringBuilder strBuilder = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            strBuilder.append(delimiter).append(element);
            delimiter = ", ";
        }

        return strBuilder.append("}").toString();
    }
}
