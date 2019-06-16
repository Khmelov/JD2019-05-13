package by.it.zhukova.jd01_07;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {
     private double [] value;
      Vector(double[ ] value) {
         this.value= Arrays.copyOf(value,value.length);//создаем новый массив
     }
    Vector(Vector vector) {
        this.value=vector.value;
    }
    Vector(String strVector) {
        Pattern p2 = Pattern.compile("\\d+\\.*\\d*");
        Matcher m2 = p2.matcher(strVector);
        int k=0;
        while (m2.find()){
            k++;
        }
        m2.reset();
        double [ ] vectorResult = new double[k];
        int j=0;
        while (m2.find()){
            vectorResult[j]=Double.parseDouble(m2.group());
            j++;
        }
        this.value= vectorResult;
    }

    @Override
    public String toString() {
          StringBuilder out = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            out.append(delimiter).append(element);
            delimiter = ", ";
        }
        out.append("}");
        return out.toString();
    }
}
