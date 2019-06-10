package by.it.buymistrov.jd01_07;


import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value;

    }

    Vector(Vector vector) {
        this.value = vector.value;

    }

    Vector(String strValue) {

        String[] str = strValue
                .replaceAll("[{},]", " ")
                .trim()
                .replaceAll("[ ]+", "%")
                .split("%");


        double[] strArray = new double[str.length];
        for (int i = 0; i < str.length; i++) {
            strArray[i] = Double.parseDouble(str[i]);
        }
        this.value = strArray;


    }


    @Override

    public String toString() {
        String out = Arrays.toString(value)
                .replaceAll("\\[", "{")
                .replaceAll("\\]", "}");
        return out;
    }


}
