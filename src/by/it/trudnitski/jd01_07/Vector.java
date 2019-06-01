package by.it.trudnitski.jd01_07;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value,value.length);
    }
    public Vector(Vector vector) {
        this(vector.value);
    }
    public Vector(String strVector) {
        strVector=strVector.replaceAll("[^\\d.]+"," ").trim();
        String [] line=strVector.split("[ ]+");
        double[] res = new double[line.length];
        for (int i = 0; i <res.length ; i++) {
            res[i]=Double.parseDouble(line[i]);
        }
        this.value=res;
    }
    @Override
    public String toString() {
        StringBuilder out= new StringBuilder("{");
        String delimeter="";
        for (double element : value) {
            out.append(delimeter).append(element);
            delimeter=", ";
        }
        out.append("}");
        Arrays.toString(value);
        return out.toString();
    }
}
