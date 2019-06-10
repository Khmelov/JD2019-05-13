package by.it.orlov.jd01_07;

import java.util.Arrays;

class Vector extends Var {

    private double[] v1;

    public Vector(double[] v1){
        this.v1 = v1;
    }

    public Vector(Vector vector){
        this.v1 = vector.v1;
    }
    public Vector(String strVector){
        String[] strM = strVector.replaceAll("[{}]", "").split(",");
        double[] vec = new double[strM.length];
        for (int i = 0; i < strM.length; i++) {
            vec[i] = Double.parseDouble(strM[i]);
        }
        this.v1 = Arrays.copyOf(vec, vec.length);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{");
        for (int i = 0; i < v1.length; i++) {
            if(i==v1.length-1){
                str.append(v1[i]+"}");
            }else{str.append(v1[i]+", ");}
        }
        return str.toString();
    }
}
