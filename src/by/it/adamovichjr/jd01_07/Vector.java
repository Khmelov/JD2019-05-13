package by.it.adamovichjr.jd01_07;

public class Vector extends Var {

    private double []value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String str){
        str = str.replaceAll("[^\\d.]+"," ").trim();
        String[] split = str.split("[ ]+");
        double[]mas = new double[split.length];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = Double.parseDouble(split[i]);
        }
        this.value = mas;
    }



    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder("{");
       String delimiter = "";
        for (double el : value) {
            sb.append(delimiter).append(el);
            delimiter = ", ";
        }
        sb.append("}");

        return sb.toString();
    }
}
