package by.it.yakovets.jd01_07;

import java.util.Arrays;

public class Vector extends Var {
    private double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String strVector) {
        String line = strVector.replaceAll("[{},\\s]", " ");
        line = line.trim();
        String[] arr = line.split(" ");
        double[] mas = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            mas[i] = Double.parseDouble(arr[i]);
        }
        this.value = mas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String del = "";
        for (int i = 0; i < value.length; i++) {

            sb.append(del).append(value[i]);
            del = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
