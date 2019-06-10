package by.it.dilkevich.jd01_07;

import java.util.Arrays;

public class Vector extends Var {

    private double [] value;

    public Vector(double[ ] value){
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(Vector vector){
        this.value = vector.value;
    }

    public Vector(String strVector){
        String [] mas = strVector.split(",");
        for (int i = 0; i < mas.length; i++) {
            mas[i] = mas[i].replace("{", "").replace("}", "");
        }
        double [] tempMas = new double[mas.length];

        for (int i = 0; i < mas.length; i++) {
            tempMas[i] = Double.parseDouble(mas[i]);
        }
        value = Arrays.copyOf(tempMas, mas.length);
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimeter = "";
        for (double x :
                this.value) {
            sb.append(delimeter).append(x);
            delimeter = ", ";
        }

        sb.append("}");
        return sb.toString();
    }
}
