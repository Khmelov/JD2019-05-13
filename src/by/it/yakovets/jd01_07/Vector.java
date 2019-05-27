package by.it.yakovets.jd01_07;

import java.util.Arrays;

public class Vector extends Var{
    private double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value,value.length);
    }
    public Vector(Vector vector){
        this.value=vector.value;
    }

    @Override
    public String toString() {
        return Arrays.toString(value);
    }
}
