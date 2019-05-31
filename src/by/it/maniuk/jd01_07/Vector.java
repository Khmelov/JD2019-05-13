package by.it.maniuk.jd01_07;


import java.util.Arrays;

public class Vector extends Var{

    private double[] value;


    Vector(double[] value) {
        value = Arrays.copyOf(value, value.length);
        this.value = value;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        String str = strVector;
        str = str.replaceAll("\\{","").replaceAll("\\}","");
       str = str.replaceAll("\\,"," ");
        String[] s = str.trim().split(" ");
        double[] a = new double[s.length];
        for (int i = 0; i <s.length ; i++) {
             a[i] = Double.parseDouble( s[i]);
        }
        this.value = a;

   }


   @Override
    public String toString() {
        StringBuilder b = new StringBuilder("{");
        String delimeter = " ";
       for (int i = 0; i < value.length; i++) {
          double element = value[i];
           if (i==value.length-1)  b.append(element);
           else  b.append(element).append(",").append(delimeter);
       }
            b.append("}");
       return b.toString();
        }

    }


