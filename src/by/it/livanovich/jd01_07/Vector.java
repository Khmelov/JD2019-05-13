package by.it.livanovich.jd01_07;

import java.util.Arrays;

class Vector extends Var{
        private double [] value;



    Vector(double [] value) {
        this.value = value;
    }

    Vector (Vector vector){
        this.value=vector.value;
    }

    Vector (String strVector){
     String [] str=strVector.replaceAll("\\D+"," ").trim().split(" ");
     double [] tempvalue=new double[str.length];
        for (int i = 0; i < str.length; i++) {
            tempvalue[i]=Double.parseDouble(str[i]);
        }
        this.value=tempvalue;
        }


    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("{");
        String delimiter="";
        for (double element:value){
            sb.append(delimiter).append(element);
            delimiter=", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
