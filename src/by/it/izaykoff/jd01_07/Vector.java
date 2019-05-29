package by.it.izaykoff.jd01_07;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double[] value){
        this.value = value;
    }

    Vector(Vector vector){


    }

    Vector(String strVector){
        String[] items = strVector.replaceAll("\\{","").replaceAll("[.0]","")
                .replaceAll("\\}","").split(",");
        value = new double[items.length];
        for (int i = 0; i < items.length; i++) {
            value[i] = Double.parseDouble(items[i]);
        }



    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimetr = "";
        for (double element : value) {
            sb.append(delimetr).append(element);
            delimetr = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
