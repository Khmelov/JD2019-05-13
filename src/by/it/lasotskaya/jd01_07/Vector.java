package by.it.lasotskaya.jd01_07;


public class Vector extends Var {
    private double[] value;


    Vector(double[] value){
        this.value= value;
    }

    Vector(Vector v){
        this.value=v.value;
    }

    Vector (String strVector){
        String[] strValues = strVector.replaceAll("[{}]", "").split(",");
        value = new double[strValues.length];
        for (int i = 0; i < value.length; i++) {
            value[i]=Double.parseDouble(strValues[i]);
        }
    }



    @Override
    public String toString() {
       StringBuilder stringBuilder=new StringBuilder("{");
       String delimeter ="";
       //double mas[] = new double[0];
        for (double element : value) {
            stringBuilder.append(delimeter).append(element);
            delimeter = ", ";
    }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }



}
