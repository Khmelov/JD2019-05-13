package by.it.yakimovich.jd01_07;

public class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = value;
    }

    Vector(Vector vector){
        this.value =vector.value;

    }

    Vector(String strVector){
        strVector=strVector.replaceAll("\\{","");
        strVector=strVector.replaceAll("\\}","");
        String[] stre=strVector.split(",");
        double[] strV=new double[stre.length];
           for (int i = 0; i <stre.length ; i++) {
            strV[i] = Double.parseDouble(stre[i]);
        }
        this.value= strV;
    }


    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{");
        String delimeter="";
        for (double element:value) {
            sb.append(delimeter).append(element);
            delimeter=", ";


        }
        sb.append("}");
        return sb.toString();
    }
}
