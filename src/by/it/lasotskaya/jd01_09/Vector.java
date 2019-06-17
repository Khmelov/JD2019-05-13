package by.it.lasotskaya.jd01_09;


import java.util.Arrays;

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
    public Var add(Var other) {
        if (other instanceof Scalar){
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]= res[i] + ((Scalar)other).getValue();

            }
            return new Vector(res);
        }
        else if (other instanceof Vector){
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i] + ((Vector)other).value[i];

            }

            return new Vector(res);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i] - ((Scalar)other).getValue();

            }
            return new Vector(res);

        }
        else if (other instanceof Vector){
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i] - ((Vector)other).value[i];

            }
            return new Vector(res);


        }

        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            double [] res = Arrays.copyOf(value,value.length);
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i] * ((Scalar)other).getValue();

            }
            return new Vector(res);

        }
        else if (other instanceof Vector){
            double [] res = Arrays.copyOf(value,value.length);
            double sum=0;
            for (int i = 0; i < res.length; i++) {
                res[i]=res[i] * ((Vector)other).value[i];
                sum=sum +res[i];

            }
            return new Scalar(sum);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] / ((Scalar) other).getValue();

            }
            return new Vector(res);
        }
        return super.div(other);
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
