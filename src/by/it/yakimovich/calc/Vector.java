package by.it.yakimovich.calc;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

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

    @Override
    public Var add(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++)
                res[i] = res[i] + ((Scalar) other).getValue();
                return new Vector(res);

        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            if (!(((Vector) other).getValue().length ==value.length))
                throw new CalcException("Разная длина векторов");
            for (int i = 0; i < res.length; i++)
                res[i] = res[i] + ((Vector) other).value[i];
                return new Vector(res);
            }
         else return super.add(other);

    }

    @Override
    public Var sub(Var other)throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++)
                res[i] = res[i] - ((Scalar) other).getValue();
            return new Vector(res);

        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            if (!(((Vector) other).getValue().length ==value.length))
                throw new CalcException("Разная длина векторов");
            for (int i = 0; i < res.length; i++)
                res[i] = res[i] - ((Vector) other).value[i];
            return new Vector(res);
        }



        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++)
                res[i] = res[i] * ((Scalar) other).getValue();
            return new Vector(res);

        } else if (other instanceof Vector) {
            double sum=0;
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i <res.length ; i++) {
                sum=sum+res[i]*((Vector) other).value[i];
            }

            return new Scalar(sum);
        }

        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++)
                res[i] = res[i] / ((Scalar) other).getValue();
            return new Vector(res);


    } return super.div(other);
}}


