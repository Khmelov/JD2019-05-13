package by.it.zhukova.jd01_09;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {
     private double [] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[ ] value) {
         this.value= Arrays.copyOf(value,value.length);//создаем новый массив
     }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            double [] add= Arrays.copyOf(value,value.length);
            for (int i = 0; i < add.length; i++) {
                add[i]+=((Scalar) other).getValue();
            }
            return new Vector(add);
        }
        else if (other instanceof Vector){
            double [] add= Arrays.copyOf(value,value.length);
            for (int i = 0; i < add.length; i++) {
                add[i]+=((Vector) other).value[i];
            }
            return new Vector(add);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double [] sub= Arrays.copyOf(value,value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i]-=((Scalar) other).getValue();
            }
            return new Vector(sub);
        }
        else if (other instanceof Vector){
            double [] sub= Arrays.copyOf(value,value.length);
            for (int i = 0; i < sub.length; i++) {
                sub[i]-=((Vector) other).value[i];
            }
            return new Vector(sub);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double [] mul= Arrays.copyOf(value,value.length);
            for (int i = 0; i < mul.length; i++) {
                mul[i]*=((Scalar) other).getValue();
            }
            return new Vector(mul);
        }
        else if (other instanceof Vector){
            double [] mul= Arrays.copyOf(value,value.length);
           double res = 0;
            for (int i = 0; i < mul.length; i++) {
               res=res+ mul[i]*((Vector) other).value[i];
            }
            return new Scalar(res);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            double [] div= Arrays.copyOf(value,value.length);
            for (int i = 0; i < div.length; i++) {
                div[i]/=((Scalar) other).getValue();
            }
            return new Vector(div);
        }

        return super.div(other);
    }

    Vector(Vector vector) {
        this.value=vector.value;
    }
    Vector(String strVector) {
        Pattern p2 = Pattern.compile("-?\\d+(\\.\\d+)?");
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
