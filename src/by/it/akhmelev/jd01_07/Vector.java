package by.it.akhmelev.jd01_07;

import java.util.Arrays;

public class Vector extends Var{

    private double[] value;

    void reset(){
        value[0]=0;
    }

    public Vector(double[] value) {
        super();
        this.value = Arrays.copyOf(value,value.length);
    }

    public Vector(Vector vector) {
        this(vector.value);
    }

    @Override
    public String toString() {
        StringBuilder out=new StringBuilder("{");
        String delimiter="";
        for (double element : value) {
            out.append(delimiter).append(element);
            delimiter=", ";
        }
        out.append("}");
        Arrays.toString(value);
        return out.toString();
    }
}
